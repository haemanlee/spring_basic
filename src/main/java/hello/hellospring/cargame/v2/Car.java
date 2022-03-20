package hello.hellospring.cargame.v2;

import hello.hellospring.cargame.v2.MovingStrategy;

import java.util.Random;

public class Car {
    private final static int FINAL_NUM = 10;
    private final static int FORWARD_NUM = 4;

    private String name;
    private int moveCount;

    public Car(String name) {
        if(!nameSizeValidation(name)){
            throw new IllegalArgumentException("자동차의 이름은 5이하여야 합니다.");
        }
        this.name = name;
    }

    private String getName() {
        return name;
    }
    private int getMoveCount() {
        return moveCount;
    }
    private boolean nameSizeValidation(String name){
        return name.length() <= 5;
    }

    public String displayMoveCount(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            sb.append("-");
        }
        return String.valueOf(sb);
    }

    public void isMove(MovingStrategy movingStrategy) {
        if(movingStrategy.movable()){
            this.moveCount++;
        }
    }

    public String showName() {
        return getName();
    }

    public int showMoveCount() {
        return getMoveCount();
    }
}
