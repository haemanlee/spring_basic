package hello.hellospring.hello;

import hello.hellospring.hello.basic.AppConfig;
import hello.hellospring.hello.basic.Member;
import hello.hellospring.hello.basic.MemberService;
import hello.hellospring.hello.basic.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
		AppConfig appConfig = new AppConfig();
		MemberService memberService = appConfig.memberService();
		OrderService orderService = appConfig.orderService();
		Member member = memberService.findMember("hello");
		System.out.println(member.id);

	}

}
