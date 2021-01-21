package gc;

public class GCDemo {
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("====== Environment state ============");
        System.out.printf("free memory space %s\n", freeMemory / MB);
        System.out.printf("total memory space %s\n", totalMemory / MB);
        System.out.printf("max memory space %s\n", maxMemory / MB);
    }

    public static void main(String[] args) throws InterruptedException {
        info();
        for (int i = 0; i < 10000; i++) {
            new Person(i, "Agent #");
            Thread.sleep(1);
        }
        info();
    }
}
