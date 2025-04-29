package expression;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;

public class Multiply extends Operation {

    public Multiply(MathObject leftObject, MathObject rightObject) {
        super(leftObject, rightObject);
    }

    public Type getType() {
        return this.getClass();
    }

    @Override
    public int evaluate(int value) {
        return leftObject.evaluate(value) * rightObject.evaluate(value);
    }

    @Override
    public String toString() {
        return new String('(' + leftObject.toString() + " * " + rightObject.toString() + ")");
    }

    @Override
    public boolean equals(Object Expr) {
        return Expr instanceof Multiply &&
                leftObject.equals(((Multiply) Expr).getLeft()) &&
                rightObject.equals(((Multiply) Expr).getRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftObject.hashCode(), rightObject.hashCode(), getType());
    }

    @Override
    public String toMiniString() {
        // to abstract class
        StringBuilder st = new StringBuilder();
        if (leftObject instanceof Multiply
                || leftObject instanceof Divide
                || leftObject instanceof Const
                || leftObject instanceof Variable) {
            st.append(leftObject.toMiniString());
        } else {
            st.append("(" + leftObject.toMiniString() + ")");
        }

        st.append(" * ");

        if (rightObject instanceof Const
                || rightObject instanceof Variable
                || rightObject instanceof Multiply) {
            st.append(rightObject.toMiniString());
        } else {
            st.append("(" + rightObject.toMiniString() + ")");
        }
        return st.toString();
    }

    @Override
    public long evaluateL(Map<String, Long> values) {
        return leftObject.evaluateL(values) * rightObject.evaluateL(values);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return leftObject.evaluate(x, y, z) * rightObject.evaluate(x, y, z);
    }
}
