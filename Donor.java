
package BloodDonationApp;

//is a resizable array, which can be found
import java.util.ArrayList;
//accepts an argument that equals the number of milliseconds that have elapsed 
import java.util.Date;
        /* ************************************************
        *     this class for present Infrastructure    *  *
      *                                              *    *
     *                the Donor only                *     *
    ************************************************      *
    *  this class for present intrfrastructure     *      *
    *                                              *     *  
    *                                              *    *
    *              the Donor only                  *   *
    ************************************************/

   //insantan variable 
public class Donor {
    private String DonorsName, BloodTYPE, ContactNUM;
    private ArrayList<Donation> BLDDonations_TYPES;
    private String The_STATUS;
    //counstructor variable
    public Donor(String DonorsName, String BloodTYPE, String ContactNUM) {
        this.DonorsName = DonorsName;
        this.BloodTYPE = BloodTYPE;
        this.ContactNUM = ContactNUM;
        The_STATUS="Already avalibale";
        BLDDonations_TYPES= new ArrayList<>();
    }
    //the Counstructor variable with Stauts
    public Donor(String DonorsName, String BloodTYPE, String ContactNUM, String The_STATUS) {
        this.DonorsName = DonorsName;
        this.BloodTYPE = BloodTYPE;
        this.ContactNUM = ContactNUM;
        this.The_STATUS=The_STATUS;
        BLDDonations_TYPES= new ArrayList<>();
    }
// the getter 
    public String getDonorsName() {
        return DonorsName;
    }

    public String getBloodTYPE() {
        return BloodTYPE;
    }

    public String getContactNUM() {
        return ContactNUM;
    }

    public String getThe_STATUS() {
        updateThe_STATUS();
        return The_STATUS;
    }
//the setter 
    public void setThe_STATUS(String The_STATUS) {
        this.The_STATUS = The_STATUS;
    } 
    
    public ArrayList<Donation> getBLDDonations_TYPES() {
        return BLDDonations_TYPES;
    }
//the setter
    public void setDonorsName(String DonorsName) {
        this.DonorsName = DonorsName;
    }
// the Setter
    public void setBloodTYPE(String BloodTYPE) {
        this.BloodTYPE = BloodTYPE;
    }
// the setter
    public void setContactNUM(String ContactNUM) {
        this.ContactNUM = ContactNUM;
    }
//the setter 
    public void setBLDDonations_TYPES(ArrayList<Donation> BLDDonations_TYPES) {
        this.BLDDonations_TYPES = BLDDonations_TYPES;
    }
    /*************************************************************
     * this class to prsennt list of the list ideal blood donation*
     *************************************************************/
    public String ArrayIdealBLDDonation(){
        String str="The ideal blood donation are: \n";
        if(BloodTYPE.equals("O positive")){
            str+= "Whole Blood Donation, Power Red Donation, Platelet Donation";
        }else if(BloodTYPE.equals("O negative")){
            str+="Whole Blood Donation, Power Red Donation";
        }else if(BloodTYPE.equals("A positive")||BloodTYPE.equals("B positive")){
            str+="Whole Blood Donation, Platelet Donation";
        }else if(BloodTYPE.equals("A negative")||BloodTYPE.equals("B negative")){
            str+="Whole Blood Donation, Power Red Donation, Platelet Donation";
        }else if(BloodTYPE.equals("AB negative")||BloodTYPE.equals("AB positive")){
            str+= "Whole Blood Donation, Plasma Donation, Platelet Donation";
        }
        return str;
    }
    // too cheack if there is donor to finsh or not from list of ideal blood donation
    public boolean IsCapableDonation(Donation donotion){
        if(donotion instanceof WholeBloodDonation){
            return ((WholeBloodDonation) donotion).Availability(this);
        }else if(donotion instanceof PowerRedDonation){
            return ((PowerRedDonation) donotion).Availability(this);
        }else if(donotion instanceof PlasmaDonation){
            return ((PlasmaDonation) donotion).Availability(this);
        }else if(donotion instanceof PlateletDonation){
            return ((PlateletDonation) donotion).Availability(this);
        }else{
            return false;
        }
    }
    //the last The_STATUS of ideal blood donation
    public void updateThe_STATUS(){
        int index=this.getBLDDonations_TYPES().size();
        if(index>0){
            The_STATUS="";
            WholeBloodDonation wd=new WholeBloodDonation(new Date());
            PowerRedDonation pd=new PowerRedDonation(new Date());
            PlasmaDonation pld=new PlasmaDonation(new Date());
            PlateletDonation plad=new PlateletDonation(new Date());
            if(wd.Availability(this)){
                The_STATUS+="WholeBlood ";
            }
            
            if(pd.Availability(this)){
                    The_STATUS+="PowerRed ";
            }
            
            if(pld.Availability(this)){
                The_STATUS+="Plasma ";
            }
            
            if(plad.Availability(this)){
                    The_STATUS+="Platelet ";
            }
            
            if(The_STATUS.length()>0){
                The_STATUS+=" is avalibale";
            }else{
                The_STATUS="is Not avalibale";
            }
        }else{
                The_STATUS="Already avalibale";
            }
    }

    
    //check if the bloodDonation == the The_STATUS
    public boolean AddBloodDonation(Donation donotion){
        boolean The_STATUS= IsCapableDonation(donotion);
        if(The_STATUS){
            BLDDonations_TYPES.add(donotion);
            The_STATUS=false;
            return true;
        }else{
            return false;
        }        
    } 
    
    @Override
    public String toString() {
       String str;
        str="Donor DonorsName: "+DonorsName+", Blood type: "+BloodTYPE
                +", ContactNUM: "+ContactNUM+", The_STATUS: "+getThe_STATUS()+"\n"+"Donation Dates: \n";
        for(Donation donation: BLDDonations_TYPES){
            str=str+donation.toString();
            str=str+"\n";
        }
        return str;  
    }
    

}
