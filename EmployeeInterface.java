import java.util.*;
import java.time.LocalTime;

class EmployeeInterface extends Interface {

  public Scanner numScan = new Scanner(System.in);
  public Scanner wordScan = new Scanner(System.in);

  public String[] arr;
  public int index;

  public EmployeeInterface(String[] arr) {
    this.arr = arr;
  } // end EmployeeInterface

  public void chooseTask() {
    
    for (int i=0; i < arr.length; i+=9) {
      int num = Integer.valueOf(arr[i]);
      if(num == Main.logged) {
        index = i;
      }
    }
    
    String[] tasks = {"Add Patient","View Patients","Clock Out"};
    System.out.println("Chooose Task:");
    int counter = 1;
    for(String t: tasks) {
      System.out.println(counter + ". " + t);
      counter++;
    }
    int choice = numScan.nextInt();
    Main.lineB(40);
    switch(choice) {
      case 1:
        createPatient();
        break;
      case 2:
        viewPatients();
        break;
      /*
      case 3:
        collectPay();
        System.out.println("You now have: $" + Main.epData[index+6]);
        break;
      */
      case 3:
        System.out.println("You worked for " + clockOut() + " minutes.");
        Main.loop = false;
        break;
      default:
        Main.loop = false;
        break;
    }
  } // end chooseTask

  /*
  public void collectPay() {
    int pay = Integer.valueOf(Main.epData[index+7]);
    int mins = Integer.valueOf(Main.epData[index+9]);
    Main.epData[index+6] = String.valueOf(pay/60*mins);
  } // end collectPay
  */

  public int clockOut() {
    int then = Main.time.getHour() * 60 + Main.time.getMinute();
    int now = LocalTime.now().getHour() * 60 + LocalTime.now().getMinute();
    //Main.epData[index+9] += now - then;
    return now - then;
  } // end recievePay
  
} // end EmployeeInterface