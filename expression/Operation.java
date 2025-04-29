package expression;

import java.util.Map;

public abstract class Operation implements MathObject, Expression, LongMapExpression, TripleExpression {
    public MathObject leftObject;
    public MathObject rightObject;

    public Operation(MathObject leftObject, MathObject rightObject) {
        this.leftObject = leftObject;
        this.rightObject = rightObject;
    }

    public MathObject getLeft() {
        return leftObject;
    }
    
    public MathObject getRight() {
        return rightObject;
    }

    @Override
    public abstract int evaluate(int value);

    @Override
    public abstract int evaluate(int x, int y, int z);

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object Expr);

    @Override
    public abstract String toMiniString();

    @Override
    public abstract long evaluateL(Map<String, Long> values);
}
