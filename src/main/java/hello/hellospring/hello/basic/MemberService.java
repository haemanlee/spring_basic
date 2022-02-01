package hello.hellospring.hello.basic;

public interface MemberService {
    void join(Member member);
    Member findMember(String memberId);
}
