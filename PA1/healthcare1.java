import javax.swing.JOptionPane;
public class healthcare1{
    private String patientName; 
    private String dob;
    private String pcpName;
    private double accBalance;
    private double amount;
  //constructors 
   healthcare1(){
   this.patientName="";
   this.dob="";
   this.pcpName="";
   this.accBalance=0.0;
    }
  //special constructor
   healthcare1(String patientName, String dob, String pcpName, double accBalance){
      setPatientName(patientName);
      setDOB(dob);
      setPcpName(pcpName);
      setAccBalance(accBalance);
   }
    //accessors
    public String getPatientName(){
      return this.patientName;
   }
   public String getDOB(){
      return this.dob;
   }
   public String getPcpName(){
      return this.pcpName;
   }
   public double getAccBalance(){
      return this.accBalance;
   }
   public double getAmount(){
   return this.amount;
   }
//mutators
public void setPatientName(String patientName){
 if(patientName.equals("")||patientName==null)
      throw new IllegalArgumentException("Error! Name can not be blank");
    this.patientName=patientName;
}
public void setDOB(String dob){
 if(dob.equals("")||dob==null)
      throw new IllegalArgumentException("Error! Date of birth can not be blank");
    this.dob=dob;
}
public void setPcpName(String pcpName){
 if(pcpName.equals("")||pcpName==null)
      throw new IllegalArgumentException("Error! Name can not be blank");
    this.pcpName=pcpName;
}
public void setAccBalance(double accBalance){
if(accBalance<0){
   throw new IllegalArgumentException("Error! Balance can not be blank or less than 0");
}
 this.accBalance=accBalance;
}
public void setAmount(double amount){
if(amount<0){
   throw new IllegalArgumentException("Error! amount cant be blank or less than 0");
}
 this.amount=amount;
}
//special purpose method to subtract the amount from the balance
public void paymentMethod(double amount, double accBalance){
          
       if (accBalance<amount){
       throw new IllegalArgumentException("Payment needs to be less than the acc balance");
       }
       else{
       this.accBalance-=amount;
       }
      }
      //my print method that is refrenced in the main to print everything
       public String printMethod(){
      return "Patient Name: "+getPatientName()+" Patient DOB: "+getDOB()+" Your PCP's name is: "+getPcpName()+" Your account balance is: "+getAccBalance();
}

}

