package test.codingPart.programs.basicJava.enumExamples;

public class EnumExample {

    //these are enum constansts
    //they are public static and final
    enum Week {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    //Enum can implement interface
    enum Month implements GenericInterface {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;

        //Implement method from interfece
        @Override
        public void hello() {
            System.out.println("printing hello");
        }

        //Create method specific for enum
        public static String  hi() {
            return "printing hi" ;
        }
    }

    //Enum cannot extend class
//    enum Month extends GenericClass {}

    public static void main(String[] args) {
        //Print all values from enum
        for (Week day : Week.values()) {
            System.out.println(day);
        }

        //Print specific values from enum
        System.out.println("Printing specific values " + Week.SUNDAY);

        //Print specific values from enum
        Week week = Week.THURSDAY;
        System.out.println("Printing Index  " + week.ordinal());




        System.out.println("Using Enum method " + Month.hi());

    }
}
