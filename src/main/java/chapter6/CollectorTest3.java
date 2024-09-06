package chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CollectorTest3 {

    public static void main(String[] args) {


        ToListCollector<Integer> listCollector = new ToListCollector<>();

        Supplier<List<Integer>> supplier = listCollector.supplier();
        List<Integer> list = supplier.get();

        List<Integer> accumulatorList = new ArrayList<>();
        listCollector.accumulator().accept(accumulatorList, 1);
        System.out.println(accumulatorList);


        listCollector.combiner();
    }



}
