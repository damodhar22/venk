package exp;

public class StaticKeyWord {
    public static String NAME = "MyClass";

    // Static method
    public static int square(int x) {
        return x * x;
    }

    // Static block
    // A static block in Java is a block of code that is executed when the class is loaded into memory.
    // It is executed before the main() method. Static blocks are mainly used to initialize static variables.

    static {
        // Initialize static variables
        NAME = "MyClass";
    }

    // Static nested class
    public static class InnerClass {
        // ...
    }

    public static void main(String[] args) {
        System.out.println(square(10));
        // test(); // Fails cannot use non static members from static block;
    }

    public void test(){
        System.out.println(StaticKeyWord.square(10));
    }
}
