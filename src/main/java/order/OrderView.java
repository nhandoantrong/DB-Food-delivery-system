package order;
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
public class OrderView extends Application { 
	Customer customer;
	String name,telephone,address;
	Text menuLabel= new Text("MENU");
    Button button[]=new Button[6];
    
    GridPane buttonSet =new GridPane();
    Button confirm= new Button("Confirm");
    ObservableList<String> food = FXCollections.observableArrayList(); 
    ListView<String> foodView = new ListView<String>(food); 
    GridPane gridPane = new GridPane();    
    
	private class dishHandle implements EventHandler<javafx.scene.input.MouseEvent>
    {

		String dishQuantity;
		@Override
		public void handle(MouseEvent arg0) {
			Quantity quantity = new Quantity();
	         Stage scene= new Stage();
	         quantity.start(scene);
	            
		}
  	  
    }
	@Override 
   public void start(Stage stage) {    
      //Label for name 
      
      for (int i=0;i<6;i++)
      {
    	  button[i]=new Button(String.valueOf(i+1));
    	  button[i].setMaxSize(1000, 1000);
    	  button[i].setMinSize(100, 100);
    	  button[i].setOnMouseClicked(new dishHandle());
      }
     
      buttonSet.setVgap(5);
      buttonSet.setHgap(5);
      for (int i=0;i<6;i++)
      {
    	  buttonSet.add(button[i], i%2, i/2);
      }
      
      
      confirm.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() { 
          @Override 
          public void handle(javafx.scene.input.MouseEvent e) { 
        	  
        	 
          } 
       });
      
      //Setting size for the pane 
      gridPane.setMinSize(720, 720); 
       
      //Setting the padding    
      gridPane.setPadding(new Insets(10, 10, 10, 10));  
      
      //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);       
      
      //Setting the Grid alignment 
      gridPane.setAlignment(null); 
       
      //Arranging all the nodes in the grid 
      
      gridPane.add(foodView, 0, 1);
      gridPane.add(menuLabel, 1, 0);
      gridPane.add(buttonSet, 1, 1);
      //Setting the back ground color 
      gridPane.setStyle("-fx-background-color: BEIGE;");       
       
      menuLabel.setStyle("-fx-font: normal bold 19px 'serif' "); 
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