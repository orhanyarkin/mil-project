package hww2;

public class Employee extends Person {
    private int employeeId;
    private double monthlySalary;

    public Employee(int employeeId, String name, double monthlySalary) {
        super(name);
        this.employeeId = employeeId;
        this.monthlySalary = monthlySalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void sendEmail() {
        String message = "Sevgili " + getName() + ",\n" +
                "Aylik maasin " + monthlySalary + " TL.\n" +
                "ID numaran " + employeeId + ".";
        System.out.println(message);
    }
}
