import javax.swing.JOptionPane;
public class Bookk extends Itemm {
//variables
private String author;
private String edition;
private String year;
//Constructor
Bookk(String name, String ISBN, String dueDate, String author, String edition, String year){
super(name,ISBN,dueDate);
setAuthor(author);
setEdition(edition);
setYear(year);
}
//Accessors
public String getAuthor(){return this.author;}
public String getEdition(){return this.edition;}
public String getYear(){return this.year;}


//mutators
public void setAuthor(String author){
if(author==null||author.equals(""))
    throw new IllegalArgumentException("Author can't be left blank!");
this.author=author;
}
public void setEdition(String edition){
if(edition==null||edition.equals(""))
    throw new IllegalArgumentException("Edition can't be left blank!");
this.edition=edition;
}
public void setYear(String year){
if(year.length()==4)
   this.year=year;
else
   throw new IllegalArgumentException("Year must be 4 numbers!");
   
}
//SpecialPurpose
public String toString(){
return "Name: "+super.getItemName()+"\n Book ISBN: "+super.getISBN()+"\n Due Date: "+super.getDueDate()+"\n Author Name: "+getAuthor()+"\n Edition: "+ getEdition()+ "\n Year: "+getYear()+"\n";
}
}