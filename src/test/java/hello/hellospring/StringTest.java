package hello.hellospring;

import hello.hellospring.hello.TestString;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringTest {

    TestString string;

    @Test
    void replace(){
        String actual = "abc".replace("b","d");
        Assertions.assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split(){
        String[] actual = "1,2".split(",");
        Assertions.assertThat(actual).contains("1");
        Assertions.assertThat(actual).contains("2");
    }

    @Test
    void splitSingle(){
        String[] actual = "1".split(",");
        Assertions.assertThat(actual).containsExactly("1");
    }

    @Test
    void subString(){
        string = new TestString("(1,2)");
        Assertions.assertThat(string.removeBracket()).isEqualTo("1,2");
    }

}
