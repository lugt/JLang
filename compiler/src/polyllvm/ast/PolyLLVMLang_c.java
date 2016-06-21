package polyllvm.ast;

import polyglot.ast.Ext;
import polyglot.ast.JLang_c;
import polyglot.ast.Lang;
import polyglot.ast.Node;
import polyglot.ast.NodeOps;
import polyglot.util.InternalCompilerError;
import polyllvm.ast.PseudoLLVM.Expressions.LLVMLabel;
import polyllvm.visit.AddVoidReturnVisitor;
import polyllvm.visit.PrintVisitor;
import polyllvm.visit.PseudoLLVMTranslator;
import polyllvm.visit.StringLiteralRemover;

public class PolyLLVMLang_c extends JLang_c implements PolyLLVMLang {
    public static final PolyLLVMLang_c instance = new PolyLLVMLang_c();

    public static PolyLLVMLang lang(NodeOps n) {
        while (n != null) {
            Lang lang = n.lang();
            if (lang instanceof PolyLLVMLang) return (PolyLLVMLang) lang;
            if (n instanceof Ext)
                n = ((Ext) n).pred();
            else return null;
        }
        throw new InternalCompilerError("Impossible to reach");
    }

    protected PolyLLVMLang_c() {
    }

    protected static PolyLLVMExt polyllvmExt(Node n) {
        return PolyLLVMExt.ext(n);
    }

    @Override
    protected NodeOps NodeOps(Node n) {
        return polyllvmExt(n);
    }

    protected PolyLLVMOps PolyLLVMOps(Node n) {
        return polyllvmExt(n);
    }

    @Override
    public final Node print(Node n, PrintVisitor v) {
        return PolyLLVMOps(n).print(v);
    }

    @Override
    public Node removeStringLiterals(Node n, StringLiteralRemover v) {
        return PolyLLVMOps(n).removeStringLiterals(v);
    }

    @Override
    public PseudoLLVMTranslator enterTranslatePseudoLLVM(Node n,
            PseudoLLVMTranslator v) {
        return PolyLLVMOps(n).enterTranslatePseudoLLVM(v);
    }

    @Override
    public Node translatePseudoLLVM(Node n, PseudoLLVMTranslator v) {
        return PolyLLVMOps(n).translatePseudoLLVM(v);
    }

    @Override
    public Node addVoidReturn(Node n, AddVoidReturnVisitor v) {
        return PolyLLVMOps(n).addVoidReturn(v);
    }

    @Override
    public Node translatePseudoLLVMConditional(Node n, PseudoLLVMTranslator v,
            LLVMLabel trueLabel, LLVMLabel falseLabel) {
        return PolyLLVMOps(n).translatePseudoLLVMConditional(v,
                                                             trueLabel,
                                                             falseLabel);
    }

}
