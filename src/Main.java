import java.util.ArrayList;
import java.util.Scanner;
//Employee Class
abstract class Employee{
  private int id;
  private  String name;
  protected double bonus; // Child class can access easily


   public Employee(int id , String name){
      this.id = id;
      this.name = name ;
  }
  public String getName( ){
       return name;

  }
  public  int getid(){
       return id;
  }


 abstract  double calculateSalary();
   @Override
    public String toString(){
       return "Employee[name = " +name + ",id = "+id+ ", salary = " +calculateSalary()+"]";
   }


   public void setBonus(double bonus){
       this.bonus = bonus;
   }
   public double getBonus(){
       return bonus;
   }
}

// FullTimeEmployee Class
class FulltimeEmployee extends Employee {
    private double monthlySalary;


    FulltimeEmployee(String name, int id, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;

    }

    @Override
    public double calculateSalary() {
        return monthlySalary + bonus;

    }

}
class PartTimeEmployee extends  Employee{
    private int hourWork;
    private double hourlyRate;
     public PartTimeEmployee(String name , int id , int hourWork, double hourlyRate){
         super(id, name);
         this. hourlyRate = hourlyRate;
         this.hourWork = hourWork;
     }
     @Override
     public double  calculateSalary(){
         return hourlyRate*hourWork + bonus;
     }



}
class PayRollSystem{
    private ArrayList<Employee> employeeList ;
    public PayRollSystem(){
       employeeList = new ArrayList<>();

    }
    // To Add Employee
    public void addEmployee(Employee employee){
        employeeList.add(employee);

    }
    // To remove Employee
    public void removeEmployee(int id ){
        Employee removeToEmployee = null;
        for(Employee emp : employeeList){
            if(emp.getid() == id) {
                removeToEmployee = emp;
            }
        }
        System.out.println("Removed Employee Type :" + removeToEmployee.getClass());
        if(removeToEmployee != null){
            employeeList.remove(removeToEmployee);
        }
        else{
            System.out.println("Employee Does Not Exits ");
        }
    }
    public void displayEmployee(){
        for(Employee emp : employeeList){
            System.out.println(emp);
        }
    }

    public Employee searchEmployee(int id){
        for(Employee emp : employeeList){
            if(emp.getid()== id){
                System.out.println(emp);;
            }
        }
        return  null;

    }
    public void EmployeeBonus(int id , double bonus){
        for(Employee emp : employeeList){
            if(emp.getid() == id){
                emp.setBonus(bonus);
                System.out.println("Bonus Added :");
                return;
            }
        }
        System.out.println("Employee Not Found ");

    }
}

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//      PayRollSystem payroll = new PayRollSystem();
//      FulltimeEmployee emp1 = new FulltimeEmployee("Nilesh" , 1, 70000);
//      PartTimeEmployee emp2 = new PartTimeEmployee("Rahul" , 2,8,500);
//      payroll.addEmployee(emp1);
//      payroll.addEmployee(emp2);
//        System.out.println("Initial EMployee Details: ");
//        payroll.displayEmployee();
//
//        payroll.EmployeeBonus(1,5000);
//        payroll.EmployeeBonus(2,600);
//        payroll.displayEmployee();
//


        Scanner sc  = new Scanner(System.in);
        PayRollSystem payroll = new PayRollSystem();
        while (true) {
            System.out.println("\n===== Payroll Management System =====");
            System.out.println("1.Add Employee");
            System.out.println("2.Remove Employee");
            System.out.println("3.Search Employee");
            System.out.println("4.Display Employee");
            System.out.println("5.Add Bonus");
            System.out.println("6. Exit");


            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter Id :");
                    int id = sc.nextInt();
                    System.out.println("Enter Name:");
                    String name = sc.nextLine();
                    sc.nextLine();
                    System.out.println("1.Full Time");
                    System.out.println("2.Part Time");
                    int type = sc.nextInt();
                    if (type == 1) {
                        System.out.println("Enter Monthly Salary :");
                        double salary = sc.nextDouble();
                        payroll.addEmployee(new FulltimeEmployee(name, id, salary));

                    } else {
                        System.out.println("Enter hourRate :");
                        double hourRate = sc.nextDouble();
                        System.out.println("Enter total hour ");
                        int workhour = sc.nextInt();
                        payroll.addEmployee(new PartTimeEmployee(name, id, workhour, hourRate));
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter the Employee Id which you want to remove");
                    int id = sc.nextInt();
                    payroll.removeEmployee(id);
                    break;
                }

                case 3: {
                    System.out.println("Enter the Employee id Which you Want to Search :");
                    int id = sc.nextInt();
                    payroll.searchEmployee(id);
                    break;

                }
                case 4: {
                    payroll.displayEmployee();

                    break;
                }
                case 5: {
                    System.out.println("Enter the amount of  bonus ans his Id  for Employee  ");
                    double bonus = sc.nextDouble();
                    int id = sc.nextInt();
                    payroll.EmployeeBonus(id, bonus);
                    break;
                }
                case 6: {
                    System.out.println("Exiting.....");
                    return;
                }
                default: {
                    System.out.println("Invalid Choice");
                }
            }
        }



    }

}