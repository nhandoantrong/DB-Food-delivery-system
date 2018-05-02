package UI;
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
import javafx.scene.control.cell.PropertyValueFactory;
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
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.*;
import database.Customer;
import database.Database;
public class CustomersView extends Application {
	
	
	
	GridPane gridPane=new GridPane();
	Button create=new Button("CREATE");
	Button update=new Button("UPDATE");
	Button delete= new Button("DELETE");
	ArrayList<Customer> list =new ArrayList<Customer>();
	@Override
	public void start(Stage stage)  {
		TableView <Customer> table= new TableView<Customer>();
		TableColumn<Customer, Integer> id //
	    = new TableColumn <Customer, Integer> ("ID");
		id.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("id"));
		
		TableColumn<Customer, String> name //
	    = new TableColumn <Customer, String> ("Name");
		name.setCellValueFactory(new PropertyValueFactory<Customer,String>("Name"));

		TableColumn<Customer, Integer> tel //
	    = new TableColumn <Customer, Integer> ("Tel");
		tel.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("Tel"));

		
		TableColumn<Customer, String> address //
	    = new TableColumn <Customer, String> ("Address");
		address.setCellValueFactory(new PropertyValueFactory<Customer,String>("address"));
		
		
		create.setMinSize(100, 100);
		update.setMinSize(100,100 );
		delete.setMinSize(100, 100);
		table.getColumns().addAll(id, name, tel, address);
		table.setEditable(true);
		list=Database.getInstance().getCustomers();
		 ObservableList<Customer> data =FXCollections.observableArrayList(list);
		table.setItems(data);
		System.out.println(list.size());
		
		
		
		create.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() { 
	          @Override 
	          public void handle(javafx.scene.input.MouseEvent e) { 
	        	  CustomerView view= new CustomerView();
	        	  Stage scene= new Stage();
	        	  view.start(scene);
	          } 
	       });   
		update.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() { 
	          @Override 
	          public void handle(javafx.scene.input.MouseEvent e) { 
	        	  list=Database.getInstance().getCustomers();
	        	  ObservableList<Customer> data =FXCollections.observableArrayList(list);
	      			table.setItems(data);	        		

	          } 
	       });   
		delete.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() { 
	          @Override 
	          public void handle(javafx.scene.input.MouseEvent e) { 
	        	  
	        	  Database.getInstance().deleteCustomer(table.getSelectionModel().getSelectedItem());
	        	  table.getItems().removeAll(
	                      table.getSelectionModel().getSelectedItems()
	              );
	          } 
	       });   

		gridPane.setMinSize(720, 720); 
	       
	      //Setting the padding    
	      gridPane.setPadding(new Insets(10, 10, 10, 10));  
	      
	      //Setting the vertical and horizontal gaps between the columns 
	      gridPane.setVgap(5); 
	      gridPane.setHgap(5);       
	      
	      //Setting the Grid alignment 
	      gridPane.setAlignment(Pos.CENTER); 
	      
	      
		gridPane.add(table,0,0);
		gridPane.add(create, 1, 0);
		gridPane.add(update, 2, 0);
		gridPane.add(delete, 3, 0);
		//Creating a scene object 
	      Scene scene = new Scene(gridPane); 
	      
	      //Setting title to the Stage 
	      stage.setTitle("Customer"); 
	         
	      //Adding scene to the stage 
	      stage.setScene(scene);  
	      
	      //Displaying the contents of the stage 
	      stage.show(); 		
	}
	public static void main(String[] args) {
	      launch(args);
	  }
	
}
