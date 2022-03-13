package hello.hellospring.baseball;


import hello.hellospring.hello.utils.ValidateUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidateUtilTest {

    ValidateUtil validateUtil;

    @BeforeEach
    void setUp(){
        validateUtil = new ValidateUtil();
    }

    @Test
    void is_over_9_and_under_1(){
        Assertions.assertThat(validateUtil.numberValidate(1)).isTrue();
        Assertions.assertThat(validateUtil.numberValidate(9)).isTrue();
    }

    @Test
    void is_duplicate(){
        Assertions.assertThat(validateUtil.isArrayDuplicate(new int[]{1,2,3})).isFalse();
        Assertions.assertThat(validateUtil.isArrayDuplicate(new int[]{1,1,1})).isTrue();
        Assertions.assertThat(validateUtil.isArrayDuplicate(new int[]{1,2,2})).isTrue();
    }

    @Test
    void is_3lengh(){
        Assertions.assertThat(validateUtil.isThreeLength(new int[]{1,2})).isFalse();
        Assertions.assertThat(validateUtil.isThreeLength(new int[]{1,3,4})).isTrue();
    }
}
