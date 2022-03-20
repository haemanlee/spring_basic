package hello.hellospring.hello;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChatAtTest {

    @Test
    public void chatAtTest(){
        Assertions.assertThat("abc".charAt(1)).isEqualTo('b');
    }

    @Test
    public void chatAtExceptionTest(){
        Assertions.assertThatThrownBy(() ->  "abc".charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index");
    }


    @Test
    public void chatAtException2Test(){
        Assertions.assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()->  "abc".charAt(4))
                .withMessageMatching("String index out of range: 4");
    }

}
