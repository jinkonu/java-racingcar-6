package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.constant.StringConstant.*;

@SuppressWarnings("ALL")
class GameTest extends NsTest {

    private static Game game;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @DisplayName("게임 실행")
    @Test
    void run_게임_실행() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a, b", "1");
                    assertThat(output()).contains("a", "b", FINAL_WINNER_FORM + "a");
                },
                MOVING_FORWARD, STOP
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}