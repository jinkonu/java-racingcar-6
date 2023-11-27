package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.constant.NumberConstant.*;

@SuppressWarnings("ALL")
class CarTest {

    private static final int MOVING_FORWARD = 4;
    private static final String TEST_NAME = "konu";
    private static Car car;


    @BeforeEach
    void init() {
        car = Car.create(TEST_NAME);
    }


    @DisplayName("정해진 값을 넘으면 전진")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void goFor_정해진_값을_넘으면_전진(int distance) {
        car.goFor(distance);

        if (distance < MIN_VALID_DISTANCE)
            assertThat(car.getLocation()).isEqualTo(0);

        if (distance >= MIN_VALID_DISTANCE)
            assertThat(car.getLocation()).isEqualTo(1);
    }


    @DisplayName("거리가 같은 경우 0을 반환")
    @Test
    void compareTo_거리가_같은_경우_0을_반환() {
        Car car2 = Car.create(TEST_NAME);

        assertThat(car.compareTo(car2)).isZero();
    }


    @DisplayName("거리가 더 작은 경우 음수를 반환")
    @Test
    void compareTo_거리가_더_작은_경우_음수를_반환() {
        Car car2 = Car.create(TEST_NAME);
        car2.goFor(MOVING_FORWARD);

        assertThat(car.compareTo(car2)).isLessThan(0);
    }


    @DisplayName("거리가 더 큰 경우 양수를 반환")
    @Test
    void compareTo_거리가_더_큰_경우_양수를_반환() {
        Car car2 = Car.create(TEST_NAME);
        car.goFor(MOVING_FORWARD);

        assertThat(car.compareTo(car2)).isGreaterThan(0);
    }


    @DisplayName("거리가 같으면 true")
    @ValueSource(ints = {4, 5, 6})
    @ParameterizedTest
    void equals_거리가_같으면_true(int distance) {
        Car car2 = Car.create(TEST_NAME + TEST_NAME);
        car.goFor(distance); car2.goFor(distance);

        assertThat(car.getLocation()).isEqualTo(car2.getLocation());
        assertThat(car.equals(car2)).isTrue();
    }
}