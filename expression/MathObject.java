package expression;

import java.util.Map;

public interface MathObject {
    public int evaluate(int value);
    public int evaluate(int x, int y, int z);
    public String toString();
    public boolean equals(Object Expr);
    public String toMiniString();
    public long evaluateL(Map <String, Long> values);
}