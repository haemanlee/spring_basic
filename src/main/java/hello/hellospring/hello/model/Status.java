package hello.hellospring.hello.model;

public enum Status {
    Strike, Ball, Nothing;

    public boolean isNotNothing() {
        return this != Nothing;
    }
}
