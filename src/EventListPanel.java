import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EventListPanel extends JPanel {

    private ArrayList<Event> events;
    private JPanel displayPanel;
    private JButton addEventButton;



    public EventListPanel() {
        events = new ArrayList<>();
        setLayout(new BorderLayout());
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(displayPanel), BorderLayout.CENTER);

        addEventButton = new JButton("Add Event");
        addEventButton.addActionListener(e -> openAddEventModal());
        add(addEventButton, BorderLayout.SOUTH);

    }

    private void openAddEventModal(){
        AddEventModal addEventModal = new AddEventModal((Frame) SwingUtilities.getWindowAncestor(this), this);
        addEventModal.setVisible(true);
    }

    public void addEvent(Event e) {
        events.add(e);
        displayPanel.add(new EventPanel(e));
        displayPanel.revalidate();
        displayPanel.repaint();
    }




}
