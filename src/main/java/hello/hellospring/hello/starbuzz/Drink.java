package hello.hellospring.hello.starbuzz;

public abstract class Drink {
    // abstract 뼈대를 만든다. 추상화
    abstract void brew();
    abstract void addSomething();

    // 상속을 받는다.
    void prepareRecipe() {
        boilWater();
        pourInCup();
    }

    // 상속을 받는다.
    protected void boilWater() {
        System.out.println("물을 끓인다.");
    };
    protected void pourInCup() {
        System.out.println("컵에 붓는다.");
    };
}
