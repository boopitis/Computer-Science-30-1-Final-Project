class Boss extends Person {

  public String password; 
  
  public Boss(String id,String fName, String mNames, String lName, String sex, int age, String password) {
    super(id, fName, mNames, lName, sex, age);
    this.password = password;
  } // end Boss
} // end class Boss