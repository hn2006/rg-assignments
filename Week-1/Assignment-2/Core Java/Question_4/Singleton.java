package Question_4;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Private constructor prevents instantiation from other classes
    }

    public static synchronized Singleton getInstance() {
        // Synchronized method to make it thread-safe
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

