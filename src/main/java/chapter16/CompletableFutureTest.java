package chapter16;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

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
    public static List<String> findPrices(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(
                                () -> shop.getName() + "price is " + shop.getPrice(product)))
                        .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }


}
