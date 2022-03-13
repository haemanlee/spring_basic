package hello.hellospring.hello.utils;

import java.util.HashSet;
import java.util.Set;

public class ValidateUtil {
    final static int MAX_VALUE = 9;
    final static int MIN_VALUE = 1;
    final static int INPUT_LENGTH = 3;

    public ValidateUtil() {
    }

    public boolean numberValidate(int number) {
        return number >= MIN_VALUE && number <= MAX_VALUE;
    }

    public boolean isArrayDuplicate(int[] numbers) {
        Set<Integer> duplicateCheckSet = new HashSet<>();
        for (int number : numbers) {
            if(duplicateCheckSet.contains(number)){
                return true;
            }
            duplicateCheckSet.add(number);
        }
        return false;
    }

    public boolean isThreeLength(int[] numbers) {
        return numbers.length == INPUT_LENGTH;
    }
}
