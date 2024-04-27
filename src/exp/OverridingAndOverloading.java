package exp;

public class OverridingAndOverloading {
    public int test(int i){
        return i;
    }

//    public String test(int i){
//        return new String(i+"");
//    }

    static int add(int x, int y) {
        return x + y;
    }

    static double add(double x, double y) {
        return x + y;
    }
}

class Vehicle {
    public void move(int k) {
        System.out.println("The vehicle is moving");
    }
}

class Car extends Vehicle {
    @Override
    public void move(int k) {
        System.out.println("The car is moving");
    }
}
