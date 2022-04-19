package src;
import java.util.ArrayList;

public class Employee extends Staff {
    private int overtime;

    // CONSTRUCTOR
    public Employee(){
        super();
    }

    public Employee(String name, int id, int age, double salaryFactor, String startDay, String department, int daysOff, int overtime){
        super(name, id, age, salaryFactor, startDay, department, daysOff);
        this.overtime = overtime;
    }

    // GETTER , SETTER
    public int getOvertime() {
        return overtime;
    }
    
    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }
    
    
    public void input(ArrayList<Staff> staffList){
        super.input(staffList);
        System.out.print("Input overtime: ");
        overtime = sc.nextInt();
    }

    @Override
    public double calculateSalary(){
        return getSalaryFactor() * EMPLOYEE_SALARY + getOvertime() * 200000;
    }

    @Override
    public void payroll(){
        System.out.println("------------------------------------------");
        System.out.println(String.format("Name: %s, Age: %d, Salary: %.0f", getName(), getAge(), calculateSalary()));
    }

    @Override
    public void displayInformation() {
        System.out.println("------------------------------------------");
        System.out.println("Employee ID: " + getId());
        System.out.println("Employee name: " + getName());
        System.out.println("Employee age: " + getAge());
        System.out.println("Employee salary factor: " + getSalaryFactor());
        System.out.println("Employee date start work: " + getStartDay());
        System.out.println("Employee department: " + getDepartment());
    }

 
}
