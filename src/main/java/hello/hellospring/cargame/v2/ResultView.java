package hello.hellospring.cargame.v2;

import java.util.List;

public class ResultView {

    static public void printCars(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.showName() + " : " + car.displayMoveCount());
        }
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(Game.listToCommaString(winners));
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }
}
