package hello.hellospring.hello.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 문제, 배열에서 다음으로 등장하는 큰 수 찾기
 *
 * 주어진 배열의 오른쪽에 처음으로 등장하는 현재 숫자보다 큰 수를 담고 있는 배열을 만드는 코드를 작성하라. 오른쪽에 현재 수보다 큰수가 없는 경우에는 -1.
 *
 * 예) [1, 1, 2, 3]   =>   [2, 2, 3, -1]
 *
 * 예) [10, 4, 2, 30]   =>  [30, 30, 30, -1]
 *
 * 예) [82, 7, 15]   =>  [-1, 15, -1]
 */
public class BigNumber {

    public static void main(String[] args) {
        int[] input1 = {1,1,2,3};
        int[] input2 = {10, 4, 2, 30};
        int[] input3 = {82, 7, 15};

        System.out.println(Arrays.toString(BigNumber.convert(input1)));
        System.out.println(Arrays.toString(BigNumber.convert(input2)));
        System.out.println(Arrays.toString(BigNumber.convert(input3)));
    }

    /**
     * 시간복잡도 O(N^2) : 2중루프
     * 공간복잡도 O(N) : n길이 int배열 생성
     **/
    private static int[] convert(int[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if(input[i] < input[j]){
                    result[i] = input[j];
                    break;
                }
                result[i] = -1;
            }
        }
        result[input.length-1] = -1;
        return result;
    }
}
