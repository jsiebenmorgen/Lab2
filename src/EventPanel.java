import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class EventPanel extends JPanel {

    private Event event;
    private JButton completeButton;
    private JPanel eventPanel;
    private JButton addEventButton;

    public EventPanel(Event event) {

        eventPanel = new JPanel();
        eventPanel.setPreferredSize(new Dimension(700, 1000));
        this.event = event;
        this.setLayout(new GridLayout(2, 1));
        JLabel nameLabel = new JLabel("Name:" + event.getName());
        JLabel dateLabel = new JLabel("date:" + event.getDateTime().toString());

        eventPanel = new JPanel();
        eventPanel.setPreferredSize(new Dimension(700, 300));

        if (event instanceof Completable) {
            completeButton = new JButton("Complete");
            completeButton.setPreferredSize(new Dimension(100, 30));
            completeButton.addActionListener((ActionEvent e) -> {
                ((Completable) event).complete();

            });
            eventPanel.add(completeButton);
        }

        add(eventPanel);

        eventPanel.add(nameLabel);
        eventPanel.add(dateLabel);

    }

}
