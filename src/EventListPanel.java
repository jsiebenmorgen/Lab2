import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EventListPanel extends JPanel {
    private ArrayList<Event> events;
    private JPanel displayPanel;
    private JComboBox<Event> eventDropdown; // Dropdown for existing events
    private JButton viewEventButton; // Button to view selected event
    private JButton addEventButton;

    public EventListPanel() {
        events = new ArrayList<>();
        setLayout(new BorderLayout());

        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(displayPanel), BorderLayout.CENTER);

        // Change 1: Initialize the dropdown for existing events
        eventDropdown = new JComboBox<>();
        eventDropdown.setPreferredSize(new Dimension(200, 30));

        viewEventButton = new JButton("View Selected Event");
        viewEventButton.addActionListener(e -> viewSelectedEvent());

        // Change 2: Panel to hold dropdown and button
        JPanel controlPanel = new JPanel();
        controlPanel.add(eventDropdown);
        controlPanel.add(viewEventButton);

        add(controlPanel, BorderLayout.NORTH);

        // Add Event button
        addEventButton = new JButton("Add Event");
        addEventButton.addActionListener(e -> openAddEventModal());
        displayPanel.add(addEventButton, BorderLayout.SOUTH);


    }

    private void viewSelectedEvent() {
        Event selectedEvent = (Event) eventDropdown.getSelectedItem();
        if (selectedEvent != null) {
            JOptionPane.showMessageDialog(this,
                    "Event Details:\n" + selectedEvent.getName()
                     + "\nDate: " + selectedEvent.getDateTime(),
                    "Event Details", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public void addEvent(Event event) {
        events.add(event);
        displayPanel.add(new EventPanel(event));

        // Change 3: Add the new event to the dropdown
        eventDropdown.addItem(event);

        displayPanel.revalidate();
        displayPanel.repaint();
    }

    public void openAddEventModal() {
        AddEventModal addEventModal = new AddEventModal((Frame)
                SwingUtilities.getWindowAncestor(this), this);
        addEventModal.setVisible(true);
    }

}