package x07-java.x07-advanced;

public class JavaSingletonPattern {

    private static JavaSingletonPattern instance;
    public String str;

    private JavaSingletonPattern() {
    }

    public static JavaSingletonPattern getSingleInstance() {
        if (instance == null) {
            instance = new JavaSingletonPattern();
        }
        return instance;
    }
}
