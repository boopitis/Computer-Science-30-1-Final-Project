import java.util.*;
import java.io.*;

class BossInterface extends Interface {

  public Scanner numScan = new Scanner(System.in);
  public Scanner wordScan = new Scanner(System.in);
  
  public BossInterface() {} // end BossInterface

  public void chooseTask() {
    String[] tasks = {"Add Employee","View Employees","Add Patient","View Patients","Add Boss","Logout"};
    System.out.println("Chooose Task: (eg. '1')");
    int counter = 1;
    for(String t: tasks) {
      System.out.println(counter + ". " + t);
      counter++;
    }
    int choice = numScan.nextInt();
    Main.lineB(40);
    switch(choice) {
      case 1:
        createEmployee();
        break;
      case 2:
        viewEmployees();
        break;
      /*
      case 3:
        calcEmployeePay();
        break;
      */
      case 3:
        createPatient();
        break;
      case 4:
        viewPatients();
        break;
      case 5:
        createBoss();
        break;
      case 6:
        Main.loop = false;
        break;
      default:
        Main.loop = false;
        break;
    }
  } // end chooseTask

  public void createEmployee() {
    
    String id = String.valueOf(Main.numEmployees + 1);
    for(int i = 0; i < 4 - String.valueOf(Main.numEmployees + 1).length(); i++) {
      id = "0" + id;
    }
    System.out.println("Enter Employee's First Name: (eg. 'Stephen')");
    String fName = wordScan.nextLine();
    System.out.println("Enter Employee's Middle Names: (eg. 'Victor Lorenzana')");
    String mNames = wordScan.nextLine();
    System.out.println("Enter Employee's Last Name: (eg. 'Ravelo')");
    String lName = wordScan.nextLine();
    System.out.println("Enter Employee's Sex: (eg. 'M', 'F', or 'O')");
    String sex = wordScan.nextLine();
    System.out.println("Enter Employee's Age: (eg. '17')");
    String age = wordScan.nextLine();
    String money = "0";
    System.out.println("Enter Employee's Pay: (eg. '25' per hour)");
    String pay = wordScan.nextLine();
    
    String password = "";
    String passwordC = "-";
    while(!password.equals(passwordC)) {
      System.out.println("Enter Password: (eg. '1234')");
      password = wordScan.nextLine();
      System.out.println("Confirm Password: (re-enter the password)");
      passwordC = wordScan.nextLine();
      if(!password.equals(passwordC)) {
        System.out.println("Passwords don't match!");
      }
    }
    

    String data = String.valueOf(id) + "," + fName + "," + mNames + "," + lName + "," + sex + "," + age + "," + money + "," + pay + "," + password;


    int ageI = Integer.valueOf(age);
    int moneyI = Integer.valueOf(money);
    int payI = Integer.valueOf(pay);
    
    Main.employees.add(new Employee(id,fName,mNames,lName,sex,ageI,moneyI,payI,password));

    try {
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Data/epData.txt", true)));
      out.println(data);
      out.close();
    } catch (IOException e) {
      //exception handling left as an exercise for the reader
    }
  
  } // end createEmployee

  public void viewEmployees() {
    Main.epData = Main.eViewer.sort();
    Main.eViewer.view();
  } // end viewEmployees

  //public void calcEmployeePay() {} // end calcEmployeePay

  public void createBoss() {
    
    String id = String.valueOf(Main.numBosses + 1);
    for(int i = 0; i < 2 - String.valueOf(Main.numBosses + 1).length(); i++) {
      id = "0" + id;
    }
    System.out.println("Enter Boss' First Name: (eg. 'Stephen')");
    String fName = wordScan.nextLine();
    System.out.println("Enter Boss' Middle Names: (eg. 'Victor Lorenzana')");
    String mNames = wordScan.nextLine();
    System.out.println("Enter Boss' Last Name: (eg. 'Ravelo')");
    String lName = wordScan.nextLine();
    System.out.println("Enter Boss' Sex: (eg. 'M', 'F', or 'O')");
    String sex = wordScan.nextLine();
    System.out.println("Enter Boss' Age: (eg. '17')");
    String age = wordScan.nextLine();
    
    String password = "";
    String passwordC = "-";
    while(!password.equals(passwordC)) {
      System.out.println("Enter Password: ");
      password = wordScan.nextLine();
      System.out.println("Confirm Password: ");
      passwordC = wordScan.nextLine();
      if(!password.equals(passwordC)) {
        System.out.println("Passwords don't match!");
      }
    }
    

    String data = String.valueOf(id) + "," + fName + "," + mNames + "," + lName + "," + sex + "," + age + "," + password;

    int ageI = Integer.valueOf(age);
    
    Main.bosses.add(new Boss(id,fName,mNames,lName,sex,ageI,password));

    try {
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Data/bData.txt", true)));
      out.println(data);
      out.close();
    } catch (IOException e) {
      //exception handling left as an exercise for the reader
    }
  
  } // end createBoss
  
} // end class BossInterface