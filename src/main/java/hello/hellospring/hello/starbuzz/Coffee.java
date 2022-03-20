package hello.hellospring.hello.starbuzz;

public class Coffee extends Drink {
    public void brew() {
        System.out.println("필터를 활용해 커피를 내린다.");
    }

    public void addSomething() {
        System.out.println("설탕과 우유를 추가한다.");
    }
}
