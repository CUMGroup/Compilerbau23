package compiler.instr;

import java.io.OutputStreamWriter;

import compiler.ExecutionEnvIntf;
import compiler.InstrIntf;
import compiler.Symbol;

public class InstrAssignStmt extends compiler.InstrIntf {

    private final Symbol _symbol;
    private final InstrIntf _expression;

    public InstrAssignStmt(Symbol symbol, InstrIntf expression) {
        this._symbol = symbol;
        this._expression = expression;
    }

    @Override
    public void execute(ExecutionEnvIntf env) {
        _symbol.m_number = _expression.getValue();
    }

    @Override
    public void trace(OutputStreamWriter os) throws Exception {
        os.write("Store " + _symbol.m_name + ", " + _expression.getValue() + '\n');
    }

}