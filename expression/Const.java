package expression;

import java.util.Map;
import java.util.Objects;

public class Const implements MathObject, Expression, LongMapExpression, TripleExpression {
    private final Long val;

    public Const (long val) {
        this.val = val; 
    }
    public Const (int val) {
        this.val = Long.valueOf(val);
    }

    public int getVal() {
        return val.intValue();
    }

    @Override
    public int evaluate(int value) {
        return val.intValue();
    }

    @Override
    public String toString() {
        return new String(Long.toString(val));
    }

    @Override
    public boolean equals(Object Expr) {
        return  Expr instanceof Const &&
                val.intValue() == ((Const)Expr).getVal();
    }

    @Override
    public int hashCode() {
        return Objects.hash(val * 31L);
    }

    @Override
    public String toMiniString() {
        return Long.toString(val);
    }

    @Override
    public long evaluateL(Map<String, Long> values) {
        return val;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return val.intValue();
    }
}
