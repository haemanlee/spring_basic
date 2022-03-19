package hello.hellospring.hello.baseball;

import hello.hellospring.hello.model.Ball;
import hello.hellospring.hello.model.Status;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallTest {

    private Ball com;

    @BeforeEach
    void setUp(){
        com = new Ball(1,4);
    }


    @Test
    void nothing_test(){
        Status status = com.play(new Ball(2,5));
        Assertions.assertThat(status).isEqualTo(Status.Nothing);
    }

    @Test
    void ball_test(){
        Status status = com.play(new Ball(2,4));
        Assertions.assertThat(status).isEqualTo(Status.Ball);
    }

    @Test
    void strike_test(){
        System.out.println(new Ball(1,4).equals(com));
        Status status = com.play(new Ball(1,4));
        Assertions.assertThat(status).isEqualTo(Status.Strike);
    }

}
