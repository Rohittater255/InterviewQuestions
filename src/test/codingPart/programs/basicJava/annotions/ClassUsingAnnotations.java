package test.codingPart.programs.basicJava.annotions;

@Information(drop = "23")
public class ClassUsingAnnotations {

    @Information(type = "smoke")
    public void methodA() {
        System.out.println("I am method A");
    }

    @Information(type = "sanity")
    public void methodB() {
        System.out.println("I am method B");
    }

    @Information(type = "regression")
    public void methodC() {
        System.out.println("I am method C");
    }

}

