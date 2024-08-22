public class DVDD extends Itemm {
//variables
private double duration;
private String type;
//constructors
DVDD(String name, String ISBN, String dueDate, double duration, String type){
super(name, ISBN, dueDate);
setDuration(duration);
setType(type);
}

//accessors
public double getDuration(){return this.duration;}
public String getType(){return this.type;}

//mutators
public void setDuration(double duration){
if(duration<0)
    throw new IllegalArgumentException("Duration must be greater than 0!");
this.duration=duration;

}
public void setType(String type){
if(type.equalsIgnoreCase("blueray")||type.equalsIgnoreCase("dvd")||type.equalsIgnoreCase("cd"))
   this.type=type;
else throw new IllegalArgumentException("Disc must either be blueray, dvd, or cd! ");
}

//special purpose
public String toString(){
return "Disc Name: "+super.getItemName()+" Disc ISBN: "+super.getISBN()+"\n Due Date: "+super.getDueDate()+"\n Duration: "+getDuration()+"\n Type: "+getType()+"\n";
}
}