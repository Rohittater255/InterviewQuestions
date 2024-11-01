package codingPart.programs.basicJava.reflection;

//Suppose class have 2 variables, with getters and setters.
// The private String have dont have setter method.
public   class Car {

    private String privateString = "I am Private String.";
    public String publicString = "I am Public String.";

    private void setPrivateString(String privateString) {
        this.privateString = privateString;
    }

    public String getPublicString() {
        return publicString;
    }

    public void setPublicString(String publicString) {
        this.publicString = publicString;
    }

    public String getPrivateString() {
        return privateString;
    }
}