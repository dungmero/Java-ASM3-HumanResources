package src;

import java.util.ArrayList;

public class Manager extends Staff {
    private String position;


    // CONSTRUCTOR
    public Manager(){
        super();
    }

    public Manager(String name, int id, int age, double salaryFactor, String startDay, String department, int daysOff, String position){
        super(name, id, age, salaryFactor, startDay, department, daysOff);
        this.position = position;
    }

    // GETTER , SETTER
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    
   
    // input method
    public void input(ArrayList<Staff> staffList){
        super.input(staffList);
        System.out.print("Input titles name: ");
        position = sc.nextLine();
    }
    // return int of responsibility salary.
    public int responsibilitySalary(){
        if(position.equalsIgnoreCase("Business Leader")){
            return BUSINESS_LEADER;
        }
        if(position.equalsIgnoreCase("Project Leader")){
            return PROJECT_LEADER;
        }
        if(position.equalsIgnoreCase("Technical Leader")){
            return PROJECT_LEADER;
        }
        return 0;
    }

    @Override
    public double calculateSalary() {
        return getSalaryFactor() * MANAGER_SALARY + responsibilitySalary();
    }

    @Override
    public void payroll(){
        System.out.println("------------------------------------------");
        System.out.println(String.format("Name: %s, Age: %d, Salary: %.0f", getName(), getAge(), calculateSalary()));
    }

    @Override
    public void displayInformation() {
        System.out.println("------------------------------------------");
        System.out.println("Manager ID: " + getId());
        System.out.println("Manager titles name: " + getPosition());
        System.out.println("Manager name: " + getName());
        System.out.println("Manager age: " + getAge());
        System.out.println("Manager salary factor: " + getSalaryFactor());
        System.out.println("Manager date start work: " + getStartDay());
        System.out.println("Manager department: " + getDepartment());
    }

    
}
