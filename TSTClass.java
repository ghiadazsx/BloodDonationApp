package BloodDonationApp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/*************************************************
 *                                               *
 *        here is the test class which test      *
 *            all the classes before             *
 *           run to the user and check           *
 *            if there is any error              *
 *                                               *
 * **********************************************/
public class TSTClass {
    public static void main (String[] args) throws ParseException{

        BloodCollectionCenter bcCenter= new BloodCollectionCenter("Hittin Center");
        Donor donor1= new Donor("salman", "AB positive", "05588937");
        System.out.println(donor1.ArrayIdealBLDDonation());
        System.out.println(bcCenter.toString());           
        bcCenter.save();
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");       
        
        
        donor1.AddBloodDonation(new WholeBloodDonation(new SimpleDateFormat("dd/MM/yyyy").parse("18/06/2003")));
        donor1.AddBloodDonation(new PlasmaDonation(new SimpleDateFormat("dd/MM/yyyy").parse("17/04/2007")));
        donor1.AddBloodDonation(new WholeBloodDonation(new SimpleDateFormat("dd/MM/yyyy").parse("03/11/2010")));
        try{
        bcCenter.addDonor(donor1);
        
        } catch (DuplicateException ex) {
            ex.printStackTrace();
        }
        
       
        System.out.println(bcCenter.toString());           
        bcCenter.save();
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println(bcCenter.toString());           
        bcCenter.save();
        System.out.println(" *-*-*-*-*-*-* read the data from file *-*-*-*-*-*-*");
        
            try {
                bcCenter.loadData();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        System.out.println(bcCenter.toString());

    }
    
}
