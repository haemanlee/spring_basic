package hello.hellospring.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PlayBallTest {

    @Test
    void nothing_test(){
        Balls com = new Balls(Arrays.asList(1,2,3));
        PlayResult playResult = com.play(Arrays.asList(4,5,6));
        Assertions.assertThat(playResult.getStrike()).isEqualTo(0);
    }

    @Test
    void strike3_test(){
        Balls com = new Balls(Arrays.asList(1,2,3));
        PlayResult playResult = com.play(Arrays.asList(1,2,3));
        Assertions.assertThat(playResult.getStrike()).isEqualTo(3);
        Assertions.assertThat(playResult.isGameOver()).isTrue();
    }
}
