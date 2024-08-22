public class Library {
//variables
private String libraryName;
private String libraryAddress;
private static int totalItems;
private static int numStudy;
private String itemName;
private String ISBN;

//constructor
Library(){

}
Library(String libraryName, String libraryAddress){
setLibraryName(libraryName);
setLibraryAddress(libraryAddress);

}
//accessors
public String getLibraryName(){return this.libraryName;}
public String getLibraryAddress(){return this.libraryAddress;}
public static int getTotalItems(){return totalItems;}
public static int getNumStudy(){return numStudy;}
public String getItemName(){return this.itemName;}
public String getISBN(){return this.ISBN;}

//mutators
public void setLibraryName(String libraryName){
if(libraryName==null|| libraryName.equals(""))
   throw new IllegalArgumentException("Library Name can't be null!");
this.libraryName=libraryName;
}
public void setLibraryAddress(String libraryAddress){
if(libraryAddress==null|| libraryAddress.equals(""))
   throw new IllegalArgumentException("Library Address can't be null!");
this.libraryAddress=libraryAddress;
}


//special purpose methods
public String toString(){
return "Library Name: "+getLibraryName()+" | Library Address: "+getLibraryAddress()+"\n";
}
}