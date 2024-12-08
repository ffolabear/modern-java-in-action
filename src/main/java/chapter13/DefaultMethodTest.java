package chapter13;

public class DefaultMethodTest {

    public static void main(String[] args) {
        Monster monster = new Monster();
        //디폴트 메서드를 구현하지 않고 사용
        monster.moveHorizontally(10);
        monster.moveVertically(10);
    }

}
