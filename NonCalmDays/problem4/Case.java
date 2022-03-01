package Package4;

import java.util.Date;

public class Case {
  private Crime crime;
  private Date date; //all cases are constructed without a date – the value is null
  
  public Case(Crime crime) {
    this.crime = crime;
  }
  
  public Crime getCrime() {
    return crime;
  }
  
  public void setCrime(Crime crime) {
    this.crime = crime;
  }
  
  public Date getDate() {
    return date;
  }
  
  public void setDate(Date date) {
    this.date = date;
  }
}
