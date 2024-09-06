package chapter7;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCounterTest {

    private static final String SENTENCE =
            "Nel          mezzo del cammin di nostra vita " +
            "mi ritrovai in una   selva oscura " +
            "ch   la dritta via era smarrita ";

    private static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.getCounter();
    }

    private static int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = false;
            } else {
                if (lastSpace) {
                    counter++;
                    lastSpace = false;
                }
            }
        }
        return counter;
    }


    public static void main(String[] args) {

        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);

        System.out.println("Found " + countWords(stream) + " words");
    }

}
