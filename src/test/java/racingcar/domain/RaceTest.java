package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceTest {

    private List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = Arrays.asList("포비", "워니", "준");
    }

    // 생성자 검증
    @Test
    void 자동차이름_리스트가_비어있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Race(List.of(), 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 최소 하나 이상이어야 합니다.");
    }

    @Test
    void 시도횟수가_1미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Race(carNames, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 라운드는 1 이상이어야 합니다.");
    }

    @Test
    void 정상적으로_레이스가_생성된다() {
        Race race = new Race(carNames, 5);
        assertThat(race.getRaceCars()).hasSize(3)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("포비", "워니", "준");
        assertThat(race.isFinished()).isFalse();
    }

    // startRound() 테스트
    @Test
    void 정상적으로_라운드가_진행된다() {
        Race race = new Race(carNames, 5);
        race.startRound();
        assertThat(race.getLastRound()).isGreaterThan(0);
    }

    // isFinished() 테스트
    @Test
    void 지정된_라운드가_끝나면_레이스가_완료된다() {
        Race race = new Race(carNames, 2);
        assertThat(race.isFinished()).isFalse();

        race.startRound();
        assertThat(race.isFinished()).isFalse();

        race.startRound();
        assertThat(race.isFinished()).isTrue();
    }

    // getWinners() 테스트
    @Test
    void 레이스가_끝나기_전에_우승자를_조회하면_예외가_발생한다() {
        Race race = new Race(carNames, 3);
        race.startRound();

        assertThatThrownBy(race::getWinners)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("경주가 아직 진행중입니다.");
    }

    @Test
    void 레이스가_끝나면_최다_기록_자동차가_우승자로_선정된다() {
        Race race = new Race(carNames, 1);
        // 각 자동차 위치 직접 지정
        List<Car> cars = race.getRaceCars();
        cars.get(0).move(5); // 포비 1칸 전진
        cars.get(1).move(3); // 워니 0칸
        cars.get(2).move(4); // 준 1칸 전진

        // 강제로 라운드 끝내기
        for (int i = 0; i < 1; i++) {
            race.startRound();
        }

        List<String> winners = race.getWinners();
        assertThat(winners).containsAnyOf("포비", "준");
    }
}