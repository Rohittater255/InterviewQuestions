package codingPart.programs.basicJava.annotions;
import java.lang.annotation.Annotation;


public class AnnotationsTest {

    public static void main(String[] args)   {

        // Get the class object
        Class<ClassUsingAnnotations> obj = ClassUsingAnnotations.class;

        // Get all annotations applied to the class
        Annotation[] annotations = obj.getAnnotations();
        System.out.println("Annotation Information: " +  annotations.length);

        // Print all annotations
        for (Annotation annotation : annotations) {
            if (annotation instanceof Information) {
                Information info = (Information) annotation;
                System.out.println("Annotation Information: " + info.drop());
            }
        }
    }
}

