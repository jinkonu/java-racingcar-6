package racingcar.view;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;
import static racingcar.utils.constant.StringConstant.*;
import static racingcar.utils.validator.InputValidator.validateNames;
import static racingcar.utils.validator.InputValidator.validateTurn;

public class InputView {

    public static List<String> readNames() {
        List<String> names = Arrays.stream(readLine().split(NAMES_INPUT_DELIMITER))
                .map(String::trim)
                .toList();

        validateNames(names);
        return names;
    }


    public static int readTurn() {
        String input = readLine();

        validateTurn(input);
        return parseInt(input);
    }
}
