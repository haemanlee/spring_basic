package hello.hellospring.hello.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

//        System.out.println(ReverseQueue.reverse(queue));
        System.out.println(ReverseQueue.reverse2(queue));
    }

    /**
     * 큐가 제공하는 오퍼레이션만 사용해서 큐를 뒤집는 코드를 작성하라
     * 제공하는 오퍼레이션은 다음과 같다.
     * 4. offer(E e): 큐의 끝에 데이터를 추가한다.
     * 5. E poll() : 큐 헤드를 꺼낸다.
     * 6. isEmpty(); 큐가 비어있는가?
     */
    private static Queue<Integer> reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()){
            stack.push(queue.poll());
        }

        Queue<Integer> numberQueue = new ArrayDeque<>();
        while (!stack.isEmpty()){
            numberQueue.offer(stack.pop());
        }
        return numberQueue;
    }

    private static Queue<Integer> reverse2(Queue<Integer> numbers) {
        if(numbers.isEmpty()){
            return numbers;
        }
        int front = numbers.poll();
        numbers = reverse2(numbers);
        numbers.offer(front);
        return numbers;
    }
}
