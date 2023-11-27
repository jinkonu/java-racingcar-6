package racingcar.view;

import racingcar.domain.Car;

import static racingcar.utils.constant.StringConstant.*;

public class OutputView {

    public static void printNameInputForm() {
        System.out.println(NAME_INPUT_FORM);
    }


    public static void printTurnInputForm() {
        System.out.println(TURN_INPUT_FORM);
    }


    public static void printResult() {
        System.out.println(RESULT_FORM);
    }


    public static void print(Car car) {
        System.out.println(car);
    }
}
