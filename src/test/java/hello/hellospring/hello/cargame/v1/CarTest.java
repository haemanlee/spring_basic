package hello.hellospring.hello.cargame.v1;

import hello.hellospring.cargame.v1.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다. [x]
 * 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. [x]
 * 자동차 이름은 쉼표(,)를 기준으로 구분한다. [x]
 * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다. [x]
 * 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
 */
public class CarTest {
    private Car car;

    @BeforeEach
    void setUp(){
        car  = new Car("gaeun");
    }

    @Test
    void over_5_car_name(){
//        Car car = new Car("haemanlee");
        Assertions.assertThatThrownBy(() -> new Car("haemanlee"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5이하여야 합니다.");

    }

    @Test
    void car_move_test(){
        car.isMove(() -> false);
        Assertions.assertThat(car.getMoveCount()).isEqualTo(0);

    }

    @Test
    void car_stop_test(){
        car.isMove(() -> true);
        Assertions.assertThat(car.getMoveCount()).isEqualTo(1);

    }


    @Test
    void showMoveCount() {
        car.isMove();
        if(car.getMoveCount() == 0){
            Assertions.assertThat(car.showMoveCount()).isEqualTo("");
        }
        if(car.getMoveCount() == 1){
            Assertions.assertThat(car.showMoveCount()).isEqualTo("-");
        }

    }
}
