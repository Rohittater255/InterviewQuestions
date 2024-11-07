package codingPart.programs.basicJava.exceptionHandling;

import org.testng.annotations.Test;

public class ExceptionHandling2 {

    @Test
    public void runtime() {
        try {
            throw new RuntimeException();
        } finally {
            System.out.println("Finally Block");
        }
    }

    @Test
    public void test() {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e);
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("RuntimeException:- " + e);
        } finally {
            System.out.println("Finally Block");
        }
    }

    @Test
    public void a() {
        try {
            return;
        } catch (Exception e) {
            System.out.println("Generic Catch Statement");
        } finally {
            System.out.println("Generic Finally Statement");
        }
    }

    @Test
    public void b() {
        try {
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Generic Catch Statement");
        } finally {
            System.out.println("Generic Finally Statement");
        }
    }
}
