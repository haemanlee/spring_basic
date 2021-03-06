package hello.hellospring.hello.postfix;

import java.util.Stack;

public class ChangeFixGenerator {
    private String expression;

    public ChangeFixGenerator(String expression) {
        this.expression = expression;
    }
    /**
     * 인픽스 => 포스트픽스
     * 인픽스 예) 1+2*3, (1-(2+3))*5
     * 포스트픽스 예) 123*+, 123+-5*
     * 시간복잡도 O(N) 순회 한번
     * 공간복잡도 O(N) stack n개 까지 쌓일 수 있음
     */
    public static String infixToPostFix(String infix) {
        Stack<Character> tempStack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        /*
           1) 우선순위에 맞게 stack에 연산자를 넣어주고 넣어야 하는 연산자가 낮다면 안에 있는 것을 비워주고(append) 넣는다.
           2) ( 가 나오면 stack에 넣어주고 ) 가 나오면 ( 가 나올때 까지 append해준다.
           3) 남은 stack에 있는 append한다.
         */
        for (Character character : infix.toCharArray()) {

            if(Character.isDigit(character)) {
                sb.append(character);
            } else if (character == '(') {
                tempStack.push(character);
            } else if (character == ')') {
                while ( !tempStack.isEmpty() && tempStack.peek() != '(' ){
                    sb.append(tempStack.pop());
                }
                tempStack.pop();
            } else {
                while ( !tempStack.isEmpty() && precedence(tempStack.peek()) >= precedence(character) ){
                    sb.append(tempStack.pop());
                }
                tempStack.push(character);
            }
        }
        while ( !tempStack.isEmpty() ){
            sb.append(tempStack.pop());
        }

        return String.valueOf(sb);
    }
    static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    /**
     *     문제 1. 포스트픽스를 인픽스로 변환하기
     *     포스트픽스 예) 123*+, 123+-5*
     *     인픽스 예) 1+2*3, (1-(2+3))*5
     *     시간복잡도 O(N) 1번순회
     *     공간복잡도 O(N) 최대 N만큼 스택에 쌓임
     */
    public static String post2In(String formula) {
        Stack<String> stack = new Stack<>();

        for(Character c: formula.toCharArray()) {
            if(Character.isDigit(c)) {
                stack.push(c + "");
            } else {
                String op1 = stack.peek();
                stack.pop();
                String op2 = stack.peek();
                stack.pop();
                stack.push("(" + op2 + c + op1 + ")");
            }
        }
        return stack.peek();
    }


    /**
     *     문제 2. 인픽스를 프리픽스로 변환하기
     *     인픽스 : (1-(2+3))*5
     *     프리픽스 : *-+2315
     *     인픽스 : 1-(2+3)
     *     프리픽스 : -+231
     *     시간복잡도 O(N) 1번순회
     *     공간복잡도 O(N) 최대 N만큼 스택에 쌓임
     */
    public static String infixToPrefix(String formula) {
        String prefix = "";
        Stack<Character> operators = new Stack<>();
        System.out.println(formula);

        for (int i = formula.length() - 1; i >= 0; --i) {
            char ch = formula.charAt(i);

            if (precedence(ch) > 0) {
                while (operators.isEmpty() == false &&  precedence(operators.peek()) > precedence(ch)) {
                    prefix += operators.pop();
                }
                operators.push(ch);
            } else if (ch == '(') {

                char x = operators.pop();
                while (x != ')') {
                    prefix += x;
                    x = operators.pop();
                }

            } else if (ch == ')') {
                operators.push(ch);
            } else {
                prefix += ch;
            }
            System.out.println(prefix);
        }

        while (!operators.isEmpty()) {
            prefix += operators.pop();
        }

        String reversedPrefix = "";
        for (int i = prefix.length() - 1; i >= 0; i--) {
            reversedPrefix += prefix.charAt(i);
        }
        return reversedPrefix;
    }
}
