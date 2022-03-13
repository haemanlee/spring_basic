package hello.hellospring.baseball;

import hello.hellospring.hello.model.Ball;
import hello.hellospring.hello.model.Status;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BallsTest {
    private Balls com;

    @BeforeEach
    void setUp(){
        com = new Balls(Arrays.asList(1,2,3));
    }

    @Test
    void nothing_test(){
        Status status = com.play(new Ball(1,5));
        Assertions.assertThat(status).isEqualTo(Status.Nothing);
    }

    @Test
    void ball_test(){
        Status status = com.play(new Ball(1,2));
        Assertions.assertThat(status).isEqualTo(Status.Ball);
    }

    @Test
    void strike_test(){
        Status status = com.play(new Ball(1,1));
        Assertions.assertThat(status).isEqualTo(Status.Strike);
    }
}
