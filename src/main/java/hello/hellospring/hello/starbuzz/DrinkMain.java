package hello.hellospring.hello.starbuzz;

public class DrinkMain {
    public static void main(String[] args) {
        Drink drink = new Coffee(); // upcasting
//        Coffee coffee = new Drink();
        Drink drink1 = new Tea(); // downcasting
//        Tea tea = new Drink();

        if(drink instanceof Coffee){
            Coffee coffee = (Coffee) drink;
        }
    }
}
