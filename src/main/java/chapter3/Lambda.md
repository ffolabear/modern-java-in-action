### Lambda 예시

1. `String` 형식의 파라미터를 가지며 `int` 를 반환
    ```java
    (String s) -> s.length
    ```
    <br>

2. 객체를 파라미터로 가지고 `boolean` 을 반환
    ```java
   (Apple a) -> a.getWeight() > 150
    ```
    <br>


3. `int` 형식의 두 파라미터를 가지고 `void` 리턴
    ```java
   (int x, int y) -> {
       System.out.println("Result : ");
       System.out.println(x + y);
   }
   ```
   <br>

4. 파리미터 없이 리턴
   ```java
    () -> 42
   ```
   <br>

5. 객체를 파라미터로 가지고 값을 반환
    ```java
    (Apple a, Apple b) -> a.getWeight().compareTo(b.getWeight());
    ```
   <br>

<br>

### 람다 문법 예시

#### 옳은 문법
   ```java
    () -> {}
   ```

   ```java
    () -> "ffb"
   ```

   ```java
    () -> {return "ffb";}
   ```

<br>

#### 틀린 문법
   ```java
    (Integer i) -> return "ffb" + i;
   ```

   ```java
    (String s) -> {"ffbb";}
   ```

<br>

#### 기타 사용 예시
- `boolean` 표현식
   ```java
   (List<String> list) -> list.isEmpty();
   ```
  
- 객체 생성
   ```java
   () -> new Apple(10)
   ```

- 객체에서 소비
   ```java
   (Apple a) -> {
        System.out.println(a.getWeight());
   }
   ```

- 객체에서 선택/추출
   ```java
   (String s) -> s.length()
   ```

- 두 값을 조합
   ```java
   (int a, int b) -> a + b
   ```  

- 두 값을 비교
   ```java
    (Apple a, Apple b) -> a.getWeight().compareTo(b.getWeight());
   ```



### 특징
- 람다 표현식은 변수에 할하거나 함수형 인터페이스를 인수로 받는 메서드로 전당할 수 있음
- 함수형 인터페이스의 추상 메서드와 같은 시그니처를 가짐
- 람다 표현식안에서 `void` 메소드를 호출할 때는 중괄호로 감쌀 필요 없음

