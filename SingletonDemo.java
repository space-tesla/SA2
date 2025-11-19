
class Singleton {

    private static Singleton instance;

    // private constructor
    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {                     // First check
            synchronized (Singleton.class) {
                if (instance == null) {             // Second check
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void display() {
        System.out.println("Singleton Instance HashCode: " + this.hashCode());
    }
}

public class SingletonDemo {
    public static void main(String[] args) {

        // Create multiple threads trying to get instance
        Runnable task = () -> {
            Singleton obj = Singleton.getInstance();
            obj.display();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
    }
}
