class Viewer {

  String[] arr;
  int terms;

  public Viewer(String[] arr, int terms) {
    this.arr = arr;
    this.terms = terms;
  } // end Viewer

  public String[] bSortI(int offset) {
    boolean fixed = false;
    while(fixed == false) {
      fixed = true;
      for(int i = 0; i < arr.length - terms; i+=terms) {
        int num1 = Integer.valueOf(arr[i+offset]);
        int num2 = Integer.valueOf(arr[i+terms+offset]);
        if(num1 > num2) {
          for(int q = 0; q < terms; q++) {
            swap(arr, i+q, i+terms+q);
          }
          fixed = false;
        }
      }
    } // end while
    return arr;
  } // end bSortI

  public String[] bSortS(int offset) {
    boolean fixed = false;
    while(fixed == false) {
      fixed = true;
      for(int i = 0; i < arr.length - terms; i+=terms) {
        if(arr[i+offset].compareToIgnoreCase(arr[i+terms+offset]) > 0) {
          for(int q = 0; q < terms; q++) {
            swap(arr, i+q, i+terms+q);
          }
          fixed = false;
        }
      }
    } // end while
    return arr;
  } // end bSortS

  public void swap(int[] array, int indexOne, int indexTwo) {
    int save = array[indexOne];
    array[indexOne] = array[indexTwo];
    array[indexTwo] = save;
  } // end swap

  public void swap(String[] array, int indexOne, int indexTwo) {
    String save = array[indexOne];
    array[indexOne] = array[indexTwo];
    array[indexTwo] = save;
  } // end swap

  public void lineB(int num) {
    for(int i = 0; i < num; i++) {
      System.out.print("-");
    }
    System.out.println();
  } // end lineB
  
} // end class Viewer