
package BloodDonationApp;

/*It thrown by these constructors if the file does exist but for some reason is inaccessible
which is used in class btnEventHandler to show an error the user made*/
import java.io.FileNotFoundException;
//Provides classes and interfaces for handling text, dates, numbers, and messages 
import java.text.*;
// show us the date Schedule in interface 
import java.time.format.DateTimeFormatter;
//This is an event related to window showing/hiding actions. It is represented by the class BtnEventsHandler.
import javafx.event.*;
// these librarys are for Style the appliction    
import javafx.geometry.*;
import javafx.scene.Scene;
import java.util.logging.*;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Font;
/********************************************************************************
*these are the import package which simply a container that groups related types* 
*********************************************************************************/

public class Usr_Intrface extends Application {

    /***************************************************************************
     *            every variable difine by methods                             *
     *            and are import from the Library of JavaFx                    *  
     * and here we creat the variables style of the app to work on            *
     **************************************************************************/
    TextField DonersNameTXT, ContactsDonorTXT,CenterTXT;
    DatePicker datePicker;
    VBox Box2Args;
    TextArea AreaArgsTXT; 
    Button addTheCenterBTN, addTheDonorBTN, addTheDonationBTN;
    Button DisplyBTN, ClearBTN, $aveBTN, LoadBTN;
    ComboBox donorBloodComboBox;
    GridPane basePan, pan1, pan2, pan3, pan4;
    BloodCollectionCenter center;
    Donor donor;
    ListView<String> typeListView;
    
    
    /***************************************************************************
     *           here is the Infrastructure for interface which include        *
     *               the the bottoms and the Empty boxess to write on          *
     **************************************************************************/
    

