package chapter3;

public class FunctionalInterface {

    public static void main(String[] args) {

        Runnable runnable1 = () -> System.out.println("Hello World1");
        runnable1.run();

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World2");
            }
        };
        runnable2.run();

        process(() -> System.out.println("Hello World3"));
    }

    private static void process(Runnable runnable) {
        runnable.run();
    }

}
