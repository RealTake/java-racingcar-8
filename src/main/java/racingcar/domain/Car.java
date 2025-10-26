package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void move(int moveDistance) {
        if (moveDistance >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public void randomMove() {
        move(Randoms.pickNumberInRange(0, 9));
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}