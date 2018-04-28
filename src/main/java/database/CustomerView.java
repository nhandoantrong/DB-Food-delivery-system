package database;
import javafx.application.Application; 
import javafx.collections.FXCollections; 
import javafx.collections.ObservableList; 

import javafx.geometry.Insets; 
import javafx.geometry.Pos; 

import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.CheckBox; 
import javafx.scene.control.ChoiceBox; 
import javafx.scene.control.DatePicker; 
import javafx.scene.control.ListView; 
import javafx.scene.control.RadioButton; 
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.scene.control.ToggleGroup;  
import javafx.scene.control.ToggleButton; 
import javafx.stage.Stage; 
import javafx.animation.PathTransition; 
import javafx.application.Application; 
import static javafx.application.Application.launch; 
import javafx.event.EventHandler; 

import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.input.MouseEvent; 
import javafx.scene.paint.Color; 

import javafx.scene.shape.Circle; 
import javafx.scene.shape.LineTo; 
import javafx.scene.shape.MoveTo; 
import javafx.scene.shape.Path; 
import javafx.stage.Stage; 
import javafx.util.Duration; 


import database.Database;
import database.Customer;
public class CustomerView extends Application { 
	Customer customer;
	String name,telephone,address;
	@Override 
   public void start(Stage stage) {    
      //Label for name 
      Text nameLabel = new Text("Name"); 
      
      //Text field for name 
      TextField nameText = new TextField(); 
       
      Text adressLabel= new Text("Address");
      
      TextField adressText=new TextField();
      
      Text TelephoneLabel= new Text("Telephone");
      
      TextField TelephoneText=new TextField();
       
      Button confirm= new Button("Confirm");
      
      confirm.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() { 
          @Override 
          public void handle(javafx.scene.input.MouseEvent e) { 
        	  
        	  name=nameText.getText();
        	  address=adressText.getText();
        	  telephone=TelephoneText.getText();
        	  customer=new Customer(null,name,Integer.parseInt(telephone),address);
        	Database.getInstance().createCustomer(customer);
          } 
       });   
      GridPane gridPane = new GridPane();    
      
      //Setting size for the pane 
      gridPane.setMinSize(500, 500); 
       
      //Setting the padding    
      gridPane.setPadding(new Insets(10, 10, 10, 10));  
      
      //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);       
      
      //Setting the Grid alignment 
      gridPane.setAlignment(Pos.CENTER); 
       
      //Arranging all the nodes in the grid 
      gridPane.add(nameLabel, 0, 0); 
      gridPane.add(nameText, 1, 0); 
       
      gridPane.add(TelephoneLabel, 0, 1);
      gridPane.add(TelephoneText, 1, 1);
      
      gridPane.add(adressLabel, 0, 2);
      gridPane.add(adressText, 1, 2);
      
      gridPane.add(confirm, 1, 3);
      //Setting the back ground color 
      gridPane.setStyle("-fx-background-color: BEIGE;");       
       
      //Creating a scene object 
      Scene scene = new Scene(gridPane); 
      
      //Setting title to the Stage 
      stage.setTitle("Customer"); 
         
      //Adding scene to the stage 
      stage.setScene(scene);  
      
      //Displaying the contents of the stage 
      stage.show(); 
   }      
   public static void main(String args[]){ 
      launch(args); 
   } 
}