package hello.hellospring.hello.model;

public class Ball {
    private final int position;
    private final int value;

    public int getPosition() {
        return position;
    }

    public int getValue() {
        return value;
    }

    public Ball(int position, int value) {
        this.position = position;
        this.value = value;
    }

    public Status play(Ball ball) {
        if(position == ball.position && isMatch(ball.value)){
            return Status.Strike;
        }
        if(isMatch(ball.value)){
            return Status.Ball;
        }
        return Status.Nothing;
    }

    private boolean isMatch(int value) {
        return this.value == value;
    }
}
