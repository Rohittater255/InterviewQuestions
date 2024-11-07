package codingPart.programs.basicJava;

public class MethodOverload_MethodOveride {


    public static void main(String[] args) {
        HelperClass1 help1 = new HelperClass1();
        help1.m1(2);
        help1.m1(2.6);


        HelperClass2 help2 = new HelperClass2();
        help2.m1(2.6);

        HelperClass3 help3 = new HelperClass3();
//        help3.m1(2.6);//compile error
    }


    public static class HelperClass1 {
        public void m1(Double d) {
            System.out.println(" I am printing value of double " + d);
        }

        public void m1(int d) {
            System.out.println(" I am printing value of int " + d);
        }

    }

    public static class HelperClass2 {
        public void m1(Double d) {
            System.out.println(" I am printing value of double " + d);
        }
    }


    public static class HelperClass3 {
        public void m1(int d) {
            System.out.println(" I am printing value of int " + d);
        }
    }
}



