package test.interviewQuestions.trickyQuestions;

import org.testng.annotations.Test;

public class TryCatch {

    @Test
    public void tryWithoutCatch() {
        try {

        } finally {
            System.out.println("I am Finally");
        }
    }

    @Test
    public void tryWithMultipleCatch() {
        try {

        } catch (NullPointerException ne) {
            ne.getMessage();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            System.out.println("hi");
        }
    }
}
