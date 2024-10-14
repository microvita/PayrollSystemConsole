import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hourWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hourWorked, double hourlyRate){
        super(name, id);
        this.hourWorked = hourWorked;
        this.hourlyRate = hourlyRate;
    }

    public  double calculateSalary(){
        return hourWorked * hourlyRate;
    }
}

class PayRollSystem{
    private ArrayList<Employee> employees;

    public PayRollSystem(){
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void removeEmployee(int id){
        Employee removedEmployee = null;
        for(Employee employee : employees){
            if(employee.getId() == id){
                removedEmployee = employee;
                break;
            }
        }

        if(removedEmployee != null){
            employees.remove(removedEmployee);
        }
    }

    public void displayEmployees(){
        for(Employee employee : employees){
            System.out.println(employee);
        }
    }
}

public class Main{
    public static void main(String[] args){
        PayRollSystem payRollSystem = new PayRollSystem();
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("Min Khant", 002, 800000);
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Kyaw Wonna", 003, 72, 10000);
        payRollSystem.addEmployee(fullTimeEmployee);
        payRollSystem.addEmployee(partTimeEmployee);
        System.out.println("Employee List : ");
        payRollSystem.displayEmployees();
        System.out.println("Removable Employee  : ");
        payRollSystem.removeEmployee(003);
        System.out.println("Current Employee List : ");
        payRollSystem.displayEmployees();
    }
}