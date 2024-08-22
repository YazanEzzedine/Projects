public class itemDefinition{
//variables
private String name;
private double price;
private double savings;
private static int MAX_COMPETITOR_PRICES=3;
private static int numCompetitors;
private double [] competitorPrices=new double[3];
private double competitorPrice;
private static int numItems;
private double subtotal=0;
private double combinedTotal=0;
private double savingsTotal;
private double savingAmount;
//Constructor
itemDefinition(String name, double price, double [] competitorPrices){
setName(name);
System.out.println(competitorPrices.length);
setPrice(price);
//this.competitorPrices=new double[MAX_COMPETITOR_PRICES];
setCompetitorPrices(competitorPrices);
numCompetitors++;
numItems=numItems+1;
}
itemDefinition(String name, double price){
setName(name);
setPrice(price);
}
//get method
public String getName(){return this.name;}
public static int getNumCompetitors(){return numCompetitors;}
public static int getNumItems(){return numItems;}
public double getCompetitorPrice(){return this.competitorPrice;}
public int getWarrantyTime(){return 0;}
public double getPrice(){return this.price;}



public double[] getCompetitorPrices(){
return this.competitorPrices;
}
 public static void updateNumItems(){
         numItems--;
    }

//set method
public void setName(String name){
if (name.length()>=5){
      for(int i=0; name.length()<i; i++){
      if(Character.isLetter(name.charAt(i)))
          this.name=name;
      else
          throw new IllegalArgumentException("Name must consist of letters: ");
      }
   }
  else{
    throw new IllegalArgumentException("Name must be at least 5 characters long: ");
    }
    this.name=name;
}
public void setPrice(double price){
if (price>0)
   this.price=price;
else
   throw new IllegalArgumentException("Price must bet greater than 0: ");
}
public void setCompetitorPrices(double[] competitorPrices){
System.out.println(competitorPrices.length);
/*if(this.numCompetitors> MAX_COMPETITOR_PRICES)
throw new IllegalArgumentException("The limit on competitors has been reached ");
for(int i=0; i<3; i++){
if(competitorPrices[i]<0)
   throw new IllegalArgumentException("Price must be greater than 0: ");
}*/
this.competitorPrices=competitorPrices;

}
//Special purpose method
public String toString(){
   String output= "***Shopping Cart***"+"\n Number of Items In Cart: "+this.getNumItems()+"\n Combined Subtotal: "+this.getCombinedTotal()+
   "\n -----------------------"+"\n Item Name | Price |Subtotal| Competitor 1| Competitor 2 | Competitor 3 |  "+"\n"+this.getName()+" | "
   + this.getPrice()+" | "+this.getSubtotal();
   double[] competitorPrices=getCompetitorPrices();
   System.out.println(competitorPrices.length);
   for(int i=0; i<3; i++){
   output=output+" | "+competitorPrices[i];
   }
   return output;
}
public double getCombinedTotal( ){

return this.combinedTotal+= this.getSubtotal();
}
public double getSubtotal(){
double smallest = competitorPrices[0];
for(int i=0; i<3; i++){
  if(competitorPrices[i] < smallest)
      smallest=competitorPrices[i];
     }
     if(smallest>price)
      subtotal=price;
     else
      subtotal=smallest;
return this.subtotal;
}
public double getSavingAmount(){
double smallest = competitorPrices[0];
for(int i=0; i<3; i++){
  if(competitorPrices[i] < smallest)
      smallest=competitorPrices[i];
     }
     if(smallest>price)
      subtotal=price;
     else
      subtotal=smallest;
savingAmount=price-smallest;
System.out.println(savingAmount);
return this.savingAmount;
}
public double getSavingsTotal(){
savingsTotal+=this.getSavingAmount();
System.out.println(this.getSavingAmount());
System.out.println(savingsTotal);
return this.savingsTotal;

}
public String printSavingsTotal(){
return "Total Savings: "+ this.getSavingsTotal()+" Amount of money saved on item: "+this.getSavingAmount();
}

}