package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @DisplayName("문자열에 replace 메서드가 잘 동작하는지")
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @DisplayName("문자열에 split 메서드가 잘 동작하는지")
    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @DisplayName("split의 기준 문자가 없을 때도, split 메서드가 잘 동작하는지")
    @Test
    void split2() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @DisplayName("문자열에 substring 메서드가 잘 동작하는지")
    @Test
    void substring() {
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("문자열에 charAt 메서드가 잘 동작하는지")
    @Test
    void charAt() {
        char actual = "abc".charAt(0);
        assertThat(actual).isEqualTo('a');
    }

    @DisplayName("charAt 메서드에 범위를 벗어나는 인덱스를 입력했을 때, StringIndexOutOfBoundsException이 발생하는지")
    @Test
    void charAt2() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
