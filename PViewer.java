import java.util.*;

class PViewer extends Viewer{

  public String[] arr;

  public Scanner numScan = new Scanner(System.in);
  public Scanner wordScan = new Scanner(System.in);

  public PViewer(String[] arr, int terms) {
    super(arr, terms);
    this.arr = arr;
  } // end PViewer

  public void view() {
    System.out.printf("%-7s|%-12s|%-20s|%-12s|%-4s|%-4s|%-9s|%-8s|%-12s|%-11s|%-11s%n","ID","First Name","Middle Names","Last Name","Sex","Age","Hair Clr","Eye Clr","Birthday","Height (cm)","Weight (kg)");
    lineB(122);
    for(int i = 0;i < arr.length; i += 13) {
      System.out.printf("%-7s|%-12s|%-20s|%-12s|%-4s|%-4s|%-9s|%-8s|%-12s|%-11s|%-11s%n",arr[i],arr[i+1],arr[i+2],arr[i+3],arr[i+4],arr[i+5],arr[i+6],arr[i+7],arr[i+8]+"/"+arr[i+9]+"/"+arr[i+10],arr[i+11],arr[i+12]);
    }
  } // end view

  public String[] sort() {
    
    System.out.println("Choose Sort Term: (eg. '1')");
    String[] terms = {"ID","First Name","Middle Names","Last Name","Sex","Age","Hair Clr","Eye Clr","Birthday","Height","Weight"};
    int counter = 1;
    for(String t: terms) {
      System.out.println(counter + ". " + t);
      counter++;
    }
    int choice = numScan.nextInt();
    Main.lineB(40);

    boolean loop = true;
    while(loop)
    switch(choice) {
      case 1:
        return bSortI(0);
      case 2:
        return bSortS(1);
      case 3:
        return bSortS(2);
      case 4:
        return bSortS(3);
      case 5:
        return bSortS(4);
      case 6:
        return bSortI(5);
      case 7:
        return bSortS(6);
      case 8:
        return bSortS(7);
      case 9:
        return bSortBirthday();
      case 10:
        return bSortI(11);
      case 11:
        return bSortI(12);
      default:
        loop = false;
        break;
    }
    return arr;
  } // end sort

  public String[] bSortBirthday() {
    boolean fixed = false;
    while(fixed == false) {
      fixed = true;
      for(int i = 0; i < arr.length - 13; i+=13) {
        int year1 = Integer.valueOf(arr[i+10]);
        int year2 = Integer.valueOf(arr[i+13+10]);
        int month1 = assignMonthNum(arr[i+9]);
        int month2 = assignMonthNum(arr[i+13+9]);
        int day1 = Integer.valueOf(arr[i+8]);
        int day2 = Integer.valueOf(arr[i+13+8]);
        if(year1 > year2) {
          for(int q = 0; q < 13; q++) {
            swap(arr, i+q, i+13+q);
          }
          fixed = false;
        } else if(month1 > month2 && year1 == year2) {
          for(int q = 0; q < 13; q++) {
            swap(arr, i+q, i+13+q);
          }
          fixed = false;
        } else if(day1 > day2 && month1 == month2) {
          for(int q = 0; q < 13; q++) {
            swap(arr, i+q, i+13+q);
          }
          fixed = false;
        }
      }
    } // end while
    return arr;
  } // end bSortBirthday

  public int assignMonthNum(String month) {
    switch(month) {
      case "JAN":
        return 1;
      case "FEB":
        return 2;
      case "MAR":
        return 3;
      case "APR":
        return 4;
      case "MAY":
        return 5;
      case "JUN":
        return 6;
      case "JUL":
        return 7;
      case "AUG":
        return 8;
      case "SEP":
        return 9;
      case "OCT":
        return 10;
      case "NOV":
        return 11;
      case "DEC":
        return 12;
      default:
        return 13;
    }
  } // end assignMonthNum
  
} // end class PViewer