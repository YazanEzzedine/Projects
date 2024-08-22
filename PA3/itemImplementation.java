import javax.swing.JOptionPane;
public class itemImplementation{
final static int MAX_COMPETITOR=3;
public static void main(String[] args){
final int MAX_ITEMS = 30;
 double[] competitor_price;
  itemDefinition[] items = new itemDefinition[MAX_ITEMS];
String choice= JOptionPane.showInputDialog("*****Menu*****"+"\n"+"1. Add Item"+"\n"+"2. Remove Item" +"\n" +"3. Print Cart Subtotal" +"\n" +"4.Print Total Savings Amount"+"\n"+"5.Quit"+"\n"+"Choice: ");
 do{ 
 //used a switch case with a do while loop to go through the programs as many times as needed
  switch (choice) {
                case "1":
                 int count = itemDefinition.getNumItems();
                        System.out.println(count);
                        itemDefinition w = inputItem();
                        
                        items[count]=w;
                        
                  
                      break;
                case "2":
                removeItems(items);
                      break;
                case "3":
                print(items);
                      break;
                case "4":
                
                printSavings(items);
                      break;
                case "5":
                 System.exit(0);
                default:
                    break;
            }
    choice= JOptionPane.showInputDialog("*****Menu*****"+"\n"+"1. Add Item"+"\n"+"2. Remove Item" +"\n" +"3. Print Cart Subtotal" +"\n" +"4.Print Total Savings Amount"+"\n"+"5.Quit"+"\n"+"Choice: ");

           }while(!choice.equalsIgnoreCase("5"));                                  
}
public static itemDefinition inputItem(){
String warrantyChoice="";
int counter=0;
double competitor_prices=0;
 try{
       String itemName = JOptionPane.showInputDialog("Enter Item Name: ");
         double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Item Price: "));
         double[] competitor_price = new double[MAX_COMPETITOR];
         for(int i=0; i<3; i++){
         counter++;
         competitor_prices = Double.parseDouble(JOptionPane.showInputDialog("Enter Competitor Price "+counter+": "));
              competitor_price[i]=competitor_prices;
        }
        System.out.println(competitor_price.length);
        warrantyChoice=JOptionPane.showInputDialog("Would you like warranty on your item? Yes or no: ");
        if(warrantyChoice.equalsIgnoreCase("yes")){
          int warrantyAmount=Integer.parseInt(JOptionPane.showInputDialog("Enter warranty amount, either 12 ,24, or 36: "));
           itemWarranty w =new itemWarranty(itemName, price,competitor_price,warrantyAmount);
           return w;
          } 
          else{
          itemDefinition g= new itemDefinition(itemName, price, competitor_price);
          return g;
          }   
     }catch(IllegalArgumentException e){
      JOptionPane.showMessageDialog(null, e.getMessage());
      }
      return null;
 }  
  public static void removeItems(itemDefinition[] items) {
   String searchItem = JOptionPane.showInputDialog("Enter item name to remove: ");
      int index = search(items, searchItem);
      if(index>-1){
         items[index] = null;
        for (int i = index;i < itemDefinition.getNumItems(); i++) {
                  items[i] = items[i+1];
        }
        items[itemDefinition.getNumItems()-1] = null;
        JOptionPane.showMessageDialog(null,"Item removed!");
         itemDefinition.updateNumItems();
         }      }

public static int search(itemDefinition[] items, String searchItem ){
      int index = -1;
      for(int i = 0 ; i<itemDefinition.getNumItems();i++){
         if(searchItem.equalsIgnoreCase(items[i].getName())){
            index = i;
            break;
         }
      }
      return index;
  }
  
public static void print(itemDefinition[] items){
 String output = "";
        for(int i = 0 ; i<itemDefinition.getNumItems();i++){
            output+=items[i].toString();
        }
        JOptionPane.showMessageDialog(null, output);
}
public static void printSavings(itemDefinition[] items){
String output = "";
            for(int i = 0 ; i<itemDefinition.getNumItems();i++){
            output+=items[i].printSavingsTotal();
          }
            JOptionPane.showMessageDialog(null, output);
        }
        
}


