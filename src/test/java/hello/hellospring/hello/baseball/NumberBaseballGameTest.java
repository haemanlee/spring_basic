package hello.hellospring.hello.baseball;


import hello.hellospring.hello.NumberBaseballGame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberBaseballGameTest {

    NumberBaseballGame computer;

    @BeforeEach
    void setUp(){
        computer = new NumberBaseballGame(425);
    }

    @ParameterizedTest
    @CsvSource({"124,1볼 1스트라이크","425,3스트라이크","254,3볼","789,낫싱"})
    @DisplayName("게임 테스트")
    void test(String input, String expected){
        NumberBaseballGame game = new NumberBaseballGame(Integer.parseInt(input));
        assertEquals(game.tryGame(computer), expected);
    }

    @Test
    @DisplayName("길이가 3이어야 합니다.")
    void exceptionTest1(){
        Assertions.assertThatThrownBy(()->{
            NumberBaseballGame game = new NumberBaseballGame(12);
            System.out.println(game.tryGame(computer));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("길이가 3이어야 합니다.");
    }

    @Test
    @DisplayName("입력된 숫자가 1~9 값이 아닙니다.")
    void exceptionTest2(){
        Assertions.assertThatThrownBy(()->{
                    NumberBaseballGame game = new NumberBaseballGame(102);
                    System.out.println(game.tryGame(computer));
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 숫자가 1~9 값이 아닙니다.");
    }

    @Test
    @DisplayName("입력된 숫자중에 중복된 게 존재합니다.")
    void exceptionTest3(){
        Assertions.assertThatThrownBy(()->{
                    NumberBaseballGame game = new NumberBaseballGame(111);
                    System.out.println(game.tryGame(computer));
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 숫자중에 중복된 게 존재합니다.");
    }
}
