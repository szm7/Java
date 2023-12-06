class Employee {
    int empID;
    String empName;
    String empDes;
    double weekSalary;
    double hourSalary;
    double bonus;
    double totalBonus;
    String type;

    Employee(int id, String name, String designation) {
        this.empID = id;
        this.empName = name;
        this.empDes = designation;
    }

    public void displayEmployeeDetails() {
        System.out.println("--------------------------");
        System.out.println("Employee ID: " + empID);
        System.out.println("Employee Name: " + empName);
        System.out.println("Designation: " + empDes);
        System.out.println(type + ":" + (type == "Hourly" ? hourSalary : weekSalary));
        System.out.println("Bonus Rate:" + bonus);
        System.out.println("Total Salary:" + totalBonus);
        System.out.println("--------------------------");
    }

    void calculateBonus(double bonus, double salValue) {
        this.totalBonus = salValue * bonus;
    }
}

class HourlyEmployee extends Employee {

    HourlyEmployee(double hourlyRate, int hoursWorked, String name, int id, String designation) {
        super(id, name, designation);
        this.hourSalary = hourlyRate * hoursWorked;
        this.type = "Hourly";

    }

    void calculateBonus() {
        this.bonus = 1.5;
        super.calculateBonus(bonus, hourSalary);
    }
}

class SalariedEmployee extends Employee {
    double mnthSal;
    SalariedEmployee(double monthlySalary, String name, int id, String designation) {
        super(id, name, designation);
        this.mnthSal = monthlySalary;
        this.weekSalary = monthlySalary / 4;
        this.type = "Weekly";
    }
    double AnnualEarnings() {
        return mnthSal * 12;
    }

}

class ExecutiveEmployee extends SalariedEmployee {
    double mnthSal;
    double bonusPer = 8;
    ExecutiveEmployee(double monthlySalary, String name, int id, String designation) {
        super(monthlySalary, name, id, designation);
        this.mnthSal=monthlySalary;

    }
    void calculateBonus() {
        this.bonus = 3.5;
        double executiveBonus = mnthSal * (bonusPer / 100);
        super.calculateBonus(bonus, executiveBonus);
    }
}

class Emp {
    public static void main(String args[]) {
        HourlyEmployee e1 = new HourlyEmployee(45.2, 9, "rahul", 5, "Intern");
        e1.calculateBonus();
        e1.displayEmployeeDetails();

        ExecutiveEmployee e2 = new ExecutiveEmployee(45000, "rahul k", 3, "Project Manager");
        e2.calculateBonus();
        e2.displayEmployeeDetails();
       
    }
}
