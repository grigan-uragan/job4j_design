package garbageCollector;

public class GCDemonstration {
    public static final Runtime ENVIRONMENT = Runtime.getRuntime();
    //-Xmx4m -Xms4m
    public static void createEmptyPerson(int quantity) {
        int i = 0;
        long freeMemoryBefore  = ENVIRONMENT.freeMemory();

        while (i < quantity) {
            new Person();
            i++;
        }
        long freeMemoryAfter = ENVIRONMENT.freeMemory();
        System.out.println("Differences memory after create " + i + " empty Person object");
        System.out.println("differences " + (freeMemoryBefore - freeMemoryAfter));
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
        System.out.println("differences " + (freeMemoryBefore - freeMemoryAfter));
    }

    public static void main(String[] args) {
        createPersonWithInstance(1000);
        createEmptyPerson(1000);
    }
}
