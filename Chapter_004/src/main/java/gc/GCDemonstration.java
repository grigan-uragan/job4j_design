package gc;

public class GCDemonstration {
    public static final Runtime ENVIRONMENT = Runtime.getRuntime();

    //-Xmx6m -Xms6m -XX:MaxGCPauseMillis=1500

    public static void createEmptyPerson(int quantity) {
        int i = 0;
        long freeMemoryBefore  = ENVIRONMENT.freeMemory();

        while (i < quantity) {
            new Person();
            i++;
        }
        long freeMemoryAfter = ENVIRONMENT.freeMemory();
        System.out.println("Differences memory after create " + i + " empty Person object");
        System.out.println("differences "
                + (freeMemoryBefore - freeMemoryAfter) / i + "=======");
    }

    public static void createPersonWithInstance(int quantity) {
        int i = 0;
        long freeMemoryBefore  = ENVIRONMENT.freeMemory();

        while (i < quantity) {
            new Person(i, "Person_" + i);
            i++;
        }
        long freeMemoryAfter = ENVIRONMENT.freeMemory();
        System.out.println("Differences memory after create " + i + " Person object with instant");
        System.out.println("differences "
                + (freeMemoryBefore - freeMemoryAfter) / i + "=======");
    }

    public static void main(String[] args) throws InterruptedException {
        createPersonWithInstance(20000);
        createEmptyPerson(20000);
    }
}
