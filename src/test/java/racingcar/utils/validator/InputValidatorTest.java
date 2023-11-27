package racingcar.utils.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNameLengthException;
import racingcar.exception.CarsSizeException;
import racingcar.exception.InvalidTurnValueException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.utils.constant.StringConstant.NAMES_INPUT_DELIMITER;

@SuppressWarnings("ALL")
class InputValidatorTest {

    @DisplayName("하나 이하의 이름 입력값에 대해 예외 발생")
    @ValueSource(strings = {"", "a"})
    @ParameterizedTest
    void validateNames_하나_이하의_이름_입력값에_대해_예외_발생(String input) {
        List<String> names = Arrays.stream(input.split(NAMES_INPUT_DELIMITER))
                .map(String::trim)
                .toList();

        assertThatThrownBy(() ->
                InputValidator.validateNames(names)
        ).isInstanceOf(CarsSizeException.class);
    }


    @DisplayName("5자 초과하는 이름 입력값에 대해 예외 발생")
    @ValueSource(strings = {"a,bcdefg"})
    @ParameterizedTest
    void validateNames_5자_초과하는_이름_입력값에_대해_예외_발생(String input) {
        List<String> names = Arrays.stream(input.split(NAMES_INPUT_DELIMITER))
                .map(String::trim)
                .toList();

        assertThatThrownBy(() ->
                InputValidator.validateNames(names)
        ).isInstanceOf(CarNameLengthException.class);
    }


    @DisplayName("숫자가 아닌 횟수 입력값에 대해 예외 발생")
    @ValueSource(strings = "a")
    @ParameterizedTest
    void validateTurn_숫자가_아닌_횟수_입력값에_대해_예외_발생(String input) {
        assertThatThrownBy(() ->
                InputValidator.validateTurn(input)
        ).isInstanceOf(InvalidTurnValueException.class);
    }
}