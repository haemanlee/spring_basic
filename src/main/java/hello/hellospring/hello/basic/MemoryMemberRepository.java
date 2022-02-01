package hello.hellospring.hello.basic;

public class MemoryMemberRepository implements MemberRepository{
    public MemoryMemberRepository() {
    }

    @Override
    public Member findById(String memberId) {
        Member member = new Member(memberId+"memory");
        return member;
    }

    @Override
    public void save(Member memberId) {

    }
}