    @Override
    public void start(Stage TheFirstStage) {
        
      //*** the BasePand is the window  *** 
        basePan = new GridPane();
        basePan.setPadding(new Insets(11, 10, 12, 10));
        basePan.setAlignment(Pos.TOP_LEFT);
        basePan.setStyle("-fx-background-color:#f7e6ff;");
// The empty box to write on for "center" 
        CenterTXT = new TextField("");
// The button of "center" to add more centers 
        addTheCenterBTN = new Button("Create center ");
 //  here is the style of the button 
        addTheCenterBTN.setStyle("-fx-text-fill: #1d1d1d;\n" +
"    -fx-background-color: #e6ff99;\n" +
          //how the button get around shape        
"    -fx-border-radius: 20;\n" +
"    -fx-background-radius: 80;\n" +
          //the font of the button
"    -fx-padding: 10; -fx-font: 10pt \"Sans-serif\";");
        
            /*************
         * the first pand *
            ************/
        
// the highest and the length pand center:  
        pan1 = new GridPane();
        pan1.setPadding(new Insets(14, 14, 14, 14));
        pan1.setAlignment(Pos.TOP_LEFT);
        pan1.setHgap(10);
        pan1.setVgap(6);
/*  the loction of the bottom and string in side the window */
        pan1.add(new Label("Center Name:"), 0, 0);
        // The Font of "center name in pand 1"
        pan1.setStyle(("-fx-font: 14pt \"Serif\";"));
        pan1.add(CenterTXT, 1, 0);
        pan1.add(addTheCenterBTN, 2, 0);
        
            /*************
         * the Second pand *
            ************/
       
//the highest and the length of pand  :
        pan2 = new GridPane();
        pan2.setPadding(new Insets(14, 14, 14, 14));
        pan2.setAlignment(Pos.TOP_LEFT);
        pan2.setHgap(10);
        pan2.setVgap(16);
//The empty box to write on for "Donor Name"
        DonersNameTXT = new TextField("");
//The selection box 
        donorBloodComboBox = new ComboBox();
        donorBloodComboBox.setPrefSize(250,30);
        donorBloodComboBox.setPromptText("Select Blood Type");
        donorBloodComboBox.getItems().add("O positive");
        donorBloodComboBox.getItems().add("O negative");
        donorBloodComboBox.getItems().add("A positive");
        donorBloodComboBox.getItems().add("A negative");
        donorBloodComboBox.getItems().add("B positive");
        donorBloodComboBox.getItems().add("B negative");
        donorBloodComboBox.getItems().add("AB positive");
        donorBloodComboBox.getItems().add("AB negative");
        // the style of the selection box
        donorBloodComboBox.setStyle("-fx-text-fill: #1d1d1d;\n" +
"    -fx-background-color: #e6ff99;\n" +
"    -fx-border-radius: 20;\n" +
"    -fx-background-radius: 80;\n" +
"    -fx-padding: 11; -fx-font: 12pt \"Sans-serif\";");
        
     //The empty box to write on for "Contact number"
        ContactsDonorTXT = new TextField("");
        
     // the style of the button in side the pand 
        addTheDonorBTN = new Button("Add Donor to center");
        addTheDonorBTN.setStyle("-fx-text-fill: #1d1d1d;\n" +
"    -fx-background-color: #e6ff99;\n" +
"    -fx-border-radius: 20;\n" +
"    -fx-background-radius: 80;\n" +
"    -fx-padding: 10; -fx-font: 10pt \"Sans-serif\";");
        // the location of the Buttons in side the pand 
        pan2.add(new Label("Donor Name:"), 0, 0);
        pan2.add(DonersNameTXT, 1, 0);
        pan2.add(new Label("Blood type:"), 0, 1);
        pan2.add(donorBloodComboBox, 1, 1);
        pan2.add(new Label("Contact No:"), 0, 2);
        pan2.add(ContactsDonorTXT, 1, 2);
        pan2.add(addTheDonorBTN, 2, 2);
        pan2.setStyle(("-fx-font: 14pt \"Serif\";"));
        
         /*************
         * the Thred pand *
            ************/
   //the highest and the length of pand  :
        pan3 = new GridPane();
        pan3.setPadding(new Insets(15, 14, 13, 12));
        pan3.setAlignment(Pos.TOP_LEFT);
        pan3.setHgap(20);
        pan3.setVgap(10);
        pan3.setStyle(("-fx-font: 14pt \"Serif\";"));
      // The list for whoole blood and power blood etas..
        typeListView = new ListView<String>();
       //the highest and leangth of list 
        typeListView.setPrefSize(200, 200);
//the location of the laple inside the pand
        pan3.add(new Label("Donation type"), 0, 0);
        pan3.add(typeListView, 1, 0);
        pan3.add(new Label("Date"), 0, 1);
        datePicker = new DatePicker();
        pan3.add(datePicker, 1, 1);
//the location of the buttons inside the pand 
        addTheDonationBTN = new Button("Add Donation to donor");
        pan3.add(addTheDonationBTN, 2, 1);
   //the Style of the buttons 
        addTheDonationBTN.setStyle("-fx-text-fill: #1d1d1d;\n" +
"    -fx-background-color: #e6ff99;\n" +
"    -fx-border-radius: 20;\n" +
"    -fx-background-radius: 80;\n" +
"    -fx-padding: 10; -fx-font: 10pt \"Sans-serif\";");
        DisplyBTN = new Button("Display");
        DisplyBTN.setPrefSize(80, 40);
DisplyBTN.setStyle("-fx-text-fill: #1d1d1d;\n" +
"    -fx-background-color: #ffbf00;\n" +
"    -fx-border-radius: 20;\n" +
"    -fx-background-radius: 80;\n" +
"    -fx-padding: 10; -fx-font: 10pt \"Sans-serif\";");
        $aveBTN = new Button("Save");
        $aveBTN.setPrefSize(80, 40);
$aveBTN.setStyle("-fx-text-fill: #1d1d1d;\n" +
"    -fx-background-color: #ffff00;\n" +
"    -fx-border-radius: 20;\n" +
"    -fx-background-radius: 80;\n" +
"    -fx-padding: 10; -fx-font: 10pt \"Sans-serif\";");
        LoadBTN = new Button("Load");
        LoadBTN.setPrefSize(80, 40);
LoadBTN.setStyle("-fx-text-fill: #1d1d1d;\n" +
"    -fx-background-color: #0080ff;\n" +
"    -fx-border-radius: 20;\n" +
"    -fx-background-radius: 80;\n" +
"    -fx-padding: 10; -fx-font: 10pt \"Sans-serif\";");
        ClearBTN = new Button("Clear");
        ClearBTN.setPrefSize(80, 40);
        ClearBTN.setStyle("-fx-text-fill: #1d1d1d;\n" +
"    -fx-background-color: #ff0000;\n" +
"    -fx-border-radius: 20;\n" +
"    -fx-background-radius: 80;\n" +
"    -fx-padding: 10; -fx-font: 10pt \"Sans-serif\";");
// these bottom difined action in class BtnEventsHandler
        Box2Args = new VBox(4, DisplyBTN, LoadBTN, $aveBTN, ClearBTN);
//This event includes actions like key pressed, key released and key typed
        addTheCenterBTN.setOnAction(new BtnEventsHandler());
        addTheDonorBTN.setOnAction(new BtnEventsHandler());
        addTheDonationBTN.setOnAction(new BtnEventsHandler());
        DisplyBTN.setOnAction(new BtnEventsHandler());
        $aveBTN.setOnAction(new BtnEventsHandler());
        LoadBTN.setOnAction(new BtnEventsHandler());
        ClearBTN.setOnAction(new BtnEventsHandler());
        /*************
         * the fourth pand *
            ************/
//the highest and the length of pand  :
        pan4 = new GridPane();
        pan4.setPadding(new Insets(10, 10, 10, 10));
        AreaArgsTXT = new TextArea();
        AreaArgsTXT.setPrefColumnCount(50);
        AreaArgsTXT.setPrefRowCount(20);
//the loction of  in pand 
        pan4.add(AreaArgsTXT, 0, 0);
        pan4.add(Box2Args, 1, 0);
//
        basePan.add(pan1, 0, 0);
        basePan.add(pan2, 0, 1);
        basePan.add(pan3, 0, 2);
        basePan.add(pan4, 0, 3);
// the name of the appliction 
        Scene scArgs = new Scene(basePan, 1000, 700);
        TheFirstStage.setScene(scArgs);
        TheFirstStage.setTitle("Donation Center Appliction");
        TheFirstStage.show();

        donorBloodComboBox.setOnAction(new BtnEventsHandler());

    }

