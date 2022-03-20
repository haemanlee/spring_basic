package hello.hellospring.hello.postfix;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ChangeFixGeneratorTest {
    /**
     * 인픽스 => 포스트픽스
     * 인픽스 예) 1+2*3, (1-(2+3))*5
     * 포스트픽스 예) 123*+ ,123+-5*
     */
    @Test
    void infixToPostFix() {
        Assertions.assertThat(ChangeFixGenerator.infixToPostFix("1+2*3")).isEqualTo("123*+");
        Assertions.assertThat(ChangeFixGenerator.infixToPostFix("(1-(2+3))*5")).isEqualTo("123+-5*");

    }

    @Test
    void postfixToInfix1() {
        Assertions.assertThat(ChangeFixGenerator.post2In("123*+")).isEqualTo("(1+(2*3))");
    }

    @Test
    void postfixToInfix2() {
        Assertions.assertThat(ChangeFixGenerator.post2In("123+-5*")).isEqualTo("((1-(2+3))*5)");
    }

    @Test
    void infixToPrefix1() {
        Assertions.assertThat(ChangeFixGenerator.infixToPrefix("A+B*(C^D-E)")).isEqualTo("+A*B-^CDE");
        Assertions.assertThat(ChangeFixGenerator.infixToPrefix("(a-b/c)*(a/k-l)")).isEqualTo("*-a/bc-/akl");

    }
}