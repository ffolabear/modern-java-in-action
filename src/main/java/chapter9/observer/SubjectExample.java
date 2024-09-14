package chapter9.observer;

import java.util.ArrayList;
import java.util.List;

public class SubjectExample {

    interface Subject {
        void registerObserver(Observer observer);
        void notifyObservers(String tweet);
    }

    class Feed implements Subject {

        private final List<Observer> observers = new ArrayList<>();

        @Override
        public void registerObserver(Observer observer) {

        }

        @Override
        public void notifyObservers(String tweet) {

        }
    }


}
