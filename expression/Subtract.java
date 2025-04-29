package expression;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;

public class Subtract extends Operation {

    public Subtract (MathObject leftObject, MathObject rightObject) {
        super(leftObject, rightObject);
    }

    public Type getType() {
        return this.getClass();
    }

    @Override
    public int evaluate(int value) {
        return leftObject.evaluate(value) - rightObject.evaluate(value);
    }

    @Override
    public String toString() {
        return new String('(' + leftObject.toString() + " - " + rightObject.toString() + ")");
    }

    @Override
    public boolean equals(Object Expr) {
        return  Expr instanceof Subtract &&
                leftObject.equals(((Subtract)Expr).getLeft()) &&
                rightObject.equals(((Subtract)Expr).getRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftObject.hashCode(), rightObject.hashCode(), getType());
    }

    @Override
    public String toMiniString() {
        StringBuilder st = new StringBuilder();

        st.append(leftObject.toMiniString());

        st.append(" - ");

        if (rightObject instanceof Const
                || rightObject instanceof Variable
                || rightObject instanceof Multiply
                || rightObject instanceof Divide) {
            st.append(rightObject.toMiniString());
        } else {
            st.append("(" + rightObject.toMiniString() + ")");
        }
        return st.toString();
    }

    @Override
    public long evaluateL(Map<String, Long> values) {
        return leftObject.evaluateL(values) - rightObject.evaluateL(values);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return leftObject.evaluate(x, y, z) - rightObject.evaluate(x, y, z);
    }
}