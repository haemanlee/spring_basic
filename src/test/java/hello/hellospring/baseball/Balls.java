package hello.hellospring.baseball;

import hello.hellospring.hello.model.Ball;
import hello.hellospring.hello.model.Status;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Integer> answers) {
        this.balls = mapBall(answers);
    }

    private static List<Ball> mapBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < answers.size(); i++) {
            balls.add(new Ball(i+1, answers.get(i)));
        }
        return balls;
    }

    public PlayResult play(List<Integer> userBalls){
        PlayResult playResult = new PlayResult();
        Balls tryBalls = new Balls(userBalls);
        for (Ball ball : balls) {
            Status status = tryBalls.play(ball);
            playResult.report(status);
        }
        return playResult;
    }

    /**
     *
     * @param ball
     * @return
     */
    Status play(Ball ball) {
        return balls.stream()
                .map(answer -> answer.play(ball))
                .filter(Status::isNotNothing)
                .findFirst()
                .orElse(Status.Nothing);
    }
}
