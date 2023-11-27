package racingcar.domain;

import java.util.Objects;

import static racingcar.utils.constant.NumberConstant.*;
import static racingcar.utils.constant.StringConstant.*;

public class Car implements Comparable<Car> {

    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = INITIAL_LOCATION;
    }

    public static Car create(String name) {
        return new Car(name);
    }


    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }


    public void goFor(int value) {
        if (value >= MIN_VALID_DISTANCE) ++location;
    }


    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.location, car.location);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return location == car.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }


    @Override
    public String toString() {
        return name + CAR_FORMATTER + LOCATION_FORMATTER.repeat(location);
    }
}