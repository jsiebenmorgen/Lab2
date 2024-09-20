import java.time.Duration;
import java.time.LocalDateTime;


public class Meeting extends Event{
   private LocalDateTime endDateTime;   // the time the meeting is over.
   private String location; // represents the location of the event.
   private boolean complete;

    public Meeting(String name, LocalDateTime start, LocalDateTime end, String location) {
        super(name, start);
        this.endDateTime = end;
        this.location = location;
        this.complete = false;
    }

    // sets the complete boolean to true;
    void complete(){
        complete = true;
    }

    // returns the complete boolean.
    boolean isComplete(){
        return complete;
    }

    // returns the endDateTime
    LocalDateTime getEndTime(){
        return endDateTime;
    }
    // returns the duration of the meeting, (dateTime – endDateTime)
    Duration getDuration() {


        return  Duration.between(getDateTime(), getEndTime());

    }

    // returns the location of the meeting.
    String getLocation(){
        return location;
    }

    // sets the end of the meeting.
    void setEndTime(LocalDateTime end) {
        endDateTime = end;
    }

    // sets the location of the meeting.
    void setLocation(String location) {
        this.location = location;
    }

    @Override
    String getName() {
        return super.name;
    }



    public Object getEndDateTime() {
        return endDateTime;
    }
}
