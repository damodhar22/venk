package exp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapContract {

    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        Person p = new Person("venky", 30);
        map.put(p, "SWE");
    }

}

// The hashCode and HashMap for Person method is implemented correctly
// It can now be used as key in HashMap.
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && age == person.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}