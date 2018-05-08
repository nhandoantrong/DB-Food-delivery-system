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
public class MaterialsView extends Application {
	
	
	
	
	GridPane gridPane=new GridPane();
	Button create=new Button("CREATE");
	Button update=new Button("UPDATE");
	Button delete= new Button("DELETE");
	Button add=new Button("ADD ORDER");
	ArrayList<Material> list =new ArrayList<Material>();
	TableView <Material> table= new TableView<Material>();
	
	private class AddMaterial extends Application
	{
		GridPane grid= new GridPane();
		Button confirm =new Button("CONFIRM");
		Text name = new Text("Name");
		TextField nameField= new TextField();
		Text unit= new Text("Unit Price");
		TextField unitField= new TextField();
		
		@Override
		public void start(Stage stage) {
			confirm.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() { 
	          	String materialname;
	          	Float price;
				@Override 
				public void handle(javafx.scene.input.MouseEvent e) { 
					materialname=nameField.getText();
					price=Float.valueOf(unitField.getText());
					Database.getInstance().createMaterial(new Material(null,materialname,price));
					stage.close();
					list=Database.getInstance().getMaterials();
					ObservableList<Material> data =FXCollections.observableArrayList(list);
					table.setItems(data);
				}
			});   
			
			grid.setHgap(5);
			grid.setVgap(5);
			grid.setAlignment(Pos.CENTER);
			
			grid.add(name,0,0);
			grid.add(nameField, 1, 0);
			grid.add(unit, 0, 1);
			grid.add(unitField, 1, 1);
			grid.add(confirm, 1, 2);
			 Scene scene = new Scene(grid); 
		      
		      //Setting title to the Stage 
		      stage.setTitle("Material"); 
		         
		      //Adding scene to the stage 
		      stage.setScene(scene);  
		      
		      //Displaying the contents of the stage 
		      stage.show(); 
		}
		
	}
	
	private class UpdateMaterial extends Application
	{
		Material current=table.getSelectionModel().getSelectedItem();
		GridPane grid= new GridPane();
		Button confirm =new Button("CONFIRM");
		Text name = new Text("Name");
		TextField nameField= new TextField(current.getName());
		Text unit= new Text("Unit Price");
		TextField unitField= new TextField(String.valueOf(current.getUnitPrice()));
		
		@Override
		public void start(Stage stage) {
			confirm.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() { 
	          	String materialname;
	          	Float price;
				@Override 
				public void handle(javafx.scene.input.MouseEvent e) { 
					materialname=nameField.getText();
					price=Float.valueOf(unitField.getText());
					current.setName(materialname);
					current.setUnitPrice(price);
					Database.getInstance().updateMaterial(current);
					stage.close();
					list=Database.getInstance().getMaterials();
					ObservableList<Material> data =FXCollections.observableArrayList(list);
					table.setItems(data);
				}
			});   
			
			grid.setHgap(5);
			grid.setVgap(5);
			grid.setAlignment(Pos.CENTER);
			
			grid.add(name,0,0);
			grid.add(nameField, 1, 0);
			grid.add(unit, 0, 1);
			grid.add(unitField, 1, 1);
			grid.add(confirm, 1, 2);
			 Scene scene = new Scene(grid); 
		      
		      //Setting title to the Stage 
		      stage.setTitle("Material"); 
		         
		      //Adding scene to the stage 
		      stage.setScene(scene);  
		      
		      //Displaying the contents of the stage 
		      stage.show(); 
		}
		
	}
	
	
	
	@Override
	public void start(Stage stage)  {
		
		TableColumn<Material, Integer> id //
	    = new TableColumn <Material, Integer> ("ID");
		id.setCellValueFactory(new PropertyValueFactory<Material,Integer>("id"));
		
		TableColumn<Material, String> name //
	    = new TableColumn <Material, String> ("Name");
		name.setCellValueFactory(new PropertyValueFactory<Material,String>("Name"));

		TableColumn<Material, Float> unitPrice //
	    = new TableColumn <Material, Float> ("unitPrice");
		unitPrice.setCellValueFactory(new PropertyValueFactory<Material, Float>("unitPrice"));

		
		
		
		create.setMinSize(100, 100);
		update.setMinSize(100,100 );
		delete.setMinSize(100, 100);
		table.getColumns().addAll(id, name, unitPrice);
		table.setEditable(true);
		
		System.out.println(list.size());
		
		
		
		create.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() { 
	          	
				@Override 
				public void handle(javafx.scene.input.MouseEvent e) { 
					AddMaterial addMate= new AddMaterial();
					Stage scene= new Stage();
					addMate.start(scene);
				} 
	    });   
		update.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() { 
	          @Override 
	          public void handle(javafx.scene.input.MouseEvent e) { 
	        	  UpdateMaterial upMate= new UpdateMaterial();
					Stage scene= new Stage();
					upMate.start(scene);
	          } 
	       });   
		delete.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() { 
	          @Override 
	          public void handle(javafx.scene.input.MouseEvent e) { 
	        	  
	        	  Database.getInstance().deleteMaterial(table.getSelectionModel().getSelectedItem());
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
	      stage.setTitle("Material list"); 
	         
	      //Adding scene to the stage 
	      stage.setScene(scene);  
	      
	      //Displaying the contents of the stage 
	      stage.show(); 		
	}
	public static void main(String[] args) {
	      launch(args);
	  }
	
}
