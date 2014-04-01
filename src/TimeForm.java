import javax.swing.*;
import javax.swing.JOptionPane;

class TimeForm extends Form {
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
  
  @Override
  public boolean isValidForm(){
    if(!isValidInteger(startNumberField.getText())){
      JOptionPane.showMessageDialog(null, "Du måste ange ett giltigt startnummer!");
      return false;
    }
    if(!isValidDouble(timeField.getText())){
      JOptionPane.showMessageDialog(null, "Du måste ange en giltig tid!");
      return false;
    }
    return true;
  }
  
}
