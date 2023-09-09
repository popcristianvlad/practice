package thread.safety.sol02.immutable.implementations;

/**
 * If we need to share state between different threads, we can create thread-safe classes by making them immutable.
 * Immutability is a powerful, language-agnostic concept, and it's fairly easy to achieve in Java. To put it simply,
 * a class instance is immutable when its internal state can't be modified after it has been constructed. The easiest
 * way to create an immutable class in Java is by declaring all the fields private and final and not providing setters.
 * A MessageService object is effectively immutable since its state can't change after its construction. So, it's
 * thread-safe. Moreover, if MessageService were actually mutable, but multiple threads only have read-only access to
 * it, it's thread-safe as well. As we can see, immutability is just another way to achieve thread-safety.
 */
public class MessageService {

    private final String message;

    public MessageService(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
