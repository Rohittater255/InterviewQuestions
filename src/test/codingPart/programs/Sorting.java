package codingPart.programs;

import org.testng.annotations.Test;

public class Sorting {


    @Test
    public void a() {
        int[] a = {3, 1, 4};

        for (int i = 0; i < a.length; i++) {
            System.out.println("For i=" + i + " the value of =" + a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    //For i=0, j=1
                    int tmp = a[j]; //{3, 1, 4}
                    a[j] = a[i]; //{3, 3, 4}
                    a[i] = tmp;//{1, 3, 4}
                }

            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println("For i=" + i + " the value of =" + a[i]);
        }

    }
}
