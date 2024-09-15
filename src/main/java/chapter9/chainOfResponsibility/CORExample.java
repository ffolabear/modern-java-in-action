package chapter9.chainOfResponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class CORExample {


    public static void main(String[] args) {

        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String result = p1.handle("Aren't labdas really sexy?");
        System.out.println(result);

        UnaryOperator<String> headProcessing = (String text) -> "From Raoul, Mario and Alan : " + text;
        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headProcessing.andThen(spellCheckerProcessing);
        String lambdaResult = pipeline.apply("Aren't labdas really sexy?");
        System.out.println(lambdaResult);
    }


}

class HeaderTextProcessing extends ProcessingObject<String> {

    @Override
    String handleWork(String text) {
        return "From Raoul, Mario and Alan : " + text;
    }

}

class SpellCheckerProcessing extends ProcessingObject<String> {

    @Override
    String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }

}