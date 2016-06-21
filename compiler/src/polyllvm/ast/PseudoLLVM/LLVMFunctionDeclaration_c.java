package polyllvm.ast.PseudoLLVM;

import java.util.List;

import polyglot.ast.Ext;
import polyglot.util.CodeWriter;
import polyglot.util.Position;
import polyglot.util.SerialVersionUID;
import polyglot.visit.PrettyPrinter;
import polyllvm.ast.PseudoLLVM.LLVMTypes.LLVMTypeNode;

public class LLVMFunctionDeclaration_c extends LLVMNode_c
        implements LLVMFunctionDeclaration {
    private static final long serialVersionUID = SerialVersionUID.generate();

    protected String function;
    protected List<LLVMArgDecl> args;
    protected LLVMTypeNode retType;

    public LLVMFunctionDeclaration_c(Position pos, String function,
            List<LLVMArgDecl> args, LLVMTypeNode retType, Ext e) {
        super(pos, e);
        this.function = function;
        this.args = args;
        this.retType = retType;
    }

    @Override
    public void prettyPrint(CodeWriter w, PrettyPrinter pp) {
        w.write("declare ");
        print(retType, w, pp);
        w.write(" @" + function);
        w.write("(");
        for (int i = 0; i < args.size() - 1; i++) {
            print(args.get(i), w, pp);
            w.write(", ");
        }
        if (args.size() != 0) {
            print(args.get(args.size() - 1), w, pp);
        }
        w.write(")\n");
    }

}
