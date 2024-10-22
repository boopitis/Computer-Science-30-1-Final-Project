import java.util.*;

class Login {

  public static Scanner numScan = new Scanner(System.in);
  public static Scanner wordScan = new Scanner(System.in);

  public static String id;

  public static boolean sLogin = false;
  
  public Login() {} // end Login

  public static void log(String[] data, int num) {
    boolean loop = true;
    int index = 0;
    sLogin = false;
    while(loop) {
      System.out.println("Enter ID: (eg. '01' or '0001')");
      id = wordScan.nextLine();
      boolean userExists = false;
      for(int i = 0; i < data.length; i+= num) {
        if(id.equals(data[i])) {
          userExists = true;
          index = i;
          loop = false;
        }
      }
      if(userExists == false) {
        System.out.println("A user with that ID does not exist.");
      }
    }

    System.out.println("Enter Password: (eg. '1234')");
    String pass = wordScan.nextLine();
    if(pass.equals(data[index+num-1])) {
      sLogin = true;
      Main.lineB(40);
    } else {
      System.out.println("Incorrect Username or Password");
    }
  } // end log
} // end class Login