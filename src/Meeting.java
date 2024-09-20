import java.time.Duration;
import java.time.LocalDateTime;


public class Meeting extends Event{
    LocalDateTime endDateTime;   // the time the meeting is over.
    String location; // represents the location of the event.
    boolean complete;

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
    int getDuration() {

        Duration.between(getDateTime(), getEndTime());
        return 0;

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

}
