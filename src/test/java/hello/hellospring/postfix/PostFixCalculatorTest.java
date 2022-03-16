package hello.hellospring.postfix;

import hello.hellospring.hello.postfix.PostFixCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 포스트픽스로 주어진 식을 계산하는 코드를 작성하라. 수식은 사칙연산 (+,-,*,/)만 사용한다고 가정한다.
 *
 * 예 12+     => 3
 * 예 123+-5* => -20
 * 인픽스 : 수식 앞 뒤로 피연산자를 두는 표기법 예)(1-(2+3))*5
 */
public class PostFixCalculatorTest {

    @Test
    void test_post_fix1(){
        PostFixCalculator postFixCalculator = new PostFixCalculator("12+");
        Assertions.assertThat(postFixCalculator.calculate()).isEqualTo(3);

    }

    @Test
    void test_post_fix2(){
        PostFixCalculator postFixCalculator = new PostFixCalculator("123+-");
        Assertions.assertThat(postFixCalculator.calculate()).isEqualTo(4);

    }

    @Test
    void test_postfix_to_infix(){
        PostFixCalculator postFixCalculator = new PostFixCalculator("123+-");
        Assertions.assertThat(postFixCalculator.postFixToInfix()).isEqualTo("-+321");

    }

}
