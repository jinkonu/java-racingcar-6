package racingcar.utils.constant;

import static racingcar.utils.constant.NumberConstant.MAX_NAME_LENGTH;
import static racingcar.utils.constant.NumberConstant.MIN_CARS_SIZE;

public class StringConstant {

    /* CAR */
    public static final String CAR_FORMATTER = " : ";
    public static final String LOCATION_FORMATTER = "-";


    /* DTO */
    public static final String FINAL_WINNER_FORM = "최종 우승자 : ";
    public static final String NAMES_OUTPUT_DELIMITER = ", ";


    /* INPUT */
    public static final String NAMES_INPUT_DELIMITER = ",";


    /* OUTPUT */
    public static final String NAME_INPUT_FORM = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TURN_INPUT_FORM = "시도할 회수는 몇회인가요?";
    public static final String RESULT_FORM = "실행 결과";


    /* ERROR */
    public static final String CAR_NAME_LENGTH_ERROR = "자동차 이름은 " + MAX_NAME_LENGTH +"자 이하로 가능합니다.";
    public static final String CARS_SIZE_ERROR = "자동차는 최소 " + MIN_CARS_SIZE + "개 이상 입력해주세요.";
    public static final String INVALID_TURN_VALUE_ERROR = "알맞은 횟수를 입력해주세요.";
}
