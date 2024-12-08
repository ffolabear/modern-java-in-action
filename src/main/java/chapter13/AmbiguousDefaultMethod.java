package chapter13;

public class AmbiguousDefaultMethod {

    public static void main(String[] args) {
        C c = new C();
        c.hello();
    }

    interface A {

        default void hello() {
            System.out.println("Hello from A");
        }

    }

    interface B {

        default void hello() {
            System.out.println("Hello from B");
        }

    }

    static class C implements B, A {

        @Override
        public void hello() {
            A.super.hello();
        }

    }

}
