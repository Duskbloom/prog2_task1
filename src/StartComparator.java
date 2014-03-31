import java.util.Comparator;

public class StartComparator implements Comparator<Runner>{
  
  public int compare(Runner r1, Runner r2) {
    return r1.getStartn() - r2.getStartn();
  }
}
