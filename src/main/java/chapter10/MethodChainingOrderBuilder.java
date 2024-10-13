package chapter10;

public class MethodChainingOrderBuilder {

    public final Order order = new Order();

    private MethodChainingOrderBuilder(String customer) {
        order.setCustomer(customer);
    }

    public static MethodChainingOrderBuilder forCustomer(String customer) {
        return new MethodChainingOrderBuilder(customer);
    }

    public Order end() {
        return order;
    }

    public MethodChainingTradeBuilder buy(int quantity) {
        return new MethodChainingTradeBuilder(this, Trade.Type.BUY, quantity);
    }

    public MethodChainingTradeBuilder sell(int quantity) {
        return new MethodChainingTradeBuilder(this, Trade.Type.SELL, quantity);
    }

    private MethodChainingOrderBuilder addTrade(Trade trade) {
        order.addTrade(trade);
        return this;
    }

    public static class MethodChainingTradeBuilder {

        private final MethodChainingOrderBuilder builder;
        public final Trade trade = new Trade();

        private MethodChainingTradeBuilder(MethodChainingOrderBuilder builder, Trade.Type type, int quantity) {
            this.builder = builder;
            trade.setType(type);
            trade.setQuantity(quantity);
        }

        public LambdaStockBuilder stock(String symbol) {
            return new LambdaStockBuilder(builder, trade, symbol);
        }

    }

    public static class TradeBuilderWithStock {

        private final MethodChainingOrderBuilder builder;
        private final Trade trade;

        public TradeBuilderWithStock(MethodChainingOrderBuilder builder, Trade trade) {
            this.builder = builder;
            this.trade = trade;
        }

        public MethodChainingOrderBuilder at(double price) {
            trade.setPrice(price);
            return builder.addTrade(trade);
        }

    }

    public static class LambdaStockBuilder {

        private final MethodChainingOrderBuilder builder;
        private final Trade trade;
        private final Stock stock = new Stock();

        private LambdaStockBuilder(MethodChainingOrderBuilder builder, Trade trade, String symbol) {
            this.builder = builder;
            this.trade = trade;
            stock.setSymbol(symbol);
        }

        public TradeBuilderWithStock on(String market) {
            stock.setMarket(market);
            trade.setStock(stock);
            return new TradeBuilderWithStock(builder, trade);
        }

    }

}

