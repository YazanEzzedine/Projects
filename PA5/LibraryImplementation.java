import javax.swing.JOptionPane;
public class LibraryImplementation {
public static void main(String[] args){
final int MAX_ITEMS = 6000;
final int MAX_ROOMS=48;
Itemm[] libraryItems = new Itemm[MAX_ITEMS];
StudyRooms[] libraryRooms= new StudyRooms[MAX_ROOMS];

String libraryName=JOptionPane.showInputDialog("Enter the Library Name: ");
String libraryAddress=JOptionPane.showInputDialog("Enter the Library Address: ");
   Library library= new Library(libraryName, libraryAddress);
   String librarian="";
String choice= JOptionPane.showInputDialog("*****Menu*****"+"\n"+"1. Add Librarian"+"\n"+"2. Add Library Items" +"\n" +"3. Add Study Rooms" +"\n"
 +"4.Search Library Item"+"\n"+"5.Checkout Item"+"\n"+"6.Reserve Study Room"+"\n"+"7.Library Information"+"\n"+"8. Quit Program"+"\n"+"Choice: ");
 do{ 
  switch (choice) {
                case "1":
                int libCount=Librarian.getNumLibrarian();
                if(libCount>=1)
                     JOptionPane.showMessageDialog(null,"You already have a librarian assigned!");
                
                 Librarian lib= addLibrarian();
                 librarian=lib.toString();
                    break;
                case "2":
              String bookChoice=JOptionPane.showInputDialog("Would you like to add an item?");
                do{
              int count = Itemm.getNumItem();
               Itemm book= addItem();
                  libraryItems[count]=book;
             bookChoice=JOptionPane.showInputDialog("Would you like to add another item?");
                  }while(bookChoice.equalsIgnoreCase("yes"));
                    break;
                case "3":
               int roomCount= StudyRooms.getNumRooms();
                  StudyRooms roomObj=addRoom();
                  libraryRooms[roomCount]=roomObj;
                    break;
                case "4":
                searchItem(libraryItems);
                    break;
                case "5":
                bookCheckout(libraryItems);
                   break;
                case "6":
                  reserveRoom(libraryRooms);
                    break;
                case "7":
                  printAll(libraryItems,libraryRooms,librarian,library);
                    break;
                case "8":
                System.exit(0);
           default:
                    break;
               }     
               
  choice= JOptionPane.showInputDialog("*****Menu*****"+"\n"+"1. Add Librarian"+"\n"+"2. Add Library Items" +"\n" +"3. Add Study Rooms" +"\n"
 +"4.Search Library Item"+"\n"+"5.Checkout Book"+"\n"+"6.Reserve Study Room"+"\n"+"7.Library Information"+"\n"+"8. Quit Program"+"\n"+"Choice: ");
  }while(!choice.equalsIgnoreCase("8"));     
               

   }
   public static Librarian addLibrarian(){
    String name =JOptionPane.showInputDialog("Enter Librarian Name: ");
     String gmuID =JOptionPane.showInputDialog("Enter Librarian GmuID: ");
      String email =JOptionPane.showInputDialog("Enter librarian Email: ");
       String phone =JOptionPane.showInputDialog("Enter Librarian Phone Number: ");
       Librarian lib= new Librarian(name, gmuID, email, phone);
   return lib;
   }
   
