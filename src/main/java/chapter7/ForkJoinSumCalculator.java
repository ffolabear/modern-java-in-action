package chapter7;

import java.util.concurrent.RecursiveTask;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    //더할 숫자 배열
    private final long[] numbers;
    //이 서브태스크에서 처리할 배열의 초기 위치와 최종 위치
    private final int start;
    private final int end;
    //이 값 이하의 서브태스크는 더이항 분할할 수 없음
    public static final long THRESHOLD = 10_000;

    //공개 생성자
    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    //메인 태스크의 서브태스크를 재귀적으로 만들때 사용할 비공개 생성자
    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    //추상 메서드서 오버라이드
    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            //기준값과 같거나 작으면 순차적으로 결과를 계산
            return computeSequentially();
        }

        //배열의 첫번쨰 절반을 더하도록 서브태스크를 생성
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length/2);
        //ForkJoinPool 의 다른 스레드로 새로 생성한 태스크를 비동기로 살행
        leftTask.fork();
        //배열의 나머지 절반을 더하도록 서브태스크를 생성
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length/2, end);
        //두번째 서브태스크를 동기 실행. 추가로 분할이 일어날 수 있음
        Long rightResult = rightTask.compute();
        //첫번째 서브태스크의 결과를 읽거나 아직 결과가 없으면 기다람
        Long leftResult = leftTask.join();
        //두 서브태스크의 결과를 조합한 값이 이 태스크의 결과
        return leftResult + rightResult;
    }

    //더 분할할 수 없을때 서브태스크의 결고라르 계산하는 단순 알고리즘
    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
