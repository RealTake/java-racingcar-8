package racingcar.controller;

import racingcar.dto.RaceInput;
import racingcar.view.InputView;

public class RacingController {
    private final InputView inputView;

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        final RaceInput raceInput = inputView.getRaceInput();
    }
}