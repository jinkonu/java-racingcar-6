package racingcar.utils.validator;

import racingcar.exception.CarNameLengthException;
import racingcar.exception.CarsSizeException;
import racingcar.exception.InvalidTurnValueException;

import java.util.List;

import static java.lang.Integer.parseInt;
import static racingcar.utils.constant.NumberConstant.MAX_NAME_LENGTH;
import static racingcar.utils.constant.NumberConstant.MIN_CARS_SIZE;

public class InputValidator {

    public static void validateNames(List<String> names) {
        validateNamesSize(names.size());
        names.forEach(InputValidator::validateNameLength);
    }

    private static void validateNamesSize(int size) {
        if (size < MIN_CARS_SIZE)
            throw new CarsSizeException();
    }

    private static void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH)
            throw new CarNameLengthException();
    }


    public static void validateTurn(String input) {
        try {
            parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidTurnValueException();
        }
    }
}
