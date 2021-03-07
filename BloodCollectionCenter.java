
package BloodDonationApp;
//Search for file 
import java.io.File;
/*It thrown by these constructors if the file does exist but for some reason is inaccessible
which is used in class btnEventHandler to show an error the user made*/
import java.io.FileNotFoundException;
//use in the code to throw a failure in Input & Output operations. It is a checked exception.
import java.io.IOException;
//to the writer using specified arguments and format string.
import java.io.PrintWriter;
//This is a checked exception an it can occur when you fail to parse a "String" that is ought to have a special format
import java.text.ParseException;
//class provides methods to format and parse date and time in java
import java.text.SimpleDateFormat;
//is a resizable array, which can be found
import java.util.ArrayList;
//various ways to read input from the keyboard
import java.util.Scanner;
/********************************************************************************
*these are the import package which simply a container that groups related types* 
*********************************************************************************/


/**************************************************************************************************************
*              This class for blood collection center which apper and add to the list and                    *
*  it help to found and save the and cheack if the DonorsName of the center is add before or not by class load data *
*   and here we use two variables the DonorsName refernce to center_DonorsName and the array list reference to Donor_list *
***************************************************************************************************************/
public class BloodCollectionCenter {
    //insantan variable 
    private String DonorsName;
    private ArrayList<Donor> DONORsList;
//define the array
    public BloodCollectionCenter(String center_DonorsName) {
        this.DonorsName = center_DonorsName;
        DONORsList= new ArrayList<Donor>();
    }   
    
//the getter of the DonorsName 
    public String getDonorsName() {
        return DonorsName;
    }
//getter the of array
    public ArrayList<Donor> getDonor_list() {
        return DONORsList;
    }
//setter DonorsName
    public void setDonorsName(String DonorsName) {
        this.DonorsName = DonorsName;
    }
//setter list
    public void setDonor_list(ArrayList<Donor> DONORsList) {
        this.DONORsList = DONORsList;
    }
    //setter doner
    public void addDonor (Donor new_Donor) throws DuplicateException{
        if(! isFounded(new_Donor))
            DONORsList.add(new_Donor);
        else
    //throw the Exception
            throw new DuplicateException();
    }
    //define new class is founded to make suer if the list have the doners DonorsName 
    public boolean isFounded(Donor new_Donor){
        for(Donor donor: DONORsList){
            if(donor.getDonorsName().equalsIgnoreCase(new_Donor.getDonorsName())){
                return true;
            }
        }
        return false;
    } 
    //giving a specific implementation to the inherited method of parent class
    @Override
    public String toString() {
        String str_arg;
        str_arg="Blood Center DonorsName = "+DonorsName+"\n";
        for(Donor donor_arg
                : DONORsList){
            str_arg=str_arg + donor_arg.toString();
            str_arg=str_arg + donor_arg.ArrayIdealBLDDonation() + "\n\n";
        }
        return str_arg;  
    }
    // this to save the data from the user and add to the arry 
    public void save(){
         try{
           PrintWriter printW1 = new  PrintWriter(new File("bloodCenter_"+DonorsName+".txt"));
           printW1.println(toString());
  
           printW1.close();
         }catch( IOException ex){
           ex.printStackTrace();
      }
    } 
    
     //this class for load data from user if the user ask about kind of teset and for suer the class will peresnt the last date ofD1 
    public void loadData() throws DuplicateException, ParseException,FileNotFoundException{
        Donor donor=null;
        String lineArgs;
        
     //Infrastructure of class load data
        File fileArgs=new File("bloodCenter_"+DonorsName+".txt");
        Scanner scanArgs = new Scanner(fileArgs);
        //take the input from the user
        lineArgs = scanArgs.nextLine();
        DonorsName=lineArgs.substring(lineArgs.indexOf('=')+2, lineArgs.length());
        DONORsList=new ArrayList<>();        
        while (scanArgs.hasNext()) {            
            lineArgs=scanArgs.nextLine();
            String[] splitArgs = lineArgs.split(",");
            if(splitArgs.length==4){
                String BLDDonorsName=splitArgs[0].substring(splitArgs[0].indexOf(':')+2, splitArgs[0].length());
                String BLDtype=splitArgs[1].substring(splitArgs[1].indexOf(':')+2, splitArgs[1].length());
                String ContactNUM=splitArgs[2].substring(splitArgs[2].indexOf(':')+2, splitArgs[2].length());
                String Sstatus=splitArgs[3].substring(splitArgs[3].indexOf(':')+2, splitArgs[3].length());
                donor = new Donor(BLDDonorsName, BLDtype, ContactNUM,Sstatus);
            this.addDonor(donor);
            }else{
            if(splitArgs[0].equals("Whole Blood")){
                String STATUS_date= splitArgs[1].substring(splitArgs[1].indexOf(':')+2,splitArgs[1].length());
                WholeBloodDonation D1= new WholeBloodDonation(new SimpleDateFormat("dd/MM/yyyy").parse(STATUS_date));
                donor.AddBloodDonation(D1);
            }else if(splitArgs[0].equals("Power Red")){
                String STATUS_date= splitArgs[1].substring(splitArgs[1].indexOf(':')+2,splitArgs[1].length());
                PowerRedDonation D1= new PowerRedDonation(new SimpleDateFormat("dd/MM/yyyy").parse(STATUS_date));
                donor.AddBloodDonation(D1);
            }else if(splitArgs[0].equals("Plasma")){
                String STATUS_date= splitArgs[1].substring(splitArgs[1].indexOf(':')+2,splitArgs[1].length());
                PlasmaDonation D1= new PlasmaDonation(new SimpleDateFormat("dd/MM/yyyy").parse(STATUS_date));
                donor.AddBloodDonation(D1);
            }else if(splitArgs[0].equals("Platelet")){
                String STATUS_date= splitArgs[1].substring(splitArgs[1].indexOf(':')+2,splitArgs[1].length());
                PlateletDonation D1= new PlateletDonation(new SimpleDateFormat("dd/MM/yyyy").parse(STATUS_date));
                donor.AddBloodDonation(D1);
            }
            
           
        }
        }     
    }

    

}
