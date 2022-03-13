package hello.hellospring.stack;

import hello.hellospring.hello.stack.Bracket;
import hello.hellospring.hello.stack.BracketIndex;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BracketTest {

    @Test
    void bracket_true_test(){
        Bracket bracket = new Bracket();
        String targets = "[{1+2*(2+2)}-(1-3)]";

        Assertions.assertThat(bracket.isPairExist(targets)).isTrue();

    }

    @Test
    void bracket_true_and_find_index_test(){
        Bracket bracket = new Bracket();
        String targets = "[{1+2*(2+2)}-(1-3)]";

        Assertions.assertThat(bracket.isPairExist(targets)).isTrue();
        Assertions.assertThat(bracket.findIndexPairExist(targets, 1)).isEqualTo(11);
    }

    @Test
    void reverse_bracket_count_test(){
        Bracket bracket = new Bracket();
        // }}}}{}}} => 3
        String targets = "}}}}{}}}";

        Assertions.assertThat(bracket.calculateBracketCountToReverse(targets)).isEqualTo(3);

    }

    @Test
    void noneed_bracket_count_test(){
        Bracket bracket = new Bracket();
        // }}}}{}}} => 3
        String targets = "1+(2*3)";

        Assertions.assertThat(bracket.isIncludeBracketToNeed(targets)).isFalse();

    }

    @Test
    void bracket_index_test(){
        BracketIndex bracket = new BracketIndex();
        String targets = "[{1+2*(2+2)}-(1-3)]";
        Assertions.assertThat(bracket.findIndexPairExist(targets,1)).isEqualTo(11);

    }
}
