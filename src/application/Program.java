package application;

import entities.Department;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String deptName = dptName(sc);
        System.out.println("\bEnter worker data\n");
        String name = workerName(sc);
        WorkerLevel level =WorkerLevel.valueOf(defineLevel(sc));
        Double baseSalary = getBaseSalary(sc);
        int contracts = manyContracts(sc);
        Worker worker = new Worker(name, level, baseSalary, new Department(deptName));
        generateContracts(worker, contracts);


    }

    public static String dptName(Scanner sc) {
        System.out.print("Enter departament's name: ");
        return sc.nextLine();
    }
    public static String workerName(Scanner sc) {
        System.out.print("Name: ");
        return sc.nextLine();
    }
    public static String defineLevel(Scanner sc) {
        System.out.print("Level: ");
        return sc.nextLine();
    }
    public static Double getBaseSalary(Scanner sc) {
        System.out.print("Base salary: ");
        return sc.nextDouble();
    }
    public static int manyContracts(Scanner sc) {
        System.out.print("How many contracts to this worker: ");
        return sc.nextInt();
    }

}
