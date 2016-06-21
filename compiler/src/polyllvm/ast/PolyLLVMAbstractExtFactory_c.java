package polyllvm.ast;

import polyglot.ast.AbstractExtFactory_c;
import polyglot.ast.Ext;
import polyglot.ast.ExtFactory;

public abstract class PolyLLVMAbstractExtFactory_c extends AbstractExtFactory_c
        implements PolyLLVMExtFactory {

    public PolyLLVMAbstractExtFactory_c() {
        super();
    }

    public PolyLLVMAbstractExtFactory_c(ExtFactory nextExtFactory) {
        super(nextExtFactory);
    }

    // TODO: Implement factory methods for new extension nodes in future
    // extensions.  This entails calling the factory method for extension's
    // AST superclass.

    @Override
    public final Ext extLLVMNode() {
        Ext e = extLLVMNodeImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMNode();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMNode(e);
    }

    protected Ext extLLVMNodeImpl() {
        return extNodeImpl();
    }

    protected Ext postExtLLVMNode(Ext e) {
        return postExtNode(e);
    }

    @Override
    public final Ext extLLVMInstruction() {
        Ext e = extLLVMInstructionImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMInstruction();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMInstruction(e);
    }

    protected Ext extLLVMInstructionImpl() {
        return extNodeImpl();
    }

    protected Ext postExtLLVMInstruction(Ext e) {
        return postExtNode(e);
    }

    @Override
    public final Ext extLLVMBinaryOperandInstruction() {
        Ext e = extLLVMBinaryOperandInstructionImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMBinaryOperandInstruction();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMBinaryOperandInstruction(e);
    }

    protected Ext extLLVMBinaryOperandInstructionImpl() {
        return extLLVMInstructionImpl();
    }

    protected Ext postExtLLVMBinaryOperandInstruction(Ext e) {
        return postExtLLVMInstruction(e);
    }

    @Override
    public final Ext extLLVMAdd() {
        Ext e = extLLVMAddImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMAdd();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMAdd(e);
    }

    protected Ext extLLVMAddImpl() {
        return extLLVMBinaryOperandInstructionImpl();
    }

    protected Ext postExtLLVMAdd(Ext e) {
        return postExtLLVMBinaryOperandInstruction(e);
    }

    @Override
    public final Ext extLLVMIntLiteral() {
        Ext e = extLLVMIntLiteralImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMIntLiteral();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMIntLiteral(e);
    }

    protected Ext extLLVMIntLiteralImpl() {
        return extNode();
    }

    protected Ext postExtLLVMIntLiteral(Ext e) {
        return postExtNode(e);
    }

    @Override
    public final Ext extLLVMIntType() {
        Ext e = extLLVMIntTypeImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMIntType();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMIntType(e);
    }

    protected Ext extLLVMIntTypeImpl() {
        return extNode();
    }

    protected Ext postExtLLVMIntType(Ext e) {
        return postExtNode(e);
    }

    @Override
    public final Ext extLLVMVariable() {
        Ext e = extLLVMVariableImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMVariable();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMVariable(e);
    }

    protected Ext extLLVMVariableImpl() {
        return extNode();
    }

    protected Ext postExtLLVMVariable(Ext e) {
        return postExtNode(e);
    }

    @Override
    public final Ext extLLVMBlock() {
        Ext e = extLLVMBlockImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMBlock();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMBlock(e);
    }

    protected Ext extLLVMBlockImpl() {
        return extNode();
    }

    protected Ext postExtLLVMBlock(Ext e) {
        return postExtNode(e);
    }

    @Override
    public final Ext extLLVMFunction() {
        Ext e = extLLVMFunctionImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMFunction();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMFunction(e);
    }

    protected Ext extLLVMFunctionImpl() {
        return extLLVMNode();
    }

    protected Ext postExtLLVMFunction(Ext e) {
        return postExtLLVMNode(e);
    }

    @Override
    public final Ext extLLVMArgDecl() {
        Ext e = extLLVMArgDeclImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMFunction();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMArgDecl(e);
    }

    protected Ext extLLVMArgDeclImpl() {
        return extLLVMNode();
    }

    protected Ext postExtLLVMArgDecl(Ext e) {
        return postExtLLVMNode(e);
    }

    @Override
    public final Ext extLLVMVoidType() {
        Ext e = extLLVMVoidTypeImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMVoidType();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMVoidType(e);
    }

    protected Ext extLLVMVoidTypeImpl() {
        return extLLVMNode();
    }

    protected Ext postExtLLVMVoidType(Ext e) {
        return postExtLLVMNode(e);
    }

    @Override
    public final Ext extLLVMRet() {
        Ext e = extLLVMRetImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMRet();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMRet(e);
    }

    protected Ext extLLVMRetImpl() {
        return extLLVMInstructionImpl();
    }

    protected Ext postExtLLVMRet(Ext e) {
        return postExtLLVMInstruction(e);
    }

    @Override
    public final Ext extLLVMSourceFile() {
        Ext e = extLLVMSourceFileImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMSourceFile();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMSourceFile(e);
    }

    protected Ext extLLVMSourceFileImpl() {
        return extLLVMNodeImpl();
    }

    protected Ext postExtLLVMSourceFile(Ext e) {
        return postExtLLVMNode(e);
    }

    @Override
    public final Ext extLLVMCall() {
        Ext e = extLLVMCallImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMCall();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMCall(e);
    }

    protected Ext extLLVMCallImpl() {
        return extLLVMInstructionImpl();
    }

    protected Ext postExtLLVMCall(Ext e) {
        return postExtLLVMInstruction(e);
    }

    @Override
    public Ext extLLVMFunctionDeclaration() {
        Ext e = extLLVMFunctionDeclarationImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMFunctionDeclaration();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMFunctionDeclaration(e);

    }

    protected Ext extLLVMFunctionDeclarationImpl() {
        return extLLVMNodeImpl();
    }

    protected Ext postExtLLVMFunctionDeclaration(Ext e) {
        return postExtLLVMNode(e);
    }

    @Override
    public Ext extLLVMLabel() {
        Ext e = extLLVMLabelImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMLabel();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMLabel(e);

    }

    protected Ext extLLVMLabelImpl() {
        return extLLVMExprImpl();
    }

    protected Ext postExtLLVMLabel(Ext e) {
        return postExtLLVMExpr(e);
    }

    @Override
    public Ext extLLVMExpr() {
        Ext e = extLLVMExprImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMExpr();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMExpr(e);

    }

    protected Ext extLLVMExprImpl() {
        return extLLVMNodeImpl();
    }

    protected Ext postExtLLVMExpr(Ext e) {
        return postExtLLVMNode(e);
    }

    @Override
    public Ext extLLVMTypedOperand() {
        Ext e = extLLVMTypedOperandImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMTypedOperand();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMTypedOperand(e);

    }

    protected Ext extLLVMTypedOperandImpl() {
        return extLLVMOperandImpl();
    }

    protected Ext postExtLLVMTypedOperand(Ext e) {
        return postExtLLVMOperand(e);
    }

    @Override
    public Ext extLLVMOperand() {
        Ext e = extLLVMOperandImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMOperand();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMOperand(e);

    }

    protected Ext extLLVMOperandImpl() {
        return extLLVMExprImpl();
    }

    protected Ext postExtLLVMOperand(Ext e) {
        return postExtLLVMExpr(e);
    }

    @Override
    public Ext extLLVMBr() {
        Ext e = extLLVMBrImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMBr();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMBr(e);

    }

    protected Ext extLLVMBrImpl() {
        return extLLVMInstructionImpl();
    }

    protected Ext postExtLLVMBr(Ext e) {
        return postExtLLVMInstruction(e);
    }

    @Override
    public Ext extLLVMSeq() {
        Ext e = extLLVMSeqImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMSeq();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMSeq(e);

    }

    protected Ext extLLVMSeqImpl() {
        return extLLVMInstructionImpl();
    }

    protected Ext postExtLLVMSeq(Ext e) {
        return postExtLLVMInstruction(e);
    }

    @Override
    public Ext extLLVMSeqLabel() {
        Ext e = extLLVMSeqLabelImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMSeqLabel();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMSeqLabel(e);

    }

    protected Ext extLLVMSeqLabelImpl() {
        return extLLVMInstructionImpl();
    }

    protected Ext postExtLLVMSeqLabel(Ext e) {
        return postExtLLVMInstruction(e);
    }

    @Override
    public Ext extLLVMCmp() {
        Ext e = extLLVMCmpImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMCmp();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMCmp(e);

    }

    protected Ext extLLVMCmpImpl() {
        return extLLVMBinaryOperandInstructionImpl();
    }

    protected Ext postExtLLVMCmp(Ext e) {
        return postExtLLVMBinaryOperandInstruction(e);
    }

    @Override
    public Ext extLLVMICmp() {
        Ext e = extLLVMICmpImpl();

        ExtFactory nextEF = nextExtFactory();
        Ext e2;
        if (nextEF instanceof PolyLLVMExtFactory) {
            e2 = ((PolyLLVMExtFactory) nextEF).extLLVMICmp();
        }
        else {
            e2 = nextEF.extNode();
        }
        e = composeExts(e, e2);
        return postExtLLVMICmp(e);

    }

    protected Ext extLLVMICmpImpl() {
        return extLLVMCmpImpl();
    }

    protected Ext postExtLLVMICmp(Ext e) {
        return postExtLLVMCmp(e);
    }

}
