package hello.hellospring.hello.stack;

import java.util.Stack;

/**
 * 주어진 배열 prices에 대한 스팬을 구하는 코드를 작성하라.
 * 스팬 : 당일의 주가 보다 낮거나 같았던 연속적인 일 수
 * 예) [5,3,2,4,7,1] => [1,1,1,3,5,1]
 * 예) [2,3,4,5,6,7] => [1,2,3,4,5,6]
 */
public class Price {
    private int[] prices;

    public Price(int[] prices) {
        this.prices = prices;
    }

    /**
     * 시간복잡도 O(N^2) 2번 루프를 돌림.
     * 공간복잡도 O(N) 스택이 최대 n개 까지 쌓일 수 있음.
     */
    public int[] getSpan() {
        int[] spans = new int[prices.length];
        Stack<Integer> compareStack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            if(i == 0){
                spans[i] = 1;
                compareStack.push(prices[i]);
            } else {
                int spanCount = 1;
                for (Integer integer : compareStack) {
                    if(integer < prices[i]){
                        spanCount += 1;
                    }
                }
                spans[i] = spanCount;
                compareStack.push(prices[i]);
            }
        }

        return spans;
    }

    /*
       인덱스를 stack에 price 자기보다 크면 while Pop, 작으면 i- peek()
     */
    public int[] getSpan2(){
        int[] spans = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        spans[0] = 1;

        for (int i = 1; i < prices.length; i++) {
            while ( !stack.isEmpty() && prices[stack.peek()] <= prices[i] ){
                stack.pop();
            }

            spans[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return spans;
    }
}
