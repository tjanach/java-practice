package examples.objectModifiedInsideAMethod;

public class NewObjectInMethod {

    /*
    * this is a demo of changing the object in a method
    * though the emp is created inside a method, the emp in main method was only changed by the first line (17)
    *
    * */
    public static void main(String[] args){
        NewObjectInMethod test = new NewObjectInMethod();
        Employee emp = new Employee();
        emp.setSalary(120000.05);
        test.changeSalary(emp);
        System.out.println("Salary is: "+emp.getSalary());
    }

    public void changeSalary(Employee emp) {
        emp.setSalary(110000.03);
        emp = new Employee();
        emp.setSalary(130000.04);
    }

}
