package hello.hellospring.hello.basic;

public class OrderServiceImpl implements OrderService {
    // DIP 위배
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 이렇게 수정하게 되면 인터페이스에만 의존할 순 있지만 구현체가 없다. 고로 NPE (null Pointer Exception)이 발생하게 된다.
    // private final DiscountPolicy discountPolicy;

}
