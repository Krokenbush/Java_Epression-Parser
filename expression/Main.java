package expression;

public class Main {
    public static void main(String[] args) {
        int h1 = new Divide(new Variable("x"), new Const(-2)).hashCode();
        int h2 = new Divide(new Variable("x"), new Const(1)).hashCode();
        System.out.println(new Const(-2).hashCode());
        System.out.println(new Const(1).hashCode());
    }
}