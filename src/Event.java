import java.time.LocalDateTime;

public abstract class Event {

    //implements Comparable<Event>;

     String name;  // Name of the event.
     LocalDateTime dateTime; // the time and date the event starts.

    // abstract method that returns the name
    String getName(){
        return name;
    }
    // method that returns the dateTime.
    LocalDateTime getDateTime(){
       return dateTime;
    }
    //sets the dateTime.
    void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }
    // sets the name of the Event.
    void setName(String name) {
        this.name = name;
    }
   // compareTo(Event e): int  // compares the date of this Event to the incoming event and returns a positive int if this event comes later, a negative int if this event comes before, and 0 if the two have the same dateTime.


}
