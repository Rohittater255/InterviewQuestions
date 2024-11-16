package test.codingPart.programs.basicJava;

public class Static_NonStatic_InnerClass {


    // Static inner class
    public static class StaticInnerClass {
        public String a1;

        public void m1() {
            System.out.println("Inside static inner class method m1");
        }
    }

    // Non-static inner class
    public class NonStaticInnerClass {
        public String a2;

        public void m2() {
            System.out.println("Inside non-static inner class method m2");
        }
    }

    public static void main(String[] args) {
        // Accessing the static inner class
        StaticInnerClass staticInstance = new StaticInnerClass();
        staticInstance.m1();
        staticInstance.a1 = "Static inner class variable";
        System.out.println(staticInstance.a1);

        // Accessing the static inner class
        StaticInnerClass staticInstance1 = new StaticInnerClass();
        staticInstance1.m1();
        staticInstance1.a1 = "Static inner class variable";
        System.out.println(staticInstance1.a1);



        // Accessing the non-static inner class
        Static_NonStatic_InnerClass outerInstance = new Static_NonStatic_InnerClass();
        NonStaticInnerClass nonStaticInstance = outerInstance.new NonStaticInnerClass();
        nonStaticInstance.m2();
        nonStaticInstance.a2 = "Non-static inner class variable";
        System.out.println(nonStaticInstance.a2);
    }
}
