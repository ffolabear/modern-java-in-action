package chapter10;

import static chapter10.MethodChainingOrderBuilder.forCustomer;
import static chapter10.NestedFunctionOrderBuilder.at;
import static chapter10.NestedFunctionOrderBuilder.buy;
import static chapter10.NestedFunctionOrderBuilder.on;
import static chapter10.NestedFunctionOrderBuilder.order;
import static chapter10.NestedFunctionOrderBuilder.sell;
import static chapter10.NestedFunctionOrderBuilder.stock;

public class DSLTest {

    public static void main(String[] args) {

        Order order = new Order();
        order.setCustomer("BigBank");

        Trade trade1 = new Trade();
        trade1.setType(Trade.Type.BUY);

        Stock stock1 = new Stock();
        stock1.setSymbol("IBM");
        stock1.setMarket("NYSE");

        trade1.setStock(stock1);
        trade1.setPrice(125.00);
        trade1.setQuantity(80);
        order.addTrade(trade1);

        Trade trade2 = new Trade();
        trade2.setType(Trade.Type.BUY);

        Stock stock2 = new Stock();
        stock2.setSymbol("GOOGLE");
        stock2.setMarket("NASDAQ");

        trade2.setStock(stock2);
        trade2.setPrice(375.00);
        trade2.setQuantity(50);
        order.addTrade(trade2);

        //메서드 체인
        Order order2 = forCustomer("BigBank")
                .buy(80)
                .stock("IBM")
                .on("NYSE")
                .at(125.00)
                .sell(50)
                .stock("GOOGLE")
                .on("NASDAQ")
                .at(375.00)
                .end();

        //중첩 함수
        Order order3 = order("BigBank",
                buy(80, stock("IBM", on("NYSE")), at(125.00)),
                sell(50, stock("GOOGLE", on("NASDAQ")), at(375.00)));

    }

}
