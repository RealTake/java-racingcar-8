package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        final var racingController = new RacingController(new InputView());

        try {
            racingController.run();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