   public static Itemm addItem(){
   try{
        String name =JOptionPane.showInputDialog("What's the name of your item?:  ");
       String ISBN =JOptionPane.showInputDialog("What's the ISBN of your item?:  ");
       String dueDate =JOptionPane.showInputDialog("When is the due date of your item? dd/mm/yy:  ");
     String type =JOptionPane.showInputDialog("Is your item a Disc or a Book?:  ");
     if(type.equalsIgnoreCase("book")){
      String author =JOptionPane.showInputDialog("Enter Book Author:  ");
      String edition =JOptionPane.showInputDialog("Enter Book Edition:  ");
      String year =JOptionPane.showInputDialog("Enter Book Year:  ");
      Bookk book= new Bookk(name, ISBN, dueDate, author, edition, year);
      return book;
     }
     else if(type.equalsIgnoreCase("disc")){
       double duration =Double.parseDouble(JOptionPane.showInputDialog("What's the duration of the DVD?:  "));
       String discType =JOptionPane.showInputDialog("What's the disc type? (Blueray, DVD, CD):  ");
       DVDD disc= new DVDD(name, ISBN, dueDate, duration, discType);
       return disc;
     }
     else{ 
     throw new IllegalArgumentException("You must enter DVD or Book");
     }
    }catch(IllegalArgumentException e){
      JOptionPane.showMessageDialog(null, e.getMessage());
      }
      return null;
   }
   public static StudyRooms addRoom(){
   int roomNumber=Integer.parseInt(JOptionPane.showInputDialog("Please enter the room number: "));
   int roomSize=Integer.parseInt(JOptionPane.showInputDialog("Please enter the amount of people the room can hold: "));
    StudyRooms roomObj= new StudyRooms(roomNumber, roomSize);
    return roomObj;
   }
   public static void searchItem(Itemm[] libraryItems){
   int index=0;
   String choice = JOptionPane.showInputDialog("Would you like to enter the item ISBN or name to search?: ");
   if(choice.equalsIgnoreCase("ISBN")){
      String searchItem = JOptionPane.showInputDialog("Enter item ISBN to recover: ");
    index = searchISBN(libraryItems, searchItem);
      }
   else if(choice.equalsIgnoreCase("name")){
       String searchItem = JOptionPane.showInputDialog("Enter item name to recover: ");
    index = searchName(libraryItems, searchItem);
   }
String output = "";
output+=libraryItems[index].toString();
JOptionPane.showMessageDialog(null, output);
        
}   
   public static int searchName(Itemm[] libraryItems, String searchItem ){
      int index = -1;
      for(int i = 0 ; i<Itemm.getNumItem();i++){
         if(searchItem.equalsIgnoreCase(libraryItems[i].getItemName())){
            index = i;
            break;
         }
      }
      return index;
  }
  public static int searchISBN(Itemm[] libraryItems, String searchItem ){
      int index = -1;
      for(int i = 0 ; i<Itemm.getNumItem();i++){
         if(searchItem.equalsIgnoreCase(libraryItems[i].getISBN())){
            index = i;
            break;
         }
      }
      return index;
  }
   public static int searchRoom(StudyRooms[] libraryRooms, int roomSize ){
      int index = -1;
      for(int i = 0 ; i<StudyRooms.getNumRooms();i++){
         if(roomSize==(libraryRooms[i].getParticipantSize())){
            index = i;
            break;
         }
      }
      return index;
  }

  public static void bookCheckout(Itemm[] libraryItems){
  String searchItem= JOptionPane.showInputDialog("What's the name of the item you would like to checkout?");
    int index = searchName(libraryItems, searchItem);
     if (index==-1){
    JOptionPane.showMessageDialog(null,"Item not found.");
    }
     if(index>-1){
         libraryItems[index] = null;
        for (int i = index;i < Itemm.getNumItem(); i++) {
                  libraryItems[i] = libraryItems[i+1];
        }
        libraryItems[Itemm.getNumItem()-1] = null;
        JOptionPane.showMessageDialog(null,"Book has been checked out!");
         Itemm.updateNumItems();

  }
}
   public static void reserveRoom(StudyRooms[] libraryRooms){
     int roomSize= Integer.parseInt(JOptionPane.showInputDialog("Please enter the amount of participants for your room: "));
      int index = searchRoom(libraryRooms, roomSize);
    if (index==-1){
    JOptionPane.showMessageDialog(null,"Room with that size not found.");
    }
    else{
      String output = "";
output+=libraryRooms[index].toString();
String choice=JOptionPane.showInputDialog(null,"Available Room: "+ output+"\n would you like to check out this room? yes/no: ");
if(choice.equalsIgnoreCase("yes")){
if(index>-1){
         libraryRooms[index] = null;
        for (int i = index;i < StudyRooms.getNumRooms(); i++) {
                  libraryRooms[i] = libraryRooms[i+1];
        }
        libraryRooms[StudyRooms.getNumRooms()-1] = null;
        JOptionPane.showMessageDialog(null,"Room has been reserved!");
         StudyRooms.updateRoomAvail();

  }
}
else{
JOptionPane.showMessageDialog(null,"Please choose another option.");
}
   }
   }
   public static void printAll(Itemm[] libraryItems,StudyRooms[] libraryRooms, String librarian,Library library ){
   String output = "";
            output+="***Library*** \n";
            output+=library.toString();
            output+="***Librarian*** \n";
            output+=librarian;
            output+="***Items*** \n";
            for(int i = 0 ; i<Itemm.getNumItem();i++){
            output+=libraryItems[i].toString();
          }
            output+="***Study Rooms*** \n";
           for(int i = 0 ; i<StudyRooms.getNumRooms();i++){
            output+=libraryRooms[i].toString();
          }
          
            JOptionPane.showMessageDialog(null, output);
        }

   }
