import org.example.dailies.impl.RemoveAllOcurrencesOfSubstring;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class RemoveAllOcurrencesOfSubstringTest {

    @InjectMocks
    private RemoveAllOcurrencesOfSubstring removeAllOcurrencesOfSubstring;

    @Test
    void test_example_1() {
        // Arrange
        String s = "daabcbaabcbc";
        String part = "abc";
        String expected = "dab";

        // Action
        String result = removeAllOcurrencesOfSubstring.removeAllOcurrencesOfSubstring(s, part);

        // Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void test_example_2() {
        // Arrange
        String s = "axxxxyyyyb";
        String part = "xy";
        String expected = "ab";

        // Action
        String result = removeAllOcurrencesOfSubstring.removeAllOcurrencesOfSubstring(s, part);

        // Assert
        assertThat(result).isEqualTo(expected);
    }
}
