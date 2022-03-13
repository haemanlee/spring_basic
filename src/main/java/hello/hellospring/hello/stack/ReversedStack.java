package hello.hellospring.hello.stack;

import java.util.Arrays;
import java.util.Stack;

public class ReversedStack {
    public static void main(String[] args) {
        Stack<Integer> numberStack = new Stack<>();
        numberStack.push(1);
        numberStack.push(2);
        numberStack.push(3);

        System.out.println(numberStack);

//        Stack<Integer> reversedStack = new Stack<>();
//        /**
//         * 일반적인 방법
//         * O(N) n번만큼 순회
//         * O(N) reversedStack이 n번 push되며 생성됨.
//         */
//        reversedStack = reverse(numberStack, reversedStack);
//
//        System.out.println(reversedStack);

        ReversedStack reversedStack = new ReversedStack();
        reversedStack.solution(numberStack);
        System.out.println(numberStack);

    }

    private static Stack<Integer> reverse(Stack<Integer> numberStack, Stack<Integer> reversedStack) {
        while(!numberStack.isEmpty()){
            reversedStack.push(numberStack.pop());
        }
        return reversedStack;
    }

    private static Stack<Integer> reverse2(Stack<Integer> numberStack) {
        Stack<Integer> reversedStack = new Stack<>();
        reversedStack = reverseRecursive(numberStack, reversedStack);
        return reversedStack;
    }

    private static Stack<Integer> reverseRecursive(Stack<Integer> numberStack, Stack<Integer> reversedStack) {
        if(numberStack.isEmpty()){
            return reversedStack;
        }
        reversedStack.push(numberStack.pop());
        reversedStack = reverseRecursive(numberStack, reversedStack);
        return reversedStack;
    }

    private void solution(Stack<Integer> stack){
        if(stack.isEmpty()) return;
        int temp = stack.pop();
        solution(stack);
        insertAtBottom(stack, temp);

    }
    private void insertAtBottom(Stack<Integer> stack, int number){
        if(stack.isEmpty()){
            stack.push(number);
        } else {
            int temp = stack.pop(); // 1을 임시로 빼놓음.
            insertAtBottom(stack, number); // 2를 넣음.
            stack.push(temp); // 결과적으로 1이 위로 올라감
        }
    }
}

