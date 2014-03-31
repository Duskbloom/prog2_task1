import java.util.Comparator;

public class TimeComparator implements Comparator<Runner>{
  
  public int compare(Runner r1, Runner r2) {
    return Double.compare(r1.getTime(), r2.getTime());
  }
  

}
