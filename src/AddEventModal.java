import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddEventModal extends JDialog {
    private JTextField nameField;
    private JTextField dateField;
    private JTextField endDateField; // For Meeting end time
    private JTextField locationField; // For Meeting location
    private JComboBox<String> eventTypeComboBox; // Dropdown for event types

    public AddEventModal(Frame parent, EventListPanel eventListPanel) {
        super(parent, "Add Event", true);
        setLayout(new GridLayout(0, 2));

        nameField = new JTextField();
        dateField = new JTextField();
        endDateField = new JTextField();
        locationField = new JTextField();

        // Change 1: Create a dropdown menu for event types
        String[] eventTypes = {"Deadline", "Meeting"};
        eventTypeComboBox = new JComboBox<>(eventTypes);

        JButton addButton = new JButton("Add");

        add(new JLabel("Event Name:"));
        add(nameField);
        add(new JLabel("Event Date (yyyy-MM-dd HH:mm):"));
        add(dateField);

        // Change 2: Add the dropdown menu to the dialog
        add(new JLabel("Event Type:"));
        add(eventTypeComboBox);

        add(new JLabel("End Date (if Meeting, yyyy-MM-dd HH:mm):"));
        add(endDateField);
        add(new JLabel("Location (if Meeting):"));
        add(locationField);
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LocalDateTime parsedStartDate = LocalDateTime.parse(dateField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                    // Change 3: Check the selected type from the dropdown
                    if (eventTypeComboBox.getSelectedItem().equals("Deadline")) {
                        eventListPanel.addEvent(new Deadline(nameField.getText(), parsedStartDate));
                    } else {
                        LocalDateTime parsedEndDate = LocalDateTime.parse(endDateField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                        eventListPanel.addEvent(new Meeting(nameField.getText(), parsedStartDate, parsedEndDate, locationField.getText()));
                    }
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(AddEventModal.this, "Invalid date format.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setSize(300, 300);
        setLocationRelativeTo(parent);
    }
}