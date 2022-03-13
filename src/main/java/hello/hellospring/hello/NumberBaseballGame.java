package hello.hellospring.hello;

import hello.hellospring.hello.utils.ValidateUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
 *
 * 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
 * e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱
 * 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게 임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
 * 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
 * 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
 */
public class NumberBaseballGame {
    private final Map<Integer, Integer> numberMap = new HashMap<>();
    private int strike;
    private int ball;

    ValidateUtil validateUtil = new ValidateUtil();

    public NumberBaseballGame(int input) {
        int[] numbers = enter(input);
        if(!validateUtil.isThreeLength(numbers)){
            throw new IllegalArgumentException("길이가 3이어야 합니다.");
        };
        if(validateUtil.isArrayDuplicate(numbers)){
            throw new IllegalArgumentException("입력된 숫자중에 중복된 게 존재합니다.");
        }
        for(int i=0; i < numbers.length; i++){
            if(!validateUtil.numberValidate(numbers[i])){
                throw new IllegalArgumentException("입력된 숫자가 1~9 값이 아닙니다.");
            }
            this.numberMap.put(i,numbers[i]);
        }
    }

    private int[] enter(int input) {
        String temp = Integer.toString(input);
        int[] numbers = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            numbers[i] = temp.charAt(i) - '0';
        }
        return numbers;
    }

    public String tryGame(NumberBaseballGame computer){
        compare(computer, 0);
        compare(computer, 1);
        compare(computer, 2);
        return resultString();
    }

    private String resultString() {
        StringBuilder sb = new StringBuilder();
        if(this.ball > 0){
            sb.append(this.ball+"볼");
        }
        if(this.strike > 0){
            if(sb.length() != 0){
                sb.append(" ");
            }
            sb.append(this.strike+"스트라이크");
        }
        if(sb.length() == 0){
            sb.append("낫싱");
        }
        return String.valueOf(sb);
    }

    private void compare(NumberBaseballGame computer, int index) {
        if(computer.numberMap.get(index).equals(this.numberMap.get(index))){
            this.strike++;
        } else if (computer.numberMap.containsValue(this.numberMap.get(index))){
            this.ball++;
        }
    }

}
