package hello.hellospring.cargame.v1;

import java.util.*;

public class Game {
    private List<Car> carList = new ArrayList<>();


    public Game(String commaString) {
        List<String> stringCarList = commaToList(commaString);
        for (String s : stringCarList) {
            this.carList.add(new Car(s.trim()));
        }
    }

    private List<String> commaToList(String commaString) {
        List<String> strings = List.of(commaString.split(","));
        return strings;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void match() {
        for (Car car : carList) {
            car.isMove(new RandomMovingStrategy());
        }
    }

    public String status() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            if(sb.length() != 0){
                sb.append("\n" + car.getName() + " : " + car.showMoveCount()) ;
            } else {
                sb.append(car.getName() + " : " + car.showMoveCount()) ;
            }
        }
        return String.valueOf(sb);
    }

    public boolean isThereWinner(int closeScore) {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            if(car.getMoveCount() == closeScore){
                sb = extracted(sb, car);
            }
        }
        if(sb.length() > 0){
            sb.append("가 최종 우승했습니다.");
            System.out.println(sb);
            return true;
        }
        return false;
    }

    private StringBuilder extracted(StringBuilder sb, Car car) {
        if(sb.length() == 0){
            sb.append(car.getName());
        } else {
            sb.append(", " + car.getName());
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String carList = scanner.nextLine();  // Read carList
        System.out.println(carList);  // Output carList

        System.out.println("시도할 회수는 몇회인가요?");

        int closeScore = scanner.nextInt();  // Read closeScore
        System.out.println(closeScore);  // Output closeScore


        Game game = new Game(carList);
        while ( !game.isThereWinner(closeScore) ){
            game.match();
            System.out.println(game.status());
        }
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
