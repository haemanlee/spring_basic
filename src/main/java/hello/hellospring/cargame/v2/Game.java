package hello.hellospring.cargame.v2;


import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> carList = new ArrayList<>();
    private int closeScore;
    private List<Car> winners = new ArrayList<>();

    public List<Car> getCars() {
        return carList;
    }

    public List<Car> getWinners() {
        return winners;
    }

    public Game(String commaString, int closeScore) {
        List<String> stringCarList = commaToList(commaString);
        for (String s : stringCarList) {
            this.carList.add(new Car(s.trim()));
        }
        this.closeScore = closeScore;
    }

    private List<String> commaToList(String commaString) {
        List<String> strings = List.of(commaString.split(","));
        return strings;
    }

    static public StringBuilder listToCommaString(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            if(sb.length() == 0){
                sb.append(car.showName());
            } else {
                sb.append(", " + car.showName());
            }
        }
        return sb;
    }

    public boolean isThereWinner() {
        for (Car car : carList) {
            if(car.showMoveCount() == closeScore){
                winners.add(car);
            }
        }
        if(winners.size() > 0){
            return true;
        }
        return false;
    }

    public void match() {
        for (Car car : carList) {
            car.isMove(new RandomMovingStrategy());
        }
    }

    public String showNames() {
        StringBuilder nameList = new StringBuilder();
        for (Car car : carList) {
            nameList.append(car.showName() + ",");
        }
        return String.valueOf(nameList.substring(0,nameList.length()-1));
    }
}
