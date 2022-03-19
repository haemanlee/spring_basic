package hello.hellospring.hello.zip;

import java.util.*;
import java.util.stream.IntStream;

public class CharacterZip {

    public static void main(String[] args) {

        String input = "aabbacbb";
        CharacterZip characterZip = new CharacterZip();

        HashSet<Integer> set = new HashSet<>();
        int[] nums = {1,2,3,4,6,7,8,0};
        for (int num : nums) {
            set.add(num);
        }
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            if(!set.contains(i)) answer += i;
        }

        System.out.println("sum: "+ answer);
        System.out.println(characterZip.getMinLength(input) == 7);

    }

    private int getMinLength(String input) {
        StringBuilder sb = new StringBuilder();
        Stack<String> munja = new Stack<>();

        for (int i = 0; i < input.length(); i+=2) {
            if (munja.isEmpty()){
                munja.push(input.substring(i,i+2));
            } else {
                if(munja.peek().equals(input.substring(i,i+2))){
                    munja.push(input.substring(i,i+2));
                } else {
                    if(munja.size()>1){
                        sb.append(munja.size());
                    }
                    sb.append(munja.pop());
                    while(!munja.isEmpty()){
                        munja.pop();
                    }
                    munja.push(input.substring(i,i+2));
                }
            }
        }
        System.out.println(sb.toString());
        return 7;
    }
}
