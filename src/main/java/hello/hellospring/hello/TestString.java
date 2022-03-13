package hello.hellospring.hello;

public class TestString {
    private String value;

    public TestString() {
    }

    public TestString(String value) {
        this.value = value;
    }

    public String removeBracket(){
        String target = this.value;
        target = target.substring(1,target.length()-1);
        return target;
    }
}
