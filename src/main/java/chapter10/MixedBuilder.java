package chapter10;

import chapter10.Trade.Type;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MixedBuilder {

    public static Order forCustomer(String customer, MixedTradeBuilder... builders) {
        Order order = new Order();
        order.setCustomer(customer);
        Stream.of(builders).forEach(b -> order.addTrade(b.trade));
        return order;
    }

    public static MixedTradeBuilder buy(Consumer<MixedTradeBuilder> consumer) {
        return buildTrade(consumer, Type.BUY);
    }

    public static MixedTradeBuilder sell(Consumer<MixedTradeBuilder> consumer) {
        return buildTrade(consumer, Type.SELL);
    }


    private static MixedTradeBuilder buildTrade(Consumer<MixedTradeBuilder> consumer, Trade.Type buy) {
        MixedTradeBuilder builder = new MixedTradeBuilder();
        builder.trade.setType(buy);
        consumer.accept(builder);
        return builder;
    }


    public static class MixedTradeBuilder {

        private Trade trade = new Trade();

        public MixedTradeBuilder quantity(int quantity) {
            trade.setQuantity(quantity);
            return this;
        }

        public MixedTradeBuilder at(double price) {
            trade.setPrice(price);
            return this;
        }

        public MixedStockBuilder stock(String symbol) {
            return new MixedStockBuilder(this, trade, symbol);
        }

    }

    public static class MixedStockBuilder {

        private final MixedTradeBuilder builder;
        private final Trade trade;
        private final Stock stock = new Stock();

        private MixedStockBuilder(MixedTradeBuilder builder, Trade trade, String symbol) {
            this.builder = builder;
            this.trade = trade;
            stock.setSymbol(symbol);
        }

        public MixedTradeBuilder on(String market) {
            stock.setMarket(market);
            trade.setStock(stock);
            return builder;
        }
    }
}
