package racingcar.exception;

import static racingcar.utils.constant.StringConstant.CARS_SIZE_ERROR;

public class CarsSizeException extends IllegalArgumentException {
    public CarsSizeException() {
        super(CARS_SIZE_ERROR);
    }
}
