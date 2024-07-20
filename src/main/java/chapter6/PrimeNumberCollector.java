package chapter6;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector.Characteristics;

public class PrimeNumberCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>>{

    public Supplier<Map<Boolean, List<Integer>>> supplier(){
        return () -> new HashMap<Boolean, List<Integer>>() {{
                put(true, new ArrayList<Integer>());
                put(false, new ArrayList<Integer>());
            }};
    }

    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
            acc.get(isPrime(acc.get(true), candidate))
                    .add(candidate);
        };
    }

    private Boolean isPrime(List<Integer> integers, Integer candidate) {
        //...
        return false;
    }

    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    public Function<Map<Boolean, List<Integer>>,Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
    }
} 
