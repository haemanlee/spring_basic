package hello.hellospring.hello.basic;

public interface MemberRepository {
    public Member findById(String memberId);

    public void save(Member memberId);
}
