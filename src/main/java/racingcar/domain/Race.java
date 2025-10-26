package racingcar.domain;

import java.util.Comparator;
import java.util.List;

public class Race {
    private final List<Car> CARS;
    private final int MAX_ROUNDS;
    private int finishedRound = 0;


    public Race(List<String> names, int maxRounds) {
        initValidate(names, maxRounds);

        this.MAX_ROUNDS = maxRounds;
        this.CARS = names.stream()
                .map(String::trim)
                .map(Car::new)
                .toList();
    }

    /**
     * 레이스 초기 값 검증
     */
    private static void initValidate(List<String> names, int maxRounds) {
        if (maxRounds < 1) {
            throw new IllegalArgumentException("최소 라운드는 1 이상이어야 합니다.");
        }

        if (names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 최소 하나 이상이어야 합니다.");
        }
    }

    public void startRound() {
        for (Car car : CARS) {
            car.randomMove();
        }
        finishedRound++;
    }

    public List<Car> getRaceCars() {
        return List.copyOf(CARS);
    }

    public boolean isFinished() {
        return finishedRound >= MAX_ROUNDS;
    }
}