import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EventListPanel extends JPanel {
    private ArrayList<Event> events;
    private JPanel displayPanel;

    public EventListPanel() {
        events = new ArrayList<>();
        setLayout(new BorderLayout());
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        add( new JScrollPane(displayPanel), BorderLayout.CENTER);

    }

    public void addEvent(Event e) {
        events.add(e);
        displayPanel.add(new EventPanel(e));
        displayPanel.revalidate();
        displayPanel.repaint();
    }




}
