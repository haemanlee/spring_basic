package hello.hellospring.hello.postfix;

import java.util.*;

public class PostFixCalculator {

    private String expression;
//    private static final List<String> operationList = Arrays.asList("+","-","*","/");

    public PostFixCalculator(String expression) {
        this.expression = expression;
    }

    /**
     *  * 예 12+     => 3
     *  * 예 123+-5* => -20
     *  * 인픽스 : 수식 앞 뒤로 피연산자를 두는 표기법 예)(1-(2+3))*5
     * @return int
     * 공간복잡도 O(N) stack 만 n만큼 만든다.
     * 시간복잡도 O(N) n번 만큼만 순회한다.
     */
    public int calculate() {
        Stack<Integer> stack = new Stack<>();

        for (char item : expression.toCharArray()) {
            if(Character.isDigit(item)){
                stack.push(item - '0');
//                stack.push(Integer.parseInt(item + ""));
            } else {
                int right = stack.pop();
                int left = stack.pop();
                switch (item) {
                    case '+':
                        stack.push(right+left);
                        break;
                    case '-':
                        stack.push(right-left);
                        break;
                    case '*':
                        stack.push(right*left);
                        break;
                    case '/':
                        stack.push(right/left);
                        break;
                }
            }

        }
        return stack.pop();
    }

    public int postFixToInfix() {
        return 0;
    }
}
