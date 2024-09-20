import java.time.LocalDateTime;

public class Deadline extends Event implements Completable {

    private boolean complete;  // holds a Boolean representing whether the task this deadline tracks is complete.


    public Deadline(String name, LocalDateTime deadline) {
        super(name, deadline);
        this.complete = false;
    }

    // sets the complete boolean to true;
    public void complete(){
        complete = true;
    }

    // returns the complete boolean.
    public boolean isComplete() {
        return complete;
    }


    @Override
    public String getName() {
        return super.name;
    }
}
