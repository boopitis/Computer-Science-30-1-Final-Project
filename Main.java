import java.util.*;
import java.io.*;
import java.time.LocalTime;

class Main {

  public static Scanner numScan = new Scanner(System.in);
  public static Scanner wordScan = new Scanner(System.in);
  
  public static String[] ptData = Files.loadStringArr("Data/ptData.txt");
  public static ArrayList<Patient> patients = new ArrayList<Patient>();
  public static int numPatients;

  public static String[] epData = Files.loadStringArr("Data/epData.txt");
  public static ArrayList<Employee> employees = new ArrayList<Employee>();
  public static int numEmployees;

  public static String[] bData = Files.loadStringArr("Data/bData.txt");
  public static ArrayList<Boss> bosses = new ArrayList<Boss>();
  public static int numBosses;

  public static Interface BUI = new BossInterface();
  public static Interface EUI = new EmployeeInterface(epData);

  public static PViewer pViewer = new PViewer(ptData,13);
  public static EViewer eViewer = new EViewer(epData,9);

  public static Login login = new Login();
  public static boolean isBoss = false;
  public static int logged;
  
  public static boolean loop = true;

  public static LocalTime time;
  
  public static void main(String[] args) throws IOException {
    loadPt();
    loadEp();
    loadB();
    boolean looper = true;
    while(looper == true) {
      isBoss = false;
      login();
      update();
      while(loop == true) {
        update();
        if(isBoss == true) {
          BUI.chooseTask();
        } else {
          EUI.chooseTask();
        }
        lineB(40);
      } // end while
      System.out.println("Close Program? ('yes' to close)");
      String close = wordScan.nextLine();
      if(close.equalsIgnoreCase("yes")) {
        looper = false;
      }
    } // end bigger while :)
  } // end main

  public static void update() {
    ptData = Files.loadStringArr("Data/ptData.txt");
    epData = Files.loadStringArr("Data/epData.txt");
    bData = Files.loadStringArr("Data/bData.txt");
    numPatients = ptData.length/13;
    numEmployees = epData.length/9;
    numBosses = bData.length/7;
    loop = true;
  } // end update

  public static void login() {
    System.out.println("Select Who's Logging In:");
    System.out.println("1. Boss || 2. Employee (enter '1' or '2')");
    int choice = numScan.nextInt();
    boolean loopy = true;
    while(loopy == true) {
      lineB(40);
      switch(choice) {
        case 1:
          Login.log(bData,7);
          if(Login.sLogin == true) {
            isBoss = true;
            loopy = false;
            logged = Integer.valueOf(removeZero(Login.id));
          } else {
            System.out.println("Select Who's Logging In:");
            System.out.println("1. Boss || 2. Employee (enter '1' or '2')");
            choice = numScan.nextInt();
          }
          break;
        case 2:
          Login.log(epData,9);
          if(Login.sLogin == true) {
            loopy = false;
            time = LocalTime.now();
            logged = Integer.valueOf(removeZero(Login.id));
          } else {
            System.out.println("Select Who's Logging In:");
            System.out.println("1. Boss || 2. Employee (enter '1' or '2')");
            choice = numScan.nextInt();
          }
          break;
        default:
          System.out.println("Please Enter '1' or '2':");
          choice = numScan.nextInt();
          break;
      }
    }
  } // end login

  public static void loadPt() {
    for(int i = 0; i < ptData.length; i += 13) {
      int age = Integer.valueOf(ptData[i+5]);
      int birthD = Integer.valueOf(ptData[i+8]);
      int birthY = Integer.valueOf(ptData[i+10]);
      int ht = Integer.valueOf(ptData[i+11]);
      int wt = Integer.valueOf(ptData[i+12]);
      patients.add(new Patient(ptData[i],ptData[i+1],ptData[i+2],ptData[i+3],ptData[i+4],age,ptData[i+6],ptData[i+7],birthD,ptData[i+9],birthY,ht,wt));
    }
  } // end loadPt

  public static void loadEp() {
    for(int i = 0; i < epData.length; i += 9) {
      int age = Integer.valueOf(epData[i+5]);
      double money = Double.valueOf(epData[i+6]);
      double pay = Double.valueOf(epData[i+7]);
      employees.add(new Employee(epData[i],epData[i+1],epData[i+2],epData[i+3],epData[i+4],age,money,pay,epData[i+8]));
    }
  } // end loadEp

  public static void loadB() {
    for(int i = 0; i < bData.length; i += 7) {
      int age = Integer.valueOf(bData[i+5]);
      bosses.add(new Boss(epData[i],epData[i+1],epData[i+2],epData[i+3],epData[i+4],age,epData[i+8]));
    }
  } // end loadB

  public static void printArray(String[] arr, int numVar) {
    for(int i = 0; i < arr.length; i++){
      if(i%numVar == 0 && i!=0) {
        System.out.println();
      }
      if(i == arr.length-1) {
        System.out.println(arr[i] + ", ");
      } else {
        System.out.print(arr[i] + ", ");
      }
    }      
  } // end printArray

  public static void lineB(int num) {
    for(int i = 0; i < num; i++) {
      System.out.print("-");
    }
    System.out.println();
  } // end lineB

  public static String removeZero(String str) {
    int i = 0;
    while (i < str.length() && str.charAt(i) == '0')
      i++;

    StringBuffer sb = new StringBuffer(str);

    sb.replace(0, i, "");

    return sb.toString();
  } // end removeZero

} // end class Main