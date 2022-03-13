package hello.hellospring.hello.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BracketIndex {

    public static void main(String[] args) {
        BracketIndex bracket = new BracketIndex();
    }

    /**
     * 괄호 수식과 여는 괄의 위치가 주어졌을 때 그에 대응하는 닫힌 괄호의 위치를 찾는 코드를 작성하라.
     * ex. [{1 + 2 * (2 + 2)} - (1 - 3)], 1(index {) -> 11번째 인덱스
     */
    public int findIndexPairExist(String targets, int openingIndex) {
        final List<String> openingList = Arrays.asList("(", "[", "{");
        final List<String> closingList = Arrays.asList(")", "]", "}");

        Stack<String> stack = new Stack<>();
        String[] tokens = targets.split("");
        for (int i = 0; i < tokens.length; i++) {
            if(i == openingIndex && openingList.contains(tokens[i])){
                stack.push(tokens[i]);
            } else {
                if(!stack.isEmpty()){
                    String temp = stack.peek();
                    if(openingList.indexOf(temp) == closingList.indexOf(tokens[i])){
                        stack.pop();
                        return i;
                    }
                }
            }

        }
        return 0;
    }

    /**
     * 괄호 수식과 여는 괄의 위치가 주어졌을 때 그에 대응하는 닫힌 괄호의 위치를 찾는 코드를 작성하라.
     * ex. [{1 + 2 * (2 + 2)} - (1 - 3)], 1(index {) -> 11번째 인덱스
     */


    /**
     * 괄호 몇개를 뒤집어야 정상적인 수식을 만들 수 있는지 계산하는 코드를 작성하라.
     * }}}}{}}} => 3
     * {{{{ => 2
     */

    /**
     * 주어진 수식에 불필요한 괄호가 있지 않은지 확인하는 코드를 작성하라
     * 예) ((1+2))+3 =>true
     * 예) 1+(2*3)=> false (산술적으로는 불필요하지만 이 문제에서는 이런 괄호는
     * 유효하다고 가정한다)
     * 예) 1+(2)*3 => true(2를 감싸고 있는 괄호는 불필요하다)
     */

}

