public class Deadline extends Event {

    boolean complete;  // holds a Boolean representing whether the task this deadline tracks is complete.

    // sets the complete boolean to true;
    void complete(){
        complete = true;
    }

    // returns the complete boolean.
    boolean isComplete() {
        return complete;
    }

}
