import javax.swing.JOptionPane;
public class gameImplemenation{
 public static void main(String[] args){
  final int MAX_GAMES = 10;
  gameDefinition[] games = new gameDefinition[MAX_GAMES];
  String choice= JOptionPane.showInputDialog("***GMU patriot games***"+"\n"+"1.Create Game"+"\n"+"2.Remove Game"+"\n"+"3.Sell Game Ticket"+"\n"+"4.Display Games"+"\n"+"5.Exit Game");
 do{ 
 //used a switch case with a do while loop to go through the programs as many times as needed
  switch (choice) {
                case "1":
                    
                                       //I have made changes here for count how you are calling input function and how you are assigning please check
                        int count = gameDefinition.getNumGames();
                        System.out.println(count);
                        gameDefinition g = inputGame();
                        games[count]=g;
                        System.out.println(g.getID());
                        break;
               case "2":
                     printList(games);
                  removeGames(games);
                    break;
                case "3":
                   sellTickets(games);
                    break;
                case "4":
                    printList(games);
                    break;
                case "5":
                      printList(games);
                    System.exit(0);
                default:
                    break;
            }
       choice= JOptionPane.showInputDialog("***GMU patriot games***"+"\n"+"1.Create Game"+"\n"+"2.Remove Game"+"\n"+"3.Sell Game Ticket"+"\n"+"4.Display Games"+"\n"+"5.Exit Game");
           }while(!choice.equalsIgnoreCase("5"));
 }
//method to create the games
 public static gameDefinition inputGame() {
   try{
       String ID = JOptionPane.showInputDialog("Enter ID: ");
         String teamName = JOptionPane.showInputDialog("Enter team name: ");
          String date = JOptionPane.showInputDialog("Enter date: ");
          //creates the object and returns g to put into the array.
         gameDefinition g =new gameDefinition(ID, teamName, date);
         return g;
     }catch(IllegalArgumentException e){
      JOptionPane.showMessageDialog(null, e.getMessage());
      }
      return null;
 }  
 //remove games method
   public static void removeGames(gameDefinition[] games) {
   String searchGame = JOptionPane.showInputDialog("Enter game id: ");
      int index = search(games, searchGame);
      if(index>-1){
         games[index] = null;
        for (int i = index;i < gameDefinition.getNumGames(); i++) {
                  games[i] = games[i+1];
        }
        games[gameDefinition.getNumGames()-1] = null;
        JOptionPane.showMessageDialog(null,"Game removed!");
         gameDefinition.updateNumDVD();
         }      }
         //method to sell each ticket
 public static void sellTickets(gameDefinition[] games) {
      String searchGame = JOptionPane.showInputDialog("Enter game id: ");
       int index = search(games, searchGame);
       if(index>-1){
       String choice=JOptionPane.showInputDialog("Would you like to buy a premium ticket, or a general ticket?:  ");
       if(choice.equalsIgnoreCase("premium")){
       //adds the ticket to the array using the get and set methods
      games[index].setPremiumAdmission(games[index].getPremiumAdmission() + 1);
       
       }
       else if(choice.equalsIgnoreCase("general")){
      games[index].setgeneralAdmission(games[index].getGeneralAdmission() + 1);
       }
       else
         JOptionPane.showMessageDialog(null,"You have to enter either premium, or general.");
      
            
       } 
       else
         JOptionPane.showMessageDialog(null,"id not found.");
  } 
  //method to search the array
  public static int search(gameDefinition[] games, String searchGame ){
      int index = -1;
      for(int i = 0 ; i<gameDefinition.getNumGames();i++){
         if(searchGame.equalsIgnoreCase(games[i].getID())){
            index = i;
            break;
         }
      }
      return index;
  }
  //method to print the array contents
  public static void printList(gameDefinition[] games){
        String output = "";
        for(int i = 0 ; i<gameDefinition.getNumGames();i++){
            output+=games[i].toString();
        }
        JOptionPane.showMessageDialog(null, output);
  }
}
   
