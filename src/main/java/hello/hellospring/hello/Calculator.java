package hello.hellospring.hello;

import java.io.InvalidObjectException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Calculator {

    private double result;

    public double getResult() {
        return result;
    }

    public void calculate(String input){
        String[] values = input.split(" ");
        System.out.println(Arrays.asList(values));
        int index = 0;
        double sum = 0;
        while( index < values.length ){
            if(index == 0){
                sum += Integer.parseInt(values[index]);
                index++;
            } else {
                switch (values[index]){
                    case "+":
                        sum += Integer.parseInt(values[index + 1]);
                        index = index + 2;
                        break;
                    case "-":
                        sum -= Integer.parseInt(values[index + 1]);
                        index = index + 2;
                        break;
                    case "*":
                        sum *= Integer.parseInt(values[index + 1]);
                        index = index + 2;
                        break;
                    case "/":
                        sum /= Integer.parseInt(values[index + 1]);
                        index = index + 2;
                        break;
                    default :
                        throw new IllegalArgumentException();
                }
            }
        }
        this.result = sum;

    }

}
