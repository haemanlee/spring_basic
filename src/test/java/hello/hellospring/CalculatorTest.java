package hello.hellospring;

import hello.hellospring.hello.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private static Calculator cal;

    @BeforeEach
    public void setUp()  {
        cal = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({"2 + 3 * 4 / 2,10.0",
            "1 + 3 * 4 / 2,8.0",
            "2 + 3 * 4 * 2,40.0",
            "1 + 2 * 4 / 2,6.0"})
    public void test(String input, String expected)  {
        cal.calculate(input);
        Assertions.assertThat(cal.getResult()).isEqualTo(Double.parseDouble(expected));
    }


    @ParameterizedTest
    @CsvSource({"2 + 3 k 4 / 2,10.0",
            "1 + 3 a 4 / 2,8.0",
            "2 + 3 c 4 * 2,40.0",
            "1 + 2 b 4 / 2,6.0"})
    public void exceptionTest(String input, String expected)  {

        Assertions.assertThatThrownBy(() -> {
            cal.calculate(input);
            cal.getResult();
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
