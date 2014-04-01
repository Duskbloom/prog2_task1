import javax.swing.*;

class TimeForm extends JPanel {
  private JTextField startNumberField;
  private JTextField timeField;

  public TimeForm(){
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    add(createNumberPanel());
    add(createTimePanel());
  }

  private JPanel createNumberPanel(){
    startNumberField = new JTextField(3);
    JLabel startNumberLabel = new JLabel("Startnr: ");
    JPanel panel = new JPanel();
    panel.add(startNumberLabel);
    panel.add(startNumberField);

    return panel;
  }

  private JPanel createTimePanel(){
    timeField = new JTextField(5);
    JLabel timeLabel = new JLabel("Tid: ");
    JPanel panel = new JPanel();
    panel.add(timeLabel);
    panel.add(timeField);

    return panel;
  }

  public int getStartNumber(){
    return Integer.parseInt(startNumberField.getText());
  }

  public double getTime(){
    return Double.parseDouble(timeField.getText());
  }
  
}
