package hello.hellospring.hello.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service // id를 지정하지 않으면 클래스 이름이 id로 사용한다.
public class OrderManager {

    private CarMaker maker;

    // 자료형> 아이디 찾아서 주입

    public OrderManager(CarMaker maker) {
        this.maker = maker;
        System.out.println("called");

    }

    public void order() {
        Money money = new Money(1000);
        System.out.println("OrderManager.order : I made " + money.getAmount());
        System.out.println("OrderManager.order : I payed " + money.getAmount());
        Car car = maker.sell(money);
        System.out.println("OrderManager.order : I received " + car.getName());
    }

    public void init(){
        System.out.println("init");
    }
}
