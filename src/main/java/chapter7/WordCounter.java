package chapter7;

public class WordCounter {

    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    //반복 알고리즘 처럼 accumulate 메서드는 문자열의 문자를 하나씩 탐색
    public WordCounter accumulate(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ? this :
                    new WordCounter(counter, true);
        } else {
            //문자를 하나씩 탐색하다 공백 문자를 만나면 지금까지 탐색한 문자를 단어로 간주하여 (공백 문자는 제와) 단어루를 증가
            return lastSpace ? new WordCounter(counter + 1, false) : this;
        }
    }

    public WordCounter combine(WordCounter wordCounter) {
        //두 WordCounter 의 counter 값을 더함
        //counter 값만 더할 것이므로 마지막 공백은 신경쓰지 않음
        return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }

    public int getCounter() {
        return counter;
    }
}
