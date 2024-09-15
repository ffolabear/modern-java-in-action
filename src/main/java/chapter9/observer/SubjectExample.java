package chapter9.observer;

import chapter9.observer.SubjectExample.Subject;
import java.util.ArrayList;
import java.util.List;

public class SubjectExample {

    interface Subject {
        void registerObserver(Observer observer);
        void notifyObservers(String tweet);
    }

    public static void main(String[] args) {

        Feed feed = new Feed();
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new Guardian());
        feed.registerObserver(new LeMonde());
        feed.notifyObservers("The queen said her favourite book is modern blah blah..");

        feed.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });

        feed.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet more news from London... " + tweet);
            }
        });

    }

}

class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(
                observers -> observers.notify(tweet)
        );
    }
}