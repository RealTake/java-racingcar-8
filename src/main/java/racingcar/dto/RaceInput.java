package racingcar.dto;

import java.util.List;
import racingcar.domain.Race;

public record RaceInput(
        List<String> carNames,
        int rounds
) {}
