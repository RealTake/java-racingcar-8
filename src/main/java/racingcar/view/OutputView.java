package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public void printRoundResult(List<Car> cars) {
        cars.stream()
                .map(this::renderProgress)
                .forEach(System.out::println);
        System.out.println();
    }

    private String renderProgress(Car car) {
        return "%s : %s".formatted(car.getName(), "-".repeat(car.getPosition()));
    }
}