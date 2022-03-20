package hello.hellospring.hello.stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    /**
     * 주어진 배열 prices에 대한 스팬을 구하는 코드를 작성하라.
     * 스팬 : 당일의 주가 보다 낮거나 같았던 연속적인 일 수
     * 예) [5,3,2,4,7,1] => [1,1,1,3,5,1]
     * 예) [2,3,4,5,6,7] => [1,2,3,4,5,6]
     */
    @Test
    void get_span1_test(){
        Price price1 = new Price(new int[]{5,3,2,4,7,1});
        Price price2 = new Price(new int[]{2,3,4,5,6,7});
        int[] expected1 = {1,1,1,3,5,1};
        int[] expected2 = {1,2,3,4,5,6};

        Assertions.assertThat(price1.getSpan()).isEqualTo(expected1);
        Assertions.assertThat(price2.getSpan()).isEqualTo(expected2);
    }

    @Test
    void get_span2_test(){
        Price price1 = new Price(new int[]{5,3,2,4,7,1});
        Price price2 = new Price(new int[]{2,3,4,5,6,7});
        int[] expected1 = {1,1,1,3,5,1};
        int[] expected2 = {1,2,3,4,5,6};

        Assertions.assertThat(price1.getSpan2()).isEqualTo(expected1);
        Assertions.assertThat(price2.getSpan2()).isEqualTo(expected2);
    }

}