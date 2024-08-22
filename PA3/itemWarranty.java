public class itemWarranty extends itemDefinition{
private int warranty;
public itemWarranty(String name, double price,double[] competitorPrices, int warranty){
super(name,price,competitorPrices);
setWarranty(warranty);
}
//get method
public int getWarrantyTime(){return this.warranty;}
public double getPrice(){return super.getPrice()+(warranty*4);}
//set method
public void setWarranty(int warranty){
if(warranty==12 || warranty ==24||warranty ==36)
            this.warranty=warranty;
 else
   throw new IllegalArgumentException("Warranty must be either 12, 24, or 36 ");
}




}