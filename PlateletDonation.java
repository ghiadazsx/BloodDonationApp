package BloodDonationApp;

import java.util.Date;

public class PlateletDonation extends Donation{
    //instanstan variable 
    private final String Ideal_BloodTYPEs[]={"A positive", "A positive", "B negative", "O positive", "AB positive", "AB negative",};
    private final int WaitingPeriod = 7; 
    private final int AboveTo  = 24;

/***************************************************
 *                                                 *
 * this Infrastructure of class Platelet Donation  *
 *   to inherts from perents class Donation        *
 *                                                 *
 * *************************************************/
    public PlateletDonation(Date donation_date) {
        super(donation_date);
    }
    //cheack if the stutes == WaitingDateTST,testNumberOfDonation,testBloodType
    public boolean Availability(Donor donor){
        boolean status=true;
        if (!testBloodType(donor)){
            status=false;
        }
        if (!WaitingDateTST(donor)){
            status=false;
        }
        if (!testNumberOfDonation(donor)){
            status=false;
        }
        return status;            
    }
//cheack if the WaitingDateTST == BLDDonations_TYPES
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
    //cheack if the testBloodType == Ideal Blood Types
    public boolean testBloodType(Donor donor){
        for(int i=0;i<Ideal_BloodTYPEs.length;i++){
            if(donor.getBloodTYPE().equals(Ideal_BloodTYPEs[i]))
                return true;
        }
        return false;        
    }
    //count Number Of Donation
    public boolean testNumberOfDonation(Donor donor){
        int count=0;
        for(Donation don:donor.getBLDDonations_TYPES()){
            if(don instanceof PlateletDonation)
                count++;
        }
        if(count>AboveTo )
            return false;
        else
            return true;        
    }
    
     @Override
    public String toString() {
        return "Platelet, "+"Date: " + super.toString();
    }
}
