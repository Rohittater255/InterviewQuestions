package codingPart.programs.basicJava.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Car car = new Car();

        System.out.println("Class name: " + car.getClass().getName());

        //1. Get all Method from Class
        Method[] methods = car.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method name: " + method.getName());
        }

        //2. Get all Variables from Class
        Field[] fields = car.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field name: " + field.getName());
        }


        //3. Setting value in private methods
//        car.setPrivateString();// This will Give compile error

        System.out.println("Before Setting: the value of privateString=" + car.getPrivateString());
        for (Method method : methods) {
            System.out.println("Method name: " + method.getName());
            if (method.getName().equals("setPrivateString")) {
                method.setAccessible(true);//Setting method to be accessible
                method.invoke(car, "I was private String. Now i am overriden by reflection");
            }
        }
        System.out.println("Before Setting: the value of privateString=" + car.getPrivateString());


        //4. Setting value in private field
        //Set a private Fields
        System.out.println("Before Setting: the value of privateString=" + car.getPrivateString());
        for (Field field : fields) {
            //System.out.println("Field name: " + field.getName());
            if (field.getName().equals("privateString")) {
                field.setAccessible(true);
                field.set(car, "I was private String. Now i am overriden by reflection again");
            }
        }
        System.out.println("After Setting:  the value of privateString=" + car.getPrivateString());

    }


}
