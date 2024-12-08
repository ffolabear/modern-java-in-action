package chapter15;

public class FlowTest {

    public static void main(String[] args) {

        SimpleCell c1 = new SimpleCell("C1");
        SimpleCell c2 = new SimpleCell("C2");
        SimpleCell c3 = new SimpleCell("C3");

        c1.subscribe(c3);
        c1.onNext(10);
        c2.onNext(20);

        System.out.println("========================================");

        ArithmeticCell c6 = new ArithmeticCell("C3");
        SimpleCell c5 = new SimpleCell("C2");
        SimpleCell c4 = new SimpleCell("C1");

        c4.subscribe(c6::setLeft);
        c5.subscribe(c6::setRight);

        c4.onNext(10);
        c5.onNext(20);
        c4.onNext(15);

        System.out.println("========================================");

        ArithmeticCell c11 = new ArithmeticCell("C5");
        ArithmeticCell c9 = new ArithmeticCell("C3");

        SimpleCell c10 = new SimpleCell("C4");
        SimpleCell c8 = new SimpleCell("C2");
        SimpleCell c7 = new SimpleCell("C1");

        c7.subscribe(c9::setLeft);
        c8.subscribe(c9::setRight);

        c9.subscribe(c11::setLeft);
        c10.subscribe(c11::setRight);

        c7.onNext(10);
        c8.onNext(20);
        c7.onNext(15);
        c10.onNext(1);
        c10.onNext(3);
    }

}
