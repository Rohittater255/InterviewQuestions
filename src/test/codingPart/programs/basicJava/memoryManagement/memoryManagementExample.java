package test.codingPart.programs.basicJava.memoryManagement;

import org.testng.annotations.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class memoryManagementExample {

    @Test
    public void typesOfReference() {
        // Create a strong reference to an object
        MyObject strongReference = new MyObject("Strong Reference");

        // Create a weak reference
        WeakReference<MyObject> weakReference = new WeakReference<>(new MyObject("Weak Reference"));

        // Create a soft reference
        SoftReference<MyObject> softReference = new SoftReference<>(new MyObject("Soft Reference"));

        // Print the object using the strong reference
        System.out.println("Strong Reference: " + strongReference);

        // Print the object using the weak reference
        System.out.println("Weak Reference: " + weakReference.get());

        // Print the object using the soft reference
        System.out.println("Soft Reference: " + softReference.get());

        // Suggest the JVM to run the garbage collector
        System.gc();

        // Check if the weak reference still holds the object
        if (weakReference.get() != null) {
            System.out.println("Weak Reference after GC: " + weakReference.get());
        } else {
            System.out.println("Weak Reference has been garbage collected");
        }

        // Check if the Soft reference still holds the object
        if (softReference.get() != null) {
            System.out.println("Soft Reference after GC: " + softReference.get());
        } else {
            System.out.println("Soft Reference has been garbage collected");
        }
    }


    @Test
    public void typeOfReference() {
        // Create a reference to an object
        MyObject reference = new MyObject("Object Reference");

        // Print the object using the reference
        System.out.println("Reference: " + reference.name);

        // Create a reference to an object
        reference = null;

        // Print the object using the reference
        System.out.println("Reference: " + reference.name);
    }
}

class MyObject {
    public String name;

    public MyObject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


}