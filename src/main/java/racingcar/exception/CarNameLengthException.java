package racingcar.exception;

import static racingcar.utils.constant.StringConstant.CAR_NAME_LENGTH_ERROR;

public class CarNameLengthException extends IllegalArgumentException {
    public CarNameLengthException() {
        super(CAR_NAME_LENGTH_ERROR);
    }
}
