package chapter16;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    private String name;
    private float price = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[new Random().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Shop(String name) {
        this.name = name;
    }

    private static final Random random = new Random();

//    public Future<Double> getPriceAsync(String product) {
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//        new Thread(() -> {
//            try {
//                double price = calculatePrice(product);
//                futurePrice.complete(price);
//            } catch (Exception e) {
//                futurePrice.completeExceptionally(e);
//            }
//        }).start();
//        return futurePrice;
//    }

    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
