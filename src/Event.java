import java.time.LocalDateTime;

public abstract class Event implements Comparable<Event> {



     public String name;  // Name of the event.
     public LocalDateTime dateTime; // the time and date the event starts.

    public Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }
    // abstract method that returns the name
     abstract String getName();

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

    // compares the date of this Event to the incoming event and returns a positive int if this event comes later,
    // a negative int if this event comes before, and 0 if the two have the same dateTime.
   // @Override
    public int compareTo(Event e){

        return this.dateTime.compareTo(e.getDateTime());

    }


}
