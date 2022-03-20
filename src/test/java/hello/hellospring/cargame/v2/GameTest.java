package hello.hellospring.cargame.v2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp(){
        game = new Game("pobi,crong,honux", 5);
    }


    @Test
    void car_input_comma_separate_test(){
        Assertions.assertThat(game.showNames()).contains("pobi");
    }

    @Test
    void cars_move_test(){
        game.match();
        Assertions.assertThat(game.getWinners()).isEmpty();
    }

    @Test
    void cars_move_over_test(){
        while ( !game.isThereWinner() ){
            game.match();
            ResultView.printCars(game.getCars());
        }
        Assertions.assertThat(game.isThereWinner()).isTrue();
    }


}
