class Employee extends Person{

  public double money;
  public double pay;
  public double hours;
  public String password;

  public Employee(String id, String fName, String mNames, String lName, String sex, int age, double money, double pay, String password) {
    super(id, fName, mNames, lName, sex, age);
    this.money = money;
    this.pay = pay;
    this.password = password;
  } // end Employee
} // end class Employee