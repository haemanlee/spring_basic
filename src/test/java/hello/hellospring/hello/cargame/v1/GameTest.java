package hello.hellospring.hello.cargame.v1;

import hello.hellospring.cargame.v1.Game;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp(){
        game = new Game("pobi,crong,honux");
    }


    @Test
    void car_input_comma_separate_test(){
        Assertions.assertThat(game.getCarList().get(0).getName()).isEqualTo("pobi");
    }

    @Test
    void cars_move_test(){
        game.match();
        System.out.println(game.status());
        Assertions.assertThat(game.status()).contains("pobi : ");
    }

    @Test
    void cars_move_over_test(){
        while ( !game.isThereWinner(5) ){
            game.match();
            System.out.println(game.status());
        }
        Assertions.assertThat(game.isThereWinner(5)).isTrue();
    }


}
