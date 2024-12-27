package chapter16;

import chapter16.Discount.Code;

public class Quote {

    private final String shopName;
    private final Double price;
    private final Discount.Code discountCode;

    public Quote(String shopName, Double price, Discount.Code discount) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discount;
    }

    public static Quote parse(String s) {
        String[] split = s.split(":");
        String shopName = split[0];
        double price = Double.parseDouble(split[1]);
        Discount.Code discountCode = Discount.Code.valueOf(split[2]);
        return new Quote(shopName, price, discountCode);
    }

    public String getShopName() {
        return shopName;
    }

    public Double getPrice() {
        return price;
    }

    public Code getDiscountCode() {
        return discountCode;
    }
}
