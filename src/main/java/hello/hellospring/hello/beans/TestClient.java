package hello.hellospring.hello.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClient {
    public static void main(String[] args){
        CarMaker maker = new HyundaiMaker();

        ApplicationContext context = new AnnotationConfigApplicationContext(CarConfig.class);

        OrderManager manager = context.getBean("orderManager", OrderManager.class);
        System.out.println("manager:" + manager);

        manager.order();

        System.out.println("singleton check");

        System.out.println(manager == context.getBean("orderManager", OrderManager.class));

        System.out.println(context.getBean("hyundai", HyundaiMaker.class));

//        OrderManager manager = new OrderManager();
//        manager.setMaker(maker); // #2
//        manager.order();
    }
}
