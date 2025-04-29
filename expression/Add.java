package expression;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;

public class Add extends Operation implements Expression {
    public Add(MathObject leftObject, MathObject rightObject) {
        super(leftObject, rightObject);
    }

    public Type getType() {
        return this.getClass();
    }

    @Override
    public int evaluate(int value) {
        return leftObject.evaluate(value) + rightObject.evaluate(value);
    }

    @Override
    public String toString() {
        return new String('(' + leftObject.toString() + " + " + rightObject.toString() + ")");
    }

    @Override
    public boolean equals(Object Expr) {
        return Expr instanceof Add &&
                leftObject.equals(((Add) Expr).getLeft()) &&
                rightObject.equals(((Add) Expr).getRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftObject.hashCode(), rightObject.hashCode(), getType());
    }

    @Override
    public String toMiniString() {
        return leftObject.toMiniString() + " + " + rightObject.toMiniString();
    }

    @Override
    public long evaluateL(Map<String, Long> values) {
        return leftObject.evaluateL(values) + rightObject.evaluateL(values);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return leftObject.evaluate(x, y, z) + rightObject.evaluate(x, y, z);
    }
}
