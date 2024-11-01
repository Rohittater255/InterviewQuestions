package codingPart.programs.basicJava.exceptionHandling;

import org.testng.annotations.Test;

public class TryCatch {

    @Test
    public void tryWithoutCatch() {
        try {
            System.out.println("Generic Try Block ");
            throw new MyCustomException("Generic Exception Message");
        } catch (MyCustomException e) {
            System.out.println("Generic Catch Block ");
            System.out.println("Exception " + e);
        } finally {
            System.out.println("Generic Finally Block");
        }
    }

    @Test
    public void tryWithMultipleCatch() {
        try {
            System.out.println("Generic Try Block ");
        } catch (NullPointerException ne) {
            ne.getMessage();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            System.out.println("Generic Finally Block");
        }
    }

    @Test
    public void systemExit() {
        try {
            System.exit(0);//This will be executed
        } catch (Exception e) {
            System.out.println("The Exception is: " + e);//This will not be executed
        } finally {
            System.exit(1);//This will not be executed
        }
    }
}