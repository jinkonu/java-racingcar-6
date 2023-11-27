package racingcar.utils.dto;

import racingcar.domain.Car;

import java.util.List;

import static racingcar.utils.constant.StringConstant.*;

public class WinnerCarsDto {
    private final List<String> name;

    public WinnerCarsDto(List<String> name) {
        this.name = name;
    }

    public static WinnerCarsDto of(List<Car> cars) {
        return new WinnerCarsDto(cars.stream()
                .map(Car::getName)
                .toList());
    }

    @Override
    public String toString() {
        return FINAL_WINNER_FORM + String.join(NAMES_OUTPUT_DELIMITER, name);
    }
}
