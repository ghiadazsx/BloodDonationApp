package BloodDonationApp;
//
import java.util.Date;

/*************************************
*       this class only for          *
*       WholeBloodDonation           * 
**************************************/
public class WholeBloodDonation extends Donation{
    private final int WaitingPeriod = 56; 

    public WholeBloodDonation(Date donation_date) {
        super(donation_date);
    }
// Constrocutr variable to cheack if donor status available or not 
   
    
     public boolean Availability(Donor donor){
        boolean status=true;        
        if (!WaitingDateTST(donor)){
            status=false;
        }
        return status;            
    }
     // cheack if the WaitingDateTST is available 
     public boolean WaitingDateTST(Donor donor){
        int index=donor.getBLDDonations_TYPES().size();
        if(index>0){
            Donation don=donor.getBLDDonations_TYPES().get(donor.getBLDDonations_TYPES().size()-1);
            Date old_donation_date=don.getDate();
            long diff = super.getDate().getTime() - old_donation_date.getTime();
            diff=diff / (1000 * 60 * 60 * 24);
            if(diff>WaitingPeriod){
                return true;
            }else{
               return false;
            }
        }else{
            return true;
        }
    }
    
     @Override
    public String toString() {
        return "Whole Blood, "+"Date: " + super.toString();
    }
}
