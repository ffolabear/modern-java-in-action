package chapter16;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureTest {

    private static List<Shop> shops = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll")
    );

    public static void main(String[] args) {

        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        //제품 가격을 계산하는 동안
        //doSomethingElse()...

        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after " + retrievalTime + " msecs");

        System.out.println("==================================");

        long start2 = System.nanoTime();
        System.out.println(findPrices("myPhone27S"));
        long duration = (System.nanoTime() - start2) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");

        System.out.println("=====================   random delay 적용 =====================");

        long start3 = System.nanoTime();
        CompletableFuture[] futures = findPricesStream("myPhone27S")
                .map(f -> f.thenAccept(
                        s -> System.out.println(
                                s + " (done in " + ((System.nanoTime() - start3) / 1_000_000) + " msecs)")))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();
        System.out.println("All shops have now responded in " + (System.nanoTime() - start3) / 1_000_000 + " msecs");
    }



//    public static List<String> findPrices(String product) {
//        return shops.stream()
//                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
//                .collect(Collectors.toList());
//    }

    //개선 #1
//    public static List<String> findPrices(String product) {
//        return shops.parallelStream()
//                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
//                .collect(Collectors.toList());
//    }

    //개선 #2
//    public static List<String> findPrices(String product) {
//        List<CompletableFuture<String>> priceFutures =
//                shops.stream()
//                        .map(shop -> CompletableFuture.supplyAsync(
//                                () -> shop.getName() + "price is " + shop.getPrice(product), executor))
//                        .collect(Collectors.toList());
//
//        return priceFutures.stream()
//                .map(CompletableFuture::join)
//                .collect(Collectors.toList());
//    }

    //가장 간단한 방법으로 새롭게 구현
//    public static List<String> findPrices(String product) {
//        return shops.stream()
//                .map(shop -> shop.getPrice(product))
//                .map(price -> Quote.parse(price))
//                .map(quote -> Discount.applyDiscount(quote))
//                .collect(toList());
//    }

    //비동기 방식으로 재구현
    public static List<String> findPrices(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(
                        quote -> CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote), executor)))
                .collect(toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(toList());
    }

    public static Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(
                        () -> Discount.applyDiscount(quote), executor)));
    }


    private static final Executor executor =
            Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setDaemon(true);
                    return thread;
                }
            });
}

