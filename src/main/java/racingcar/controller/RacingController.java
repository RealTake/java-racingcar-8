package racingcar.controller;

import racingcar.domain.Race;
import racingcar.dto.RaceInput;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final RaceInput raceInput = inputView.getRaceInput();
        final Race race = new Race(raceInput.carNames(), raceInput.rounds());

        outputView.printResultMessage();
        for (int i = 0; i < raceInput.rounds(); i++) {
            race.startRound();
            outputView.printRoundResult(race.getRaceCars());
        }
    }
}