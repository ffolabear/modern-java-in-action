package chapter10;

import java.util.function.Consumer;

public class LambdaOrderBuilder {

    private Order order = new Order();

    public static Order order(Consumer<LambdaOrderBuilder> consumer) {
        LambdaOrderBuilder builder = new LambdaOrderBuilder();
        consumer.accept(builder);
        return builder.order;
    }

    public void forCustomer(String customer) {
        order.setCustomer(customer);
    }

    public void buy(Consumer<LambdaTradeBuilder> consumer) {
        trade(consumer, Trade.Type.BUY);
    }

    public void sell(Consumer<LambdaTradeBuilder> consumer) {
        trade(consumer, Trade.Type.SELL);
    }

    private void trade(Consumer<LambdaTradeBuilder> consumer, Trade.Type type) {
        LambdaTradeBuilder builder = new LambdaTradeBuilder();
        builder.trade.setType(type);
        consumer.accept(builder);
        order.addTrade(builder.trade);
    }

    public static class LambdaTradeBuilder {

        private Trade trade = new Trade();

        public void quantity(int quantity) {
            trade.setQuantity(quantity);
        }

        public void price(double price) {
            trade.setPrice(price);
        }

        public void stock(Consumer<LambdaStockBuilder> consumer) {
            LambdaStockBuilder builder = new LambdaStockBuilder();
            consumer.accept(builder);
            trade.setStock(builder.stock);
        }

    }

    public static class LambdaStockBuilder {

        private Stock stock = new Stock();

        public void symbol(String symbol) {
            stock.setSymbol(symbol);
        }

        public void market(String market) {
            stock.setMarket(market);
        }

    }

}
