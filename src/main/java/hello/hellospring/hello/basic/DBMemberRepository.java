package hello.hellospring.hello.basic;

public class DBMemberRepository implements MemberRepository{
    @Override
    public Member findById(String memberId) {
        Member member = new Member(memberId+"DB");
        return member;
    }

    @Override
    public void save(Member memberId) {

    }
}
