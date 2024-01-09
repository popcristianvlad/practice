package x07_java.x05_object_oriented_programming;

class Animal {
    void walk() {
        System.out.println("I am walking");
    }
}

class Bird extends x07_java.x05_object_oriented_programming.Animal {
    void fly() {
        System.out.println("I am flying");
    }

    void sing() {
        System.out.println("I am singing");
    }
}

public class JavaInheritanceI {

    public static void main(String args[]) {
        Bird bird = new Bird();
        bird.walk();
        bird.fly();
        bird.sing();
    }
}
