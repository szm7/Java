class Employee {
    int empID;
    String empName;
    String empDes;
    double weekSalary;
    double hourSalary;
    double bonus;
    double totalBonus;
    String type;
    double annualEar;

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
        System.out.println(type == "Hourly" ? "" : "Annual Earnings: " + annualEar);
        System.out.println("Total Salary(including bonus):" + totalBonus);
        System.out.println("--------------------------");
    }

    void calculateBonus(double salValue, double totbon) {
        this.totalBonus = salValue + totbon;

    }

    void AnnualEarnings(double ear) {
        this.annualEar = ear * 12;
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
        double totbon = hourSalary * bonus;
        super.calculateBonus(hourSalary, totbon);
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

}

class ExecutiveEmployee extends SalariedEmployee {
    double mnthSal;

    ExecutiveEmployee(double monthlySalary, String name, int id, String designation) {
        super(monthlySalary, name, id, designation);
        this.mnthSal = monthlySalary;

    }

    void AnnualEarnings() {
        super.AnnualEarnings(mnthSal);
    }

    void calculateBonus() {
        this.bonus = 0.02;
        double annualSalary = this.annualEar;
        double totbon = annualSalary * bonus;
        super.calculateBonus(annualSalary, totbon);
    }
}

class Emp {
    public static void main(String args[]) {
        HourlyEmployee e1 = new HourlyEmployee(45.2, 9, "Rohit", 5, "Intern");
        e1.calculateBonus();
        e1.displayEmployeeDetails();

        ExecutiveEmployee e2 = new ExecutiveEmployee(45000, "Iyer", 3, "Project Manager");
        e2.AnnualEarnings();
        e2.calculateBonus();
        e2.displayEmployeeDetails();

    }
}
