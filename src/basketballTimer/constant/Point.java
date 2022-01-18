package basketballTimer.constant;

import java.awt.event.KeyEvent;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Author: Ming
 * Date: 2022.01.19:17
 * Description: <ÃèÊö>
 */
public enum Point {
    LEFT_ONE(KeyEvent.VK_Q, 1, "left"),
    LEFT_TWO(KeyEvent.VK_W, 2, "left"),
    LEFT_THREE(KeyEvent.VK_E, 3, "left"),
    LEFT_REDUCE(KeyEvent.VK_R, -1, "left"),

    RIGHT_ONE(KeyEvent.VK_U, 1, "right"),
    RIGHT_TWO(KeyEvent.VK_I, 2, "right"),
    RIGHT_THREE(KeyEvent.VK_O, 3, "right"),
    RIGHT_REDUCE(KeyEvent.VK_P, -1, "right");

    private final int keyCode;
    private final int point;
    private final String type;

    Point(int keyCode, int point, String type) {
        this.keyCode = keyCode;
        this.point = point;
        this.type = type;
    }

    public static Point matches(int keyCode) {
        return Stream.of(Point.values())
                .filter(e -> Objects.equals(e.keyCode, keyCode))
                .findAny()
                .orElse(null);
    }

    public int getKeyCode() {
        return keyCode;
    }

    public int getPoint() {
        return point;
    }

    public String getType() {
        return type;
    }
}
