package cleancode;

import java.util.*;

public class LoosingElementsInSet {
    public static void main(String[] args) {
        Set<Child> children = new HashSet<>();


        List<String> strings = Arrays.asList("a", "b");

        for (String string : strings) {

        }
        
        System.out.println("a");

        Child childOne = new Child("Emma");
        System.out.println(childOne.hashCode());
        children.add(childOne);

        System.out.println(children.contains(childOne));

//        childOne.setName("Emma-Simona");

        System.out.println(childOne.hashCode());
        System.out.println(children.contains(childOne));
    }
}

class Child {
    private final String name;

    Child(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Objects.equals(name, child.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
