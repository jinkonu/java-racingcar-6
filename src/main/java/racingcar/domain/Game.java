package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.dto.WinnerCarsDto;

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

        printResult();
        game.tryFor(game.turn);

        print(WinnerCarsDto.of(game.getWinners()));
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
        IntStream.range(ZERO, turn).forEach(i -> {
            cars.forEach(car -> {
                car.goFor(Random.generate());
                print(car);
            });

            printOneLine();
        });
    }


    private List<Car> getWinners() {
        int max = getMaxLocation();

        return cars.stream()
                .filter(car -> car.getLocation() == max)
                .collect(Collectors.toList());
    }

    private int getMaxLocation() {
        return cars.stream()
                .max(Car::compareTo)
                .get()
                .getLocation();
    }


    private static class Random {

        public static int generate() {
            return Randoms.pickNumberInRange(MIN_DISTANCE, MAX_DISTANCE);
        }
    }
}
