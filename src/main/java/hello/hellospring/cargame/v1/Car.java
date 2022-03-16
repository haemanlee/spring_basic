package hello.hellospring.cargame.v1;

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

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String showMoveCount(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            sb.append("-");
        }
        return String.valueOf(sb);
    }

    private boolean nameSizeValidation(String name){
        return name.length() <= 5;
    }


    public void isMove(MovingStrategy movingStrategy) {
        if(movingStrategy.movable()){
            this.moveCount++;
        }
    }

    public boolean isMove(int randomNumber) {
        if(randomNumber >= FORWARD_NUM){
            this.moveCount++;
            return true;
        }
        return false;
    }

    public boolean isMove() {
        if(getRandom() >= FORWARD_NUM){
            this.moveCount++;
            return true;
        }
        return false;
    }
    // 테스트 가능한 코드로 변경되었다.
    protected int getRandom() {
        Random random = new Random();
        return random.nextInt(FINAL_NUM);
    }
}
