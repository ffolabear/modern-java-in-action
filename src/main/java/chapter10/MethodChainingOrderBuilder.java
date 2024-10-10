package chapter10;

import chapter10.Trade.Type;

public class MethodChainingOrderBuilder {

    public final Order order = new Order();

    private MethodChainingOrderBuilder(String customer) {
        order.setCustomer(customer);
    }

    public static MethodChainingOrderBuilder forCustomer(String customer) {
        //고객의 주문을 만드는 정적 팩토리 메서드
        return new MethodChainingOrderBuilder(customer);
    }

    public TradeBuilder buy(int quantity) {
        return new TradeBuilder(this, Type.BUY, quantity);
    }

    public TradeBuilder sell(int quantity) {
        return new TradeBuilder(this, Type.SELL, quantity);
    }

    public MethodChainingOrderBuilder addTrade(Trade trade) {
        order.addTrade(trade);
        return this;
    }

    public Order end() {
        return order;
    }

}
