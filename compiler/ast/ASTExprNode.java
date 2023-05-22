package compiler.ast;

import compiler.info.ConstInfo;

import java.io.OutputStreamWriter;

public abstract class ASTExprNode extends ASTNode {
    public abstract void print(OutputStreamWriter outStream, String indent) throws Exception;
    public abstract int eval();

    // TODO: make this abstract when every subclass implemented this.
    public ConstInfo constFold() {
        return new ConstInfo(false, 0);
    }
    
}
