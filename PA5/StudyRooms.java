public class StudyRooms extends Library {
//variables
private int roomNumber;
private int participantSize;
private static int numRooms;
//constructor
StudyRooms(int roomNumber, int participantSize){
setRoomNumber(roomNumber);
setParticipantSize(participantSize);
numRooms++;
}

//accessors
public int getRoomNumber(){return this.roomNumber;}
public int getParticipantSize(){return this.participantSize;}
public static int getNumRooms(){return numRooms;}


//mutators
public void setRoomNumber(int roomNumber){
if(roomNumber<0)
   throw new IllegalArgumentException("Room number cannot be less than 0!");
this.roomNumber=roomNumber;
}
public void setParticipantSize(int participantSize){
if(participantSize<0)
   throw new IllegalArgumentException("Participant Size cannot be less than 0!");
this.participantSize=participantSize;
}

//special purpose
public String toString(){
return "Room Number: "+getRoomNumber()+" Participant Size: "+getParticipantSize()+"\n";
}
public static void updateRoomAvail(){
         numRooms--;
    }
}