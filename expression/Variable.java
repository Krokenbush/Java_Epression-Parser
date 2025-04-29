package expression;

import java.util.Map;
import java.util.Objects;

public class Variable implements MathObject, Expression, LongMapExpression, TripleExpression {
    private final String var;

    public Variable (String var) {
        this.var = var;
    } 

    public String getVarName() {
        return var;
    }

    @Override
    public int evaluate(int value) {
        return value;
    }

    @Override
    public String toString() {
        return var;
    }

    @Override
    public boolean equals(Object Expr) {
        return  Expr instanceof Variable &&
                var.equals(((Variable)Expr).getVarName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(var);
    }

    @Override
    public String toMiniString() {
        return getVarName();
    }

    @Override
    public long evaluateL(Map<String, Long> values) {
        return values.get(getVarName());
    }

    @Override
    public int evaluate(int x, int y, int z) {
        if (getVarName().equals("x")) {
            return x;
        } else if (getVarName().equals("y")) {
            return y;
        } else {
            return z;
        }
    }
}
