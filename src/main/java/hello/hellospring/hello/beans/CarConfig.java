package hello.hellospring.hello.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {

    @Bean(name="hyundai")
    public CarMaker hyundaiMaker(){
        CarMaker maker = new HyundaiMaker();
        return maker;
    }

    @Bean(initMethod = "init")
    public OrderManager orderManager(){
        OrderManager manager = new OrderManager(hyundaiMaker());
        return manager;
    }
}
