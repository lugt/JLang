package polyllvm.extension;

import polyglot.ast.ClassDecl;
import polyglot.ast.Node;
import polyglot.types.Type;
import polyglot.util.SerialVersionUID;
import polyllvm.ast.PolyLLVMExt;
import polyllvm.ast.PolyLLVMNodeFactory;
import polyllvm.ast.PseudoLLVM.*;
import polyllvm.visit.PseudoLLVMTranslator;

import java.util.ArrayList;
import java.util.List;

public class PolyLLVMClassDeclExt extends PolyLLVMExt {
    private static final long serialVersionUID = SerialVersionUID.generate();

    @Override
    public PseudoLLVMTranslator enterTranslatePseudoLLVM(PseudoLLVMTranslator v) {
        v.enterClass((ClassDecl) node());
        return super.enterTranslatePseudoLLVM(v);
    }

    @Override
    public Node translatePseudoLLVM(PseudoLLVMTranslator v) {
        ClassDecl n = (ClassDecl) node();
        PolyLLVMNodeFactory nf = v.nodeFactory();

        List<LLVMFunction> funcs = new ArrayList<>();
        List<LLVMFunctionDeclaration> funcDecls = new ArrayList<>();
        List<LLVMGlobalDeclaration> globals = new ArrayList<>();

        // External class object declarations.
        Type superType = n.type().superType();
        while (superType != null) {
            LLVMGlobalVarDeclaration decl =
                    ClassObjects.classIdDecl(nf, superType.toReference(), /* extern */ true);
            v.addStaticVarReferenced(decl.name(), decl);
            superType = superType.toReference().superType();
        }
        n.interfaces().stream().map(tn -> tn.type().toReference())
                               .map(rt -> ClassObjects.classIdDecl(nf, rt, /* extern */ true))
                               .forEach(decl -> v.addStaticVarReferenced(decl.name(), decl));

        // Class object for this class.
        globals.add(ClassObjects.classIdDecl(nf, n.type().toReference(), /* extern */ false));
        globals.add(ClassObjects.classObj(nf, n.type().toReference()));

        LLVMSourceFile llf = nf.LLVMSourceFile(null, null, funcs, funcDecls, globals);
        v.addTranslation(n, llf);
        v.leaveClass();
        return super.translatePseudoLLVM(v);
    }


    @Override
    public Node overrideTranslatePseudoLLVM(PseudoLLVMTranslator v) {
        ClassDecl n = (ClassDecl) node();
        if (n.flags().isInterface()) {
            // Interfaces need only declare a class id.
            PolyLLVMNodeFactory nf = v.nodeFactory();
            LLVMGlobalVarDeclaration classIdDecl =
                    ClassObjects.classIdDecl(nf, n.type().toReference(), /* extern */ false);
            v.addStaticVarReferenced(classIdDecl.name(), classIdDecl);
            return n;
        }
        return super.overrideTranslatePseudoLLVM(v);

    }
}
