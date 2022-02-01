package hello.hellospring.hello;

import hello.hellospring.hello.appconfig.AppConfig;
import hello.hellospring.hello.basic.Member;
import hello.hellospring.hello.basic.MemberRepository;
import hello.hellospring.hello.basic.MemberService;
import hello.hellospring.hello.basic.OrderService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
//		OrderService orderService = appConfig.orderService();
//		Member member = memberService.findMember("hello");
//		System.out.println(member.id);
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
			//직접 등록한 어플리케이션 빈인지 확인 ROLE_APPLICATION
			// ROLE_INFRASTRUCTURE 내부에서 사용하는 빈
			if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println("Name = " + beanDefinitionName+" object = "+bean);
			}

		}
		//해당 클래스 빈에 있는지 조회할 수 있다.
		MemberService memberService = ac.getBean("memberService", MemberService.class);

		//타입으로 조회도 가능하다.
		Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
		for (String key : beansOfType.keySet()) {
			System.out.println("key = " + key + " value = "+beansOfType.get(key));
		}





	}

}
