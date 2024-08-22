public class Librarian extends Library {
//variables
private String librarianName;
private String gmuID;
private String librarianEmail;
private String librarianPhone;
private static int numLibrarian=0;
//constructor


Librarian(String librarianName, String gmuID, String librarianEmail, String librarianPhone){
setLibrarianName(librarianName);
setGmuID(gmuID);
setLibrarianEmail(librarianEmail);
setLibrarianPhone(librarianPhone);
numLibrarian++;
}
//accessors
public String getLibrarianName(){return this.librarianName;}
public String getGmuID(){return this.gmuID;}
public String getLibrarianEmail(){return this.librarianEmail;}
public String getLibrarianPhone(){return this.librarianPhone;}
public static int getNumLibrarian(){return numLibrarian;}

//mutators
public void setLibrarianName(String librarianName){

this.librarianName=librarianName;
}
public void setGmuID(String gmuID){
if(gmuID.length()==9){
      if ((gmuID.charAt(0)=='G')||(gmuID.charAt(0)=='g')){
         if(Character.isDigit(gmuID.charAt(1))&&Character.isDigit(gmuID.charAt(2))&&Character.isDigit(gmuID.charAt(3))&&Character.isDigit(gmuID.charAt(4))&&Character.isDigit(gmuID.charAt(5))
         &&Character.isDigit(gmuID.charAt(6))&&Character.isDigit(gmuID.charAt(7))){
            this.gmuID=gmuID;
         }else throw new IllegalArgumentException("GmuID must end with 7 digits!");
      }else throw new IllegalArgumentException("GmuID must start with the letter G");
   }else throw new IllegalArgumentException("GmuID length must be 9!");
this.gmuID=gmuID;
}
public void setLibrarianEmail(String librarianEmail){
int atIndex=librarianEmail.indexOf("@");
if(atIndex>=4 && atIndex<=8){
   if((librarianEmail.charAt(atIndex+1)=='g')&&(librarianEmail.charAt(atIndex+2)=='m')&&(librarianEmail.charAt(atIndex+3)=='u')&&(librarianEmail.charAt(atIndex+4)=='.')&&(librarianEmail.charAt(atIndex+5)=='e')&&(librarianEmail.charAt(atIndex+6)=='d')&&(librarianEmail.charAt(atIndex+7)=='u')){
         this.librarianEmail=librarianEmail;
       }else throw new IllegalArgumentException("Your email must end in @gmu.edu");
 }else throw new IllegalArgumentException("Your email before the @ must be greater than 4 and less than 8");
this.librarianEmail=librarianEmail;

}
public void setLibrarianPhone(String librarianPhone){
if(librarianPhone.length()==10)
   this.librarianPhone=librarianPhone;
else throw new IllegalArgumentException("Phone number must be exactly 10 digits");
}

//special purpose
public String toString(){
return "Librarian Name: "+getLibrarianName()+" | GMU ID: "+getGmuID()+"\n Librarian Email: "+getLibrarianEmail()+"\n Librarian Phone-Number: "+getLibrarianPhone()+"\n";
}
}