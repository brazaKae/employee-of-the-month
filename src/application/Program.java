package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        generateContracts(worker, contracts, sc);


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
    public static void generateContracts(Worker worker, int contracts, Scanner sc) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < contracts; i++) {
            System.out.println("Enter contract #" + (i+1) + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            sc.nextLine();
            String strData = sc.nextLine();
            Date date;
            try {
                date = dateFormat.parse(strData);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            System.out.print("Value per hour: ");
            double hourSalary = sc.nextDouble();
            System.out.print("Duration: ");
            int duration = sc.nextInt();
            worker.addContract(new HourContract(date, hourSalary, duration ));
        }
    }
}
