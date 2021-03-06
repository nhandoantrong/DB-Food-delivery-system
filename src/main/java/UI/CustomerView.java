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
import database.*;
public class CustomerView extends Application{
	GridPane gridPane=new GridPane();
	Button create=new Button("CREATE");
	Customer customer;
	ArrayList<OrderAttribute> list =new ArrayList<OrderAttribute>();
	TableView <OrderAttribute> table= new TableView<OrderAttribute>();
	
	
	
	public CustomerView(Customer customer)
	{
		this.customer=customer;
	}
	@Override
	public void start(Stage stage){
		TableColumn<OrderAttribute, Integer> id //
	    = new TableColumn <OrderAttribute, Integer> ("ID");
		id.setCellValueFactory(new PropertyValueFactory<OrderAttribute,Integer>("id"));
		TableColumn<OrderAttribute, String> sta //
	    = new TableColumn <OrderAttribute, String> ("Stage");
		sta.setCellValueFactory(new PropertyValueFactory<OrderAttribute,String>("stage"));
		
		
		
		table.getColumns().addAll(id,sta);
		list= customer.getOrders();
		ObservableList<OrderAttribute> data =FXCollections.observableArrayList(list);
		table.setItems(data);		
		
		
		create.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() { 
	          @Override 
	          public void handle(javafx.scene.input.MouseEvent e) 
	          {
	        	  OrderView view= new OrderView(customer);
	        	  Stage scene=new Stage();
	        	  view.start(stage);
	          }
		});
		gridPane.setMinSize(720, 720); 
	      gridPane.setPadding(new Insets(10, 10, 10, 10));  
	      
	      //Setting the vertical and horizontal gaps between the columns 
	      gridPane.setVgap(5); 
	      gridPane.setHgap(5);       
	      
	      //Setting the Grid alignment 
	      gridPane.setAlignment(Pos.CENTER); 
	      
	      
		gridPane.add(table,0,0);
		gridPane.add(create, 1, 0);
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
