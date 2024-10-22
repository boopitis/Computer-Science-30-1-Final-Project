import java.util.*;
import java.io.*;

class Interface {

  public Scanner numScan = new Scanner(System.in);
  public Scanner wordScan = new Scanner(System.in);
  
  public Interface() {} // end Interface
  
  public void chooseTask() {} // end chooseTask

  public void viewPatients() {
    Main.ptData = Main.pViewer.sort();
    Main.pViewer.view();
  } // endViewPatients

  public void createPatient() {
    
    String id = String.valueOf(Main.numPatients + 1);
    for(int i = 0; i < 6 - String.valueOf(Main.numPatients + 1).length(); i++) {
      id = "0" + id;
    }
    System.out.println("Enter Patient's First Name: (eg. 'Stephen')");
    String fName = wordScan.nextLine();
    System.out.println("Enter Patient's Middle Names: (eg. 'Victor Lorenzana')");
    String mNames = wordScan.nextLine();
    System.out.println("Enter Patient's Last Name: (eg. 'Ravelo')");
    String lName = wordScan.nextLine();
    System.out.println("Enter Patient's Sex: (eg. 'M', 'F', or 'O')");
    String sex = wordScan.nextLine();
    System.out.println("Enter Patient's Age: (eg. '17')");
    String age = wordScan.nextLine();
    System.out.println("Enter Patient's Hair Colour: (eg. 'blk' for black)");
    String hair = wordScan.nextLine();
    System.out.println("Enter Patient's Eye Colour:c (eg. 'bro' for brown)");
    String eye = wordScan.nextLine();
    System.out.println("Enter Patient's DOB Day: (eg. '31')");
    String birthD = wordScan.nextLine();
    System.out.println("Enter Patient's DOB Month (eg. '12')");
    String birthM = wordScan.nextLine();
    System.out.println("Enter Patient's DOB Year (eg.'2004')");
    String birthY = wordScan.nextLine();
    System.out.println("Enter Patient's Height (eg. '180' in cm)");
    String ht = wordScan.nextLine();
    System.out.println("Enter Patient's Weight (eg. '70' in kg) ");
    String wt = wordScan.nextLine();

    String data = String.valueOf(id) + "," + fName + "," + mNames + "," + lName + "," + sex + "," + age + "," + hair + "," + eye + "," + birthD + "," + birthM + "," + birthY + "," + ht + "," + wt;


    int ageI = Integer.valueOf(age);
    int birthDI = Integer.valueOf(birthD);
    int birthYI = Integer.valueOf(birthY);
    int htI = Integer.valueOf(ht);
    int wtI = Integer.valueOf(wt);
    
    Main.patients.add(new Patient(id,fName,mNames,lName,sex,ageI,hair,eye,birthDI,birthM,birthYI,htI,wtI));

    try {
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Data/ptData.txt", true)));
      out.println(data);
      out.close();
    } catch (IOException e) {
      //exception handling left as an exercise for the reader
    }

  } // end createPatientProfile
  
} // end class Interface