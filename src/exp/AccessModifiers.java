package exp;

import exp2.AccessModifier3;
import exp2.AccessModifier4;

public class AccessModifiers extends AccessModifier4 {

    public static void main(String[] args) {
        AccessModifiers obj = new AccessModifiers();
        obj.test();
    }

    public void test(){

        // Same package access modifier test
        AccessModifier2 obj2= new AccessModifier2();
        // Private member access fails in same package
        // System.out.println(obj2.data);//Compile Time Error
        // obj2.msg();//Compile Time Error
        // Default member access in same package success
        System.out.println(obj2.data2);
        obj2.msg2();

        // Different package access modifier test
        AccessModifier3 obj3= new AccessModifier3();
        // Default member access in different package fails
        // System.out.println(obj3.data); //Compile Time Error
        // obj3.msg(); //Compile Time Error
        // Protected member access in different package fails
        // System.out.println(obj3.data2); //Compile Time Error
        // obj3.msg2(); //Compile Time Error
        // Public member access in different package success
        System.out.println(obj3.data3);
        obj3.msg3();

        // Subclass in Different package access modifier test
        AccessModifiers obj= new AccessModifiers();
        // Default member access in different package fails
        // System.out.println(obj.data); //Compile Time Error
        // obj.msg(); //Compile Time Error
        // Protected member access in different package fails
        System.out.println(obj.data4); //Compile Time Error
        obj.msg4(); //Compile Time Error
        // Public member access in different package success
        System.out.println(obj.data5);
        obj.msg5();

    }


}
