package top.tinn.Over200.Problem_365;

import java.util.Objects;
import java.util.Stack;

/**
 * @ClassName State
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 20:17
 */
public class State {
    private int x;
    private int y;

    public State(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        State state = (State) obj;
        return x == state.x && y == state.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "State{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
