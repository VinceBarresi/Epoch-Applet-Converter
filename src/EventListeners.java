import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Date;
import java.util.regex.Pattern;

public class EventListeners extends Applet implements ActionListener {

    TextArea txtArea;
    TextField txtField;
    Date expiry;
    String epochTime;
    String formattedDate;
    Button resetButton = new Button("Reset");
    Button convertButton = new Button("Convert EPOCH");
    Pattern pattern;

    public void init() {

        setSize(600,300);
        txtArea = new TextArea(10,-10);
        txtField = new TextField(20);
        txtArea.setEditable(false);
        txtField.setEditable(true);
        txtField.setBackground(Color.YELLOW);
        add(txtField, "center");
        add(txtArea,"bottom");
        txtArea.setSize(300,100);
        resetButton.addActionListener(this);
        convertButton.addActionListener(this);
        add(resetButton);
        add(convertButton);
    }

    public void actionPerformed(ActionEvent e) {



        if (e.getSource() == convertButton) {

            txtArea.append(returnEpoch());
            convertButton.disable();
            txtField.setEditable(false);
        }
        if (e.getSource() == resetButton) {

            txtArea.setText("");
            txtField.setText("");
            txtField.setBackground(Color.YELLOW);
            convertButton.enable();
            txtField.setEditable(true);
        }
    }

    public Date convertEpoch() {

        epochTime = txtField.getText().toString();
        long epoch = Long.parseLong(epochTime);
        expiry = new Date(epoch*1000);
        return expiry;
    }

    public String returnEpoch() {
        convertEpoch();

        if (epochTime.length() > 0) {

            txtField.setBackground(Color.GREEN);
            formattedDate = "The converted date is " + expiry;
        }

        else if (epochTime.length() == 0) {

            txtArea.setText("Please enter valid EPOCH for conversion");
        }

        return formattedDate;
    }
}