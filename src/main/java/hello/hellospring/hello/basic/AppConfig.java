package hello.hellospring.hello.basic;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new DBMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy()
        );
    }
}
