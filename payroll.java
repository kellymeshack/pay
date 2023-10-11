import java.util.ArrayList;
import java.util.Scanner;

class Worker {
    private String name;
    private int id;
    private double salary;

    public Worker(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker [name=" + name + ", id=" + id + ", salary=" + salary + "]";
    }
}

public class payroll {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Admit Worker");
            System.out.println("2. Manage Payroll");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    admitWorker(workers, scanner);
                    break;
                case 2:
                    managePayroll(workers, scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void admitWorker(ArrayList<Worker> workers, Scanner scanner) {
        System.out.print("Enter worker name: ");
        String name = scanner.next();
        System.out.print("Enter worker ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter worker salary: ");
        double salary = scanner.nextDouble();

        Worker worker = new Worker(name, id, salary);
        workers.add(worker);
        System.out.println("Worker admitted: " + worker);
    }

    private static void managePayroll(ArrayList<Worker> workers, Scanner scanner) {
        System.out.println("Current Workers:");
        for (Worker worker : workers) {
            System.out.println(worker);
        }

        System.out.print("Enter worker ID to update salary: ");
        int id = scanner.nextInt();

        for (Worker worker : workers) {
            if (worker.getId() == id) {
                System.out.print("Enter new salary: ");
                double newSalary = scanner.nextDouble();
                worker.setSalary(newSalary);
                System.out.println("Salary updated for worker: " + worker);
                return;
            }
        }

        System.out.println("Worker with ID " + id + " not found.");
    }
}
