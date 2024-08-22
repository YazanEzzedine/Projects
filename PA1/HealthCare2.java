import javax.swing.JOptionPane;
public class HealthCare2{
   public static void main(String[] args){
   double totalBalance=0;
   int counter=0;
   String choice2=JOptionPane.showInputDialog("Would you like to enter a patient? Y/N: ");
  
do{
      String patientName=JOptionPane.showInputDialog("Enter patient name: ");
      String dob=JOptionPane.showInputDialog("Enter DOB: ");
      String pcpName=JOptionPane.showInputDialog("Enter PCP's name: ");
      double accBalance=Double.parseDouble(JOptionPane.showInputDialog("Enter Balance: "));
      String choice1=JOptionPane.showInputDialog("Make a payment? Y/N: ");
      healthcare1 Patient= new healthcare1(patientName, dob, pcpName, accBalance);
if(choice1.equalsIgnoreCase("Y")){
double amount=Double.parseDouble(JOptionPane.showInputDialog("Enter amount you'd like to pay: "));
Patient.paymentMethod(amount,accBalance);
totalBalance+=Patient.getAccBalance();
counter++;
JOptionPane.showMessageDialog(null,Patient.printMethod());
}
   choice2=JOptionPane.showInputDialog("Would you like to enter another patient? Y/N: ");

}while(choice2.equalsIgnoreCase("Y"));
JOptionPane.showMessageDialog(null,"The total balance for everyone is: "+totalBalance+"\n"+"The amount of patients is: "+counter);
  }
}