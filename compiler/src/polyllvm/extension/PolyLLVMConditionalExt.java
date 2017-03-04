package polyllvm.extension;

import polyglot.ast.Conditional;
import polyglot.ast.Expr;
import polyglot.ast.Node;
import polyllvm.ast.PolyLLVMExt;
import polyllvm.visit.LLVMTranslator;

import java.util.function.BiConsumer;

import static org.bytedeco.javacpp.LLVM.*;

public class PolyLLVMConditionalExt extends PolyLLVMExt {

    @Override
    public Node overrideTranslatePseudoLLVM(LLVMTranslator v) {
        Conditional n = (Conditional) node();

        v.debugInfo.emitLocation(n);

        LLVMBasicBlockRef currentBlock = LLVMGetInsertBlock(v.builder);
        LLVMBasicBlockRef firstBlock = LLVMGetFirstBasicBlock(v.currFn());
        LLVMPositionBuilderBefore(v.builder,LLVMGetBasicBlockTerminator(firstBlock));
        LLVMValueRef conditionalTemp = LLVMBuildAlloca(v.builder, v.utils.typeRef(n.type()), "conditional_temp");
        LLVMPositionBuilderAtEnd(v.builder, currentBlock);

        LLVMBasicBlockRef ifEnd = LLVMAppendBasicBlockInContext(v.context, v.currFn(), "conditional_end");
        LLVMBasicBlockRef ifTrue = LLVMAppendBasicBlockInContext(v.context, v.currFn(), "conditional_true");
        LLVMBasicBlockRef ifFalse = LLVMAppendBasicBlockInContext(v.context, v.currFn(), "conditional_false");

        lang().translateLLVMConditional(n.cond(), v, ifTrue, ifFalse);

        BiConsumer<LLVMBasicBlockRef, Expr> emitBlock = (block, expr) -> {
            LLVMPositionBuilderAtEnd(v.builder, block);
            v.visitEdge(n, expr);
            LLVMBuildStore(v.builder, v.getTranslation(expr), conditionalTemp);
            LLVMBasicBlockRef blockEnd = LLVMGetInsertBlock(v.builder);
            if (LLVMGetBasicBlockTerminator(blockEnd) == null) {
                LLVMBuildBr(v.builder, ifEnd);
            }
        };

        emitBlock.accept(ifTrue, n.consequent());
        emitBlock.accept(ifFalse, n.alternative());
        LLVMPositionBuilderAtEnd(v.builder, ifEnd);

        v.addTranslation(n, LLVMBuildLoad(v.builder, conditionalTemp, "load_conditional_temp"));

        return n;
    }
}