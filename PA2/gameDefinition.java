import javax.swing.JOptionPane;
public class gameDefinition{
private String ID;
private int premiumAdmission;
private int generalAdmission;
private String teamName;
private String date;
private int totalCost;
private static int numGames=0;
//constructors
gameDefinition(){

}
    gameDefinition(int generalAdmission, int premiumAdmission){
      this.premiumAdmission = 0;
       this.generalAdmission = 0;
    }  
    gameDefinition(String ID, String teamName,String date) {
      setID(ID);
      setTeamName(teamName);
      setDate(date);
       numGames++;      
   }
   //accessors
   public String getID() { return this.ID; }
   public int getPremiumAdmission() { return this.premiumAdmission; }
   public int getGeneralAdmission() { return this.generalAdmission; }
   public String getTeamName() { return this.teamName; }
   public String getDate() { return this.date; }
   public int getTotalCost() { return this.totalCost; }
   public static int getNumGames() { return numGames; }
   public static void updateNumDVD(){
         numGames--;
    }
   
   //mutators
   public void setID(String ID){
   if(ID.length()==6){
      if (Character.isLetter(ID.charAt(0)) && Character.isLetter(ID.charAt(1))){
         if(Character.isDigit(ID.charAt(2))&&Character.isDigit(ID.charAt(3))&&Character.isDigit(ID.charAt(4))&&Character.isDigit(ID.charAt(5))){
            this.ID=ID;
         }else throw new IllegalArgumentException("ID must end with 4 digits!");
      }else throw new IllegalArgumentException("ID must start with two letters!");
   }else throw new IllegalArgumentException("ID length must be 6!");
      
   
   }
    public void setPremiumAdmission(int premiumAdmission){
    if(premiumAdmission>25)
       throw new IllegalArgumentException("Value exceeds amount of premium tickets");
    else
       this.premiumAdmission=premiumAdmission;
   }
    public void setgeneralAdmission(int generalAdmission){
       if(premiumAdmission>75)
       throw new IllegalArgumentException("Value exceeds amount of general tickets");
    else
      this.generalAdmission=generalAdmission;
   }
    public void setTeamName(String teamName){
    if(teamName.equals("")||teamName==null)
      throw new IllegalArgumentException("Team name can not be blank!");
   this.teamName=teamName;
   }
    public void setDate(String date){
    if(date.equals("")||date==null)
      throw new IllegalArgumentException("Date can not be blank!");
   this.date=date;
   }
    public void setTotalCost(int totalCost){
   this.totalCost=totalCost;
   }
   //special purpose
   public String toString(){
   return "GameID: "+this.getID()+"\n Premium Admission Tickets : "+this.getPremiumAdmission()+"\n General Admission Tickets: "+this.getGeneralAdmission()+"\n Team Name: "+this.getTeamName()+"\n Date: "+this.getDate()+"\n Total Cost: "+this.getTotalCost()+"\n";
   }
   
   public int getTotal(){
  return this.totalCost+=(getPremiumAdmission() * 25)+(getGeneralAdmission() * 25);
}
   public static void createGame(){
    int count = getNumGames();
        if(count>10){
            JOptionPane.showMessageDialog(null, "Maximum number of games reached.");
        }
   }
}