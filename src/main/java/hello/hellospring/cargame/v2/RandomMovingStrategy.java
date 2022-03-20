package hello.hellospring.cargame.v2;


import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private final static int FINAL_NUM = 10;
    private final static int FORWARD_NUM = 4;

    @Override
    public boolean movable() {
        if(getRandom() >= FORWARD_NUM){
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
