package racingcar.exception;

import static racingcar.utils.constant.StringConstant.INVALID_TURN_VALUE_ERROR;

public class InvalidTurnValueException extends IllegalArgumentException {
    public InvalidTurnValueException() {
        super(INVALID_TURN_VALUE_ERROR);
    }
}
