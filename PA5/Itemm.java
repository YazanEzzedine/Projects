public class Itemm extends Library{
//variables
private String itemName;
private String ISBN;
private static int numCopies;
private static int numAvailCopies;
private String dueDate;
private static int numItem;
//constructor
Itemm(String itemName, String ISBN, String dueDate){
setItemName(itemName);
setISBN(ISBN);
setDueDate(dueDate);
numItem++;
}
//accessor
public String getItemName(){return this.itemName;}
public String getISBN(){return this.ISBN;}
public static int getNumCopies(){return numCopies;}
public static int getNumAvailCopies(){return numAvailCopies;}
public String getDueDate(){return this.dueDate;}
public static int getNumItem(){return numItem;}

//Mutator
public void setItemName(String itemName){
if(itemName==null|| itemName.equals(""))
   throw new IllegalArgumentException("Item name cannot be left blank!");
this.itemName=itemName;
}
public void setISBN(String ISBN){
if(ISBN==null||ISBN.equals(""))
   throw new IllegalArgumentException("ISBN cannot be empty!");
this.ISBN=ISBN;
}

public void setDueDate(String dueDate){
if(dueDate.length()==8)
   this.dueDate=dueDate;
else throw new IllegalArgumentException("Year must be 8 digits in 01/15/21 format!");

}


//special purpose
public String toString(){
return "Item Name: "+getItemName()+" ISBN: " +getISBN()+ " Due Date: " + getDueDate()+"\n";
}
public static void updateNumItems(){
         numItem--;
    }

}