package polyllvm.ast;

import polyglot.ast.Ext;
import polyglot.ast.ExtFactory;

/**
 * Extension factory for polyllvm extension.
 */
public interface PolyLLVMExtFactory extends ExtFactory {
    // TODO: Declare any factory methods for new extension nodes.

    Ext extLLVMNode();

    Ext extLLVMInstruction();

    Ext extLLVMBinaryOperandInstruction();

    Ext extLLVMAdd();

    Ext extLLVMIntLiteral();

    Ext extLLVMIntType();

    Ext extLLVMVariable();

    Ext extLLVMBlock();

    Ext extLLVMFunction();

    Ext extLLVMArgDecl();

    Ext extLLVMVoidType();

    Ext extLLVMRet();

    Ext extLLVMSourceFile();

    Ext extLLVMCall();

    Ext extLLVMFunctionDeclaration();

    Ext extLLVMLabel();

    Ext extLLVMExpr();

    Ext extLLVMTypedOperand();

    Ext extLLVMBr();

    Ext extLLVMOperand();

    Ext extLLVMSeq();

    Ext extLLVMSeqLabel();

    Ext extLLVMCmp();

    Ext extLLVMICmp();

}
