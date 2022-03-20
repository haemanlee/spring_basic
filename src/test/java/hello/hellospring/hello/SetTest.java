package hello.hellospring.hello;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;


public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("set contain 테스트1")
    void isContain(int input) {
        numbers.add(input);
        assertThat(numbers.contains(input)).isTrue();
    }

    //
    @ParameterizedTest
    @CsvSource({"1,true","2,true","3,true","4,false","5,false"})
    @DisplayName("set contain 테스트2")
    void isContainExpected(String input, String expected) {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        Assertions.assertEquals(numbers.contains(Integer.parseInt(input)), Boolean.parseBoolean(expected));
    }

}



