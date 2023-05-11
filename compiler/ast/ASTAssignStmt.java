package compiler.ast;

import compiler.Symbol;

import java.io.OutputStreamWriter;

public class ASTAssignStmt extends ASTStmtNode {
    private final Symbol symbol;
    private final ASTExprNode expression;

    public ASTAssignStmt(Symbol symbol, ASTExprNode expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    @Override
    public void print(OutputStreamWriter outStream, String indent) throws Exception {
        outStream.write(indent + "Assign " + this.symbol.m_name + "\n");
        indent += "    ";
        this.expression.print(outStream, indent);       
    }

    @Override
    public void execute() {
        this.symbol.m_number = this.expression.eval();
    }

    public compiler.InstrIntf codegen(compiler.CompileEnvIntf env) {
        compiler.InstrIntf expr = this.expression.codegen(env);
        compiler.InstrIntf instr = new compiler.instr.InstrAssignStmt(symbol, expr);
        env.addInstr(instr);
        return instr;
    }
}
