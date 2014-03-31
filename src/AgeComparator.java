import java.util.Comparator;

public class AgeComparator implements Comparator<Runner>{
  
  public int compare(Runner r1, Runner r2) {
    return r1.getAge() - r2.getAge(); 
  }
}
