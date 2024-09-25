import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class EventPlanner  {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Event Planner");
        EventListPanel eventListPanel = new EventListPanel();

        addDefaultEvents(eventListPanel);
        frame.add(eventListPanel);

        // Close operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(3);
        Dimension size = new Dimension(500, 500);

        frame.setPreferredSize(size);


        // COLOR
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        frame.pack();
        frame.setVisible(true);


    }


    static void addDefaultEvents(EventListPanel eventListPanel) {

        eventListPanel.addEvent(new Deadline("Lab2 is Due", LocalDateTime.now()));
        eventListPanel.addEvent(new Meeting("Monday Meeting", LocalDateTime.now(), LocalDateTime.now().plusHours(2), "Virtual"));



    }






}
