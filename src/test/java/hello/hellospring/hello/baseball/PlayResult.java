package hello.hellospring.hello.baseball;

import hello.hellospring.hello.model.Status;

public class PlayResult {
    private int strike;
    private int ball;

    public void report(Status status) {
        if(status == Status.Strike) strike++;
        if(status == Status.Ball) ball++;
    }

    public int getStrike() {
        return this.strike;
    }
    public int getBall() {
        return this.ball;
    }
    public boolean isGameOver(){
        if(this.strike == 3){
            return true;
        }
        return false;
    }

}
