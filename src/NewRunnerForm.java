import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewRunnerForm extends Form{
  /**
   * 
   */
  private static final long serialVersionUID = 6878109098306477780L;
  private JTextField nameField = new JTextField(10);
  private JTextField countryField = new JTextField(10);
  private JTextField ageField = new JTextField(2);

  public NewRunnerForm(int startNumber){
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    JLabel nameLabel = new JLabel("Namn: ");
    JLabel countryLabel = new JLabel("Land: ");
    JLabel ageLabel = new JLabel("Ålder: ");
    JLabel startNumberLabel = new JLabel("Startnummer: " + startNumber);
    p1.add(nameLabel);
    p1.add(nameField);
    p2.add(countryLabel);
    p2.add(countryField);
    p3.add(ageLabel);
    p3.add(ageField);
    this.add(startNumberLabel);
    this.add(p1);
    this.add(p2);
    this.add(p3);
  }

  public String getName(){
    return nameField.getText();
  }

  public String getCountry(){
    return countryField.getText();
  }

  public int getAge(){
    return Integer.parseInt(ageField.getText());
  }

  @Override
  public boolean isValidForm() {
    if (!isValidString(nameField.getText())){
      JOptionPane.showMessageDialog(null, "Du måste ange ett namn!");
      return false;
    }
    if (!isValidString(countryField.getText())){
      JOptionPane.showMessageDialog(null, "Du måste ange ett land!");
      return false;
    }
    if (!isValidInteger(ageField.getText())){
      JOptionPane.showMessageDialog(null, "Du måste ange en ålder i siffror");
      return false;
    }
    return true;
  }
}
