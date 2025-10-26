package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    // 생성자 검증
    @Test
    void 자동차이름이_null이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름이_빈문자열이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름이_5자초과이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car("자동차이름이길다"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차가_정상적으로_생성된다() {
        Car car = new Car("포비");
        assertThat(car.getName()).isEqualTo("포비");
        assertThat(car.getPosition()).isZero();
    }

    // move() 기능 테스트
    @Test
    void 이동값이_4이상이면_자동차가_전진한다() {
        Car car = new Car("워니");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 이동값이_4미만이면_자동차가_멈춘다() {
        Car car = new Car("워니");
        car.move(3);
        assertThat(car.getPosition()).isZero();
    }
}