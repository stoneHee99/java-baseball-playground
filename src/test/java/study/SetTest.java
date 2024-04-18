package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("set의 size 메서드가 size의 크기를 잘 반환하는지")
    @Test
    void size() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("set의 contains 메서드가 포함된 값이 있으면 true를 반환하는지")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @DisplayName("set의 contains 메서드가 false 결괏값도 잘 반환하는지")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains2(int num, boolean expected) {
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }


}
