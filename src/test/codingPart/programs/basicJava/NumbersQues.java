package codingPart.programs.basicJava;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class NumbersQues {

    @Test
    public void fibonacci() {
    }


    @Test(description = "https://leetcode.com/problems/strobogrammatic-number/description/?envType=problem-list-v2&envId=string")
    public void strobogrammatic() {
        int n = 9669;
        ArrayList<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 10);
            n = n / 10;
        }

        System.out.println("######### Printing Numbers ######## " );
        for (int i = 0; i < list.size(); i++)
            System.out.println("Number: "+ list.get(i));


        System.out.println("######### Strobogrammatic Number ######## " );
        int startIndex=0;
        int endIndex=list.size()-1;
        boolean flag=true;

        for (int i = 0; i < list.size()/2; i++) {
            System.out.println("startIndex: "+ list.get(startIndex));
            System.out.println("endIndex: "+ list.get(endIndex));
            startIndex++;
            endIndex--;
            if((list.get(startIndex)== list.get(endIndex)) ||
                    (list.get(startIndex)==6  && list.get(endIndex)==9) ||
                    (list.get(startIndex)==9  && list.get(endIndex)==6)){
               continue;
            }else {
                flag =false;
                break;
            }
        }

        if(flag==false){
            System.out.println("This is not Strobogrammatic Number");
        }
        else{
            System.out.println("This is Strobogrammatic Number");
        }

    }

}
