package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final var racingController = new RacingController(new InputView(), new OutputView());

        try {
            racingController.run();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
