package test.codingPart.programs.memoryManagement;

import org.testng.annotations.Test;

import java.lang.ref.WeakReference;

public class memoryManagementExample {

    @Test
    public void a() {
        // Create a strong reference to an object
        MyObject strongReference = new MyObject("Strong Reference");

        // Create a weak reference
        WeakReference<MyObject> weakReference = new WeakReference<>(new MyObject("Weak Reference"));

        // Print the object using the strong reference
        System.out.println("Strong Reference: " + strongReference);

        // Print the object using the weak reference
        System.out.println("Weak Reference: " + weakReference.get());

        // Suggest the JVM to run the garbage collector
        System.gc();

        // Check if the weak reference still holds the object
        if (weakReference.get() != null) {
            System.out.println("Weak Reference after GC: " + weakReference.get());
        } else {
            System.out.println("Weak Reference has been garbage collected");
        }
    }

}

class MyObject {
    private String name;

    public MyObject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;

    }
}