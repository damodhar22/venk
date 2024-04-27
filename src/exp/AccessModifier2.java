package exp;

public class AccessModifier2 {
    private int data=40;
    private void msg(){System.out.println("Hello java");}

    int data2=40;
    void msg2(){System.out.println("Hello java");}

    public static void main(String[] args) {
        AccessModifier2 obj2= new AccessModifier2();
        // Private member access same class success
        System.out.println(obj2.data);
        obj2.msg();
    }
}
