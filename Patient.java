class Patient extends Person {

  public String hair;
  public String eyes;
  public int birthD;
  public String birthM;
  public int birthY;
  public int ht;
  public int wt;
  
  public Patient(String id, String fName, String mNames, String lName, String sex, int age, String hair, String eyes, int birthD, String birthM, int birthY, int ht, int wt) {
  super(id, fName, mNames, lName, sex, age);
  this.hair = hair;
  this.eyes = eyes;
  this.birthD = birthD;
  this.birthM = birthM;
  this.birthY = birthY;
  this.ht = ht;
  this.wt = wt;
  } // end Patient
} // end class Patient