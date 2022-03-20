package hello.hellospring.hello;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CollectionTest {
    @Test
    public void arrayList(){
        ArrayList<String> values =  new ArrayList<>();
        values.add("first");
        values.add("second");
        Assertions.assertThat(values.add("three")).isTrue();
        Assertions.assertThat(values.size()).isEqualTo(3);
        Assertions.assertThat(values.get(0)).isEqualTo("first");
        Assertions.assertThat(values.contains("second")).isTrue();
        Assertions.assertThat(values.remove(0)).isEqualTo("first");
        Assertions.assertThat(values.size()).isEqualTo(2);
    }
}
