package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class HumanResoucres {
    public static void main(String[] args) throws Exception {
        // list of departments in the company
        ArrayList<Department> departmentList = new ArrayList<>();
        departmentList.add(new Department("business", 4));
        departmentList.add(new Department("technical", 2));
        departmentList.add(new Department("project", 2));
        
        // Current staff list
        ArrayList<Staff> staffList = new ArrayList<>();
        staffList.add(new Employee("Nguyen Van A", 101, 20, 1.0, "19/4/2021","business", 5, 5));
        staffList.add(new Employee("Nguyen Van B", 201, 21, 1.0, "15/2/2021","project", 5, 6));
        staffList.add(new Employee("Nguyen Van C", 301, 18, 1.0, "1/12/2020","technical", 5, 8));
        staffList.add(new Employee("Nguyen Van D", 102, 19, 1.0, "11/2/2021","business", 5, 3));
        staffList.add(new Manager("Nguyen Van E", 103, 31, 1.5, "1/5/2019","business", 6, "business leader"));
        staffList.add(new Manager("Nguyen Van F", 104, 30, 1.5, "3/6/2018","business", 6, "business leader"));
        staffList.add(new Manager("Nguyen Van G", 202, 41, 1.3, "20/7/2020","project", 6, "project leader"));
        staffList.add(new Manager("Nguyen Van H", 302, 35, 1.4, "8/11/2015","technical", 6, "technical leader"));
        
        int choose;
        Scanner sc = new Scanner(System.in);
        do {
            showMenu();
            
            choose = Integer.parseInt(sc.nextLine());
            /***
             * choose = 1 => run case 1: Use foreach to browse the list of staffList and print out all employees in the company
             * choose = 2 => run case 2: Print out information about departments in the company
             * choose = 3 => run case 3: Print out the list of employees in each department in turn
             * choose = 4 => run case 4: Add new employees to the company, there are 2 ways to add 
             *                                                              1, add regular employees 
             *                                                              2, add managers
             *                                                              3, back menu
             * choose = 5 => run case 5:Search for employees by name or by ID, there is a submenu with 3 options 
             *                                                              1, search by name 
             *                                                              2, search by ID 
             *                                                              3, back menu
             * choose = 6 => run case 6: Print payroll of all employees
             * choose = 7 => run case 7: Print employee payroll in ascending order
             * choose = 8 => run case 8: Exit
             */
            switch (choose) {
                case 1:
                    for (Staff staff : staffList) {
                        staff.displayInformation();
                    }
                    break;

                case 2:
                    for (Department department : departmentList) {
                        System.out.println(department.toString());
                    }
                    break;

                case 3:
                for (Department department : departmentList) {
                    System.out.println(department.toString());
                    for (Staff staff : staffList) {
                        if(department.getPartName().equals(staff.getDepartment())){
                            staff.displayInformation();
                        }
                    }
                }
                    break;

                case 4:
                    System.out.println("    1. Add employee staff");
                    System.out.println("    2. Add manager staff");
                    System.out.println("    3. Menu");
                    choose = Integer.parseInt(sc.nextLine());
                    switch (choose) {
                    case 1:
                        Employee employee = new Employee();
                        employee.input(staffList);
                        for(Department department: departmentList){
                            if(employee.getDepartment().equals(department.getPartName())){
                                department.setCurrentNumberEmployees(department.getCurrentNumberEmployees()+1);
                            }
                        }

                        staffList.add(employee);
                        break;
                    case 2:
                        Manager manager = new Manager();
                        manager.input(staffList);
                        for(Department department: departmentList){
                            if(manager.getDepartment().equals(department.getPartName())){
                                department.setCurrentNumberEmployees(department.getCurrentNumberEmployees()+1);
                            }
                        }

                        staffList.add(manager);
                        break;
                    default:
                        break;
                }
                break;
                
                case 5:
                    System.out.println("    1. Find employees by name");
                    System.out.println("    2. Find employees by ID");
                    System.out.println("    3. Menu");
                    choose = Integer.parseInt(sc.nextLine());
                    switch (choose) {
                        case 1:
                            System.out.print("Input name: ");
                            String findName = sc.nextLine();
                            boolean isName = true;
                            for (Staff staff : staffList) {
                                if(staff.getName().toLowerCase().contains(findName)){ 
                                    staff.displayInformation();
                                    isName = false;
                                    break;
                                }
                            }
                            if(isName){
                                System.out.println(findName +" does not exist.");
                            }
                            break;
                        case 2:
                            System.out.print("Input ID: ");
                            String ids = sc.nextLine();
                            boolean isId = true;
                            for (Staff staffs : staffList) {
                                if(ids.contains(Integer.toString(staffs.getId()))){
                                    staffs.displayInformation();
                                    isId = false;
                                    break;
                                }
                            }
                            if(isId){
                                System.out.println(ids +" does not exist.");
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 6:
                Collections.sort(staffList, (o1, o2) -> (int)(o2.calculateSalary() - o1.calculateSalary()));
                    for (Staff staff : staffList) {
                        staff.payroll();
                    }
                    break;

                case 7:
                Collections.sort(staffList, new Comparator<Staff>() {
                    @Override
                    public int compare(Staff o1, Staff o2) {
                        return (int)(o1.calculateSalary() - o2.calculateSalary());
                    }
                });

                for (Staff staff : staffList) {
                    staff.payroll();
                }
                    break;
                case 8:
                    System.out.println("Goodbye!!!");
                    break;           
                default:
                    System.err.println("Enter wrong, re-enter!");
                    break;
            }
        } while(choose != 8);
        sc.close();
    }

    static void showMenu(){
        System.out.println();
        System.out.println("-----------------Menu---------------------");

        System.out.println("1. Display the list of existing employees in the company");
        System.out.println("2. Show departments in the company ");
        System.out.println("3. Show employees by department ");
        System.out.println("4. Add new employees to the company ");
        System.out.println("5. Search for employees by name or employee ID");
        System.out.println("6. Show payroll of employees throughout the company");
        System.out.println("7. Display employee payroll in ascending order");
        System.out.println("8. Exit");
    }
}
