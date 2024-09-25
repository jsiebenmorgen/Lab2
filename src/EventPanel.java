import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class EventPanel extends JPanel {

    private Event event;
    private JButton completeButton;

    public EventPanel(Event event) {

        this.event = event;
        this.setLayout(new GridLayout(2, 1));
        JLabel nameLabel = new JLabel("Name:" + event.getName());
        JLabel dateLabel = new JLabel("date:" + event.getDateTime().toString());
        JLabel timeLabel = new JLabel("time:" + event.getDateTime().toString());

        add(nameLabel);
        add(dateLabel);

        if (event instanceof Completable) {
            completeButton = new JButton("Complete");
            completeButton.addActionListener((ActionEvent e) -> {
                ((Completable) event).complete();

            });
            add(completeButton);
        }

    }



}
