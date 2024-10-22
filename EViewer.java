import java.util.*;

class EViewer extends Viewer{

  public String[] arr;

  public Scanner numScan = new Scanner(System.in);
  public Scanner wordScan = new Scanner(System.in);

  public EViewer(String[] arr, int terms) {
    super(arr, terms);
    this.arr = arr;
  } // end EViewer

  public void view() {
    System.out.printf("%-7s|%-12s|%-20s|%-12s|%-4s|%-4s|%-9s|%-9s%n","ID","First Name","Middle Names","Last Name","Sex","Age","Money ($)","Pay ($/h)");
    lineB(85);
    for(int i = 0;i < arr.length; i += 9) {
    System.out.printf("%-7s|%-12s|%-20s|%-12s|%-4s|%-4s|%-9s|%-9s%n",arr[i],arr[i+1],arr[i+2],arr[i+3],arr[i+4],arr[i+5],arr[i+6],arr[i+7]);
    }
  } // end view

  public String[] sort() {
    
    System.out.println("Choose Sort Term: (eg. '1')");
    String[] terms = {"ID","First Name","Middle Names","Last Name","Sex","Age","Money","Pay"};
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
        return bSortI(6);
      case 8:
        return bSortI(7);
      default:
        loop = false;
        break;
    }
    return arr;
  } // end sort
  
} // end class EViewer