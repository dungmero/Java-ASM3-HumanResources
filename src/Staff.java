package src;

import java.util.ArrayList;
import java.util.Scanner;


public abstract class Staff implements ICalculator{
    private String name;
    private int id;
    private int age;
    private double salaryFactor;
    private String startDay;
    private String department;
    private int daysOff;
    Scanner sc = new Scanner(System.in);


    // CONSTRUCTOR
    public Staff(){

    }

    public Staff(String name, int id, int age, double salaryFactor, String startDay, String department, int daysOff){
        this.name = name;
        this.id = id;
        this.age = age;
        this.salaryFactor = salaryFactor;
        this.startDay = startDay;
        this.department = department;
        this.daysOff = daysOff;
    }

    // GETTER , SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalaryFactor() {
        return salaryFactor;
    }

    public void setSalaryFactor(double salaryFactor) {
        this.salaryFactor = salaryFactor;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }
    

    public void input(ArrayList<Staff> staffList){
        System.out.println("------------------------------------------");
        while(true){
        System.out.print("Input id: ");
            id = Integer.parseInt(sc.nextLine());
            boolean isFind = false;
            for (Staff staff : staffList) {
                if(staff.getId() == id){
                    isFind = true;
                }
            }
            if(!isFind){
                break;
            } else {
                System.err.println("ID already exists");
            }
        }

        System.out.print("Input name: ");
        name = sc.nextLine();

        System.out.print("Input age: ");
        age = Integer.parseInt(sc.nextLine());

        System.out.print("Input salary factor: ");
        salaryFactor = Double.parseDouble(sc.nextLine());

        System.out.print("Input date start work: ");
        startDay = sc.nextLine();

        System.out.print("Input department name: ");
        department = sc.nextLine();

        System.out.print("Input day off: ");
        daysOff = Integer.parseInt(sc.nextLine());
    }

    public abstract void payroll();
    

    // ABSTRACT METHOD
    public abstract void displayInformation();
}
