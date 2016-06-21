package polyllvm.ast.PseudoLLVM.Expressions;

import polyglot.ast.Ext;
import polyglot.util.Position;
import polyglot.util.SerialVersionUID;

public abstract class LLVMOperand_c extends LLVMExpr_c implements LLVMOperand {
    private static final long serialVersionUID = SerialVersionUID.generate();

    public LLVMOperand_c(Position pos, Ext e) {
        super(pos, e);
    }

}
