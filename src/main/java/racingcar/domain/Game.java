package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.dto.WinnerCarsDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.utils.constant.NumberConstant.*;
import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

public class Game {

    private List<Car> cars;
    private final int turn;


    public static void run() {
        Game game = new Game();

        game.tryFor(game.turn);

        printResult();

        WinnerCarsDto winnerCars = WinnerCarsDto.of(game.getWinners());
        print(winnerCars);
    }


    private Game() {
        printNameInputForm();
        cars = readNames()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());

        printTurnInputForm();
        this.turn = readTurn();
    }


    private void tryFor(int turn) {
        IntStream.range(ZERO, turn).forEach(i ->
                cars.forEach(car -> {
                    car.goFor(Random.generate());
                    print(car);
                })
        );
    }


    private List<Car> getWinners() {
        Collections.sort(cars);

        return cars.subList(FIRST_IDX, cars.lastIndexOf(getLast()));
    }

    private Car getLast() {
        return cars.get(cars.size() - LAST_IDX_OFFSET);
    }


    private static class Random {

        public static int generate() {
            return Randoms.pickNumberInRange(MIN_DISTANCE, MAX_DISTANCE);
        }
    }
}
