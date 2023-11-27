package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racingcar.utils.constant.NumberConstant.*;

public class Game {

    private List<Car> cars;


    public static void run() {

    }


    public Game(String[] names) {
        cars = new ArrayList<>();

        for (String name : names)
           cars.add(new Car(name));
    }


    public void tryFor(int turn) {
        cars.forEach(car -> car.goFor(Random.generate()));
    }


    public List<Car> getWinners() {
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
