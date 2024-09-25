import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddEventModal extends JDialog {
    public AddEventModal(Frame parent, EventListPanel eventListPanel) {
        super(parent, "Add Event", true);
        setLayout(new GridLayout(0, 2));

        JTextField nameField = new JTextField();
        JTextField dateField = new JTextField();
        JButton addButton = new JButton("Add");

        add(new JLabel("Event Name:"));
        add(nameField);
        add(new JLabel("Event Date (yyyy-MM-dd HH:mm):"));
        add(dateField);
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LocalDateTime parsedDate = LocalDateTime.parse(dateField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                    eventListPanel.addEvent(new Deadline(nameField.getText(), parsedDate));
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(AddEventModal.this, "Invalid date format.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setSize(300, 200);
        setLocationRelativeTo(parent);
    }
}