    private class BtnEventsHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent action) {
//The source from which the event is generated will be the source of the "Center" event.
            if (action.getSource().equals(addTheCenterBTN)) {
                if (CenterTXT.getText().equals("")) {
                    alartError("Please, enter new center name");
                } else {
                    center = new BloodCollectionCenter(CenterTXT.getText());
                    alartInfo("The new center has been added");
                }
// The source from which the event is generated will be the source of the "Clear" event.
            } else if (action.getSource().equals(DisplyBTN)) {
                AreaArgsTXT.clear();
                AreaArgsTXT.setText(center.toString());
            } else if (action.getSource().equals(ClearBTN)) {
                AreaArgsTXT.setText("");
            } else if (action.getSource().equals(addTheDonorBTN)) {
//The source from which the event is generated will be the source of the DonorName event.
                if (DonersNameTXT.getText().equals("")) {
                    alartError("Please, enter donor Name");
// The source from which the event is generated will be the source of the blood type event.
                } else if ((String) donorBloodComboBox.getValue() == null) {
                    alartError("Please, enter  donor blood type");
//The source from which the event is generated will be the source of the contact number event.
                } else if (ContactsDonorTXT.getText().equals("")) {
                    alartError("Please, enter  donor contact number");
                } else {
//this method will add new donor if the user input these data inside the arrgument
                    donor = new Donor(DonersNameTXT.getText(), "" + donorBloodComboBox.getValue(), ContactsDonorTXT.getText());
                    try {
                        center.addDonor(donor);
                        alartInfo("The donor has been added");
//Test if the donor add before or not It is represented and includes actions 
                    } catch (DuplicateException ex) {
                        alartError("The donor is exist, enter another donor name");
                    }
                }
//this method if the user dont write the input 
                AreaArgsTXT.clear();
                AreaArgsTXT.setText(center.toString());
            } else if (action.getSource().equals(addTheDonationBTN)) {
                String pType = (String) typeListView.getSelectionModel().getSelectedItem();

                if (pType == null) {
                    alartError("Please, select a donation type");
                } else if (CenterTXT.getText().equals("")) {
                    alartError("Please, enter new center name");
                } else if (DonersNameTXT.getText().equals("")) {
                    alartError("Please, enter  donor Name"); 
                } else if ((String) donorBloodComboBox.getValue() == null) {
                    alartError("Please, enter  donor blood type");
                } else if (ContactsDonorTXT.getText().equals("")) {
                    alartError("Please, enter  donor contact number");
                } else if (datePicker.getValue() == null) {
                    alartError("Please, Enter the date");
          // if the user ask for date the of the Donor to make sure if the donor can Donation again 
                } else {
                    try {
                         boolean checkAvaliablity = false;
                        if (pType.equals("Whole Blood")) {
                           
                            WholeBloodDonation wb = new WholeBloodDonation(new SimpleDateFormat("dd/MM/yyyy").parse(datePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                            checkAvaliablity = donor.AddBloodDonation(wb);
                        } else if (pType.equals("Power Red")) {

                            PowerRedDonation wb = new PowerRedDonation(new SimpleDateFormat("dd/MM/yyyy").parse(datePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                            checkAvaliablity = donor.AddBloodDonation(wb);
                        } else if (pType.equals("Plasma")) {
                            PlasmaDonation wb = new PlasmaDonation(new SimpleDateFormat("dd/MM/yyyy").parse(datePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                            checkAvaliablity = donor.AddBloodDonation(wb);
                        } else if (pType.equals("Platelet")) {
                            PlateletDonation wb = new PlateletDonation(new SimpleDateFormat("dd/MM/yyyy").parse(datePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                            checkAvaliablity = donor.AddBloodDonation(wb);
                        }
                        if (checkAvaliablity == true)
                            alartInfo("donation has been added Successfuly");
                        else
                            alartError("donation unavailable");
                    } catch (ParseException ex) {
                        Logger.getLogger(Usr_Intrface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //Setting the values to these properties using their respective setter methods
                AreaArgsTXT.clear();
                AreaArgsTXT.setText(center.toString());
            } else if (action.getSource().equals($aveBTN)) {
                center.save();
                alartInfo("Successful, the center data has been saved");
            } else if (action.getSource().equals(LoadBTN)) {
                if (CenterTXT.getText().equals("")) {
                    alartError("Please, enter center name");
                } else {
                    center = new BloodCollectionCenter(CenterTXT.getText());
               //the Errors
                    try {
                        center.loadData();
                        AreaArgsTXT.setText("");
                        AreaArgsTXT.setText(center.toString());
                        alartInfo("Successful, the center data has been loaded");
                    } catch (DuplicateException ex) {
                        alartError("There Duplicate Exception");
                    } catch (ParseException ex) {
                        alartError("parsing problem");
                    } catch (FileNotFoundException ex) {
                        alartError("File not found!! you need to save first!");
                    }
                }

            }
           // chick the blodd Type and what sholud show for each case 
            if (donorBloodComboBox.getValue() != null) {
                if (donorBloodComboBox.getValue().equals("AB positive")
                        || donorBloodComboBox.getValue().equals("AB negative")) {
                    typeListView.getItems().removeAll(typeListView.getItems());
                    typeListView.getItems().add("Whole Blood");
                    typeListView.getItems().add("Plasma");
                    typeListView.getItems().add("Platelet");

                } else if (donorBloodComboBox.getValue().equals("O negative")
                        || donorBloodComboBox.getValue().equals("B negative")) {
                    typeListView.getItems().removeAll(typeListView.getItems());
                    typeListView.getItems().add("Whole Blood");
                    typeListView.getItems().add("Power Red");
                } else if (donorBloodComboBox.getValue().equals("A negative")
                        || donorBloodComboBox.getValue().equals("O positive")) {
                    typeListView.getItems().removeAll(typeListView.getItems());
                    typeListView.getItems().add("Whole Blood");
                    typeListView.getItems().add("Power Red");
                    typeListView.getItems().add("Platelet");

                } else {
                    typeListView.getItems().removeAll(typeListView.getItems());
                    typeListView.getItems().add("Whole Blood");
                    typeListView.getItems().add("Platelet");
                }

            }

        }
    }
    
// action for more information and display for user
    public void alartInfo(String strArgs) {
        Alert alartArgs = new Alert(Alert.AlertType.INFORMATION);
        alartArgs.setTitle("Information");
        alartArgs.setHeaderText(null);
        alartArgs.setContentText(strArgs);
        alartArgs.showAndWait();
    }
// action see if there is an error an d display for user 
    public void alartError(String strArgs) {
        Alert alartArgs = new Alert(Alert.AlertType.ERROR);
        alartArgs.setTitle("Error");
        alartArgs.setHeaderText(null);
        alartArgs.setContentText(strArgs);
        alartArgs.showAndWait();
    }

    public static void main(String[] args) {
        Usr_Intrface.launch(args);
    }
}
