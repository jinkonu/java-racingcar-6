package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.constant.NumberConstant.*;

@SuppressWarnings("ALL")
class CarTest {

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
            assertThat(car.getLocation()).isEqualTo(distance);
    }


    @DisplayName("위치가 더 큰 것에 비교하면 음수, 같으면 0, 작은 것에 비교하면 양수")
    @ValueSource(ints = {4, 5, 6})
    @ParameterizedTest
    void compareTo_위치가_더_큰_것에_비교하면_음수_같으면_0_작은_것에_비교하면_음수(int distance) {
        int testDistance = 5;
        car.goFor(testDistance);

        Car car2 = Car.create(TEST_NAME);
        car2.goFor(distance);

        if (distance >  testDistance) assertThat(car.compareTo(car2)).isLessThan(0);
        if (distance == testDistance) assertThat(car.compareTo(car2)).isZero();
        if (distance <  testDistance) assertThat(car.compareTo(car2)).isGreaterThan(0);
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