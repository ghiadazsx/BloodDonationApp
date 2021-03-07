package BloodDonationApp;
//class provides methods to format and parse date and time in java
import java.text.SimpleDateFormat;
//accepts an argument that equals the number of milliseconds that have elapsed 
import java.util.Date;
/* **********************************************
 *     this class for present the date only     *
 ************************************************/
public class Donation {
   private Date  date;

    public Donation(Date DateOFDonationDate) {
        this.date = DateOFDonationDate;
    }
    // The getter counstruactor
    public Date getDate() {
        return date;
    }
   // The setter counstruactor
    public void setDate(Date DateOFDonationDate) {
        this.date = DateOFDonationDate;
    }
   //giving a specific implementation to the inherited method of parent class
   @Override
    public String toString() {
        String frmtDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
        return  frmtDate;
    }
  
}
