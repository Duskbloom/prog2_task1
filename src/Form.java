import javax.swing.*;

abstract class Form extends JPanel{
  protected boolean isValidInteger(String input){
    try{
      Integer.parseInt(input);
    }catch(NumberFormatException e){
      return false;
    }
    return true;
  }

  protected boolean isValidDouble(String input){
    try{
      Double.parseDouble(input);
    }catch(NumberFormatException e){
      return false;
    }
    return true;
  }

  public abstract boolean isValid();
}
