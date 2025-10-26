package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RaceInput;

public class InputView {

    private List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String input = Console.readLine();

        final List<String> carNames = new ArrayList<>();
        final String[] carNameSplit = input.split(",");
        for (String carName : carNameSplit) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
            }

            carNames.add(carName.trim());
        }

        return carNames;
    }

    private int inputRaceRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        final String input = Console.readLine();

        try {
            final int rounds = Integer.parseInt(input);

            if (rounds <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
            }

            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    public RaceInput getRaceInput() {
        final List<String> carNames = inputCarNames();
        final int raceRound = inputRaceRound();

        return new RaceInput(carNames, raceRound);
    }
}