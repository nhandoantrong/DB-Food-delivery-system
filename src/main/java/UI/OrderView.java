package UI;
import java.util.*;
import database.Database;
import database.Menu;
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
    Button buttonMenu[]=new Button[6];
    
    GridPane buttonSet =new GridPane();
    Button confirm= new Button("Confirm");
    ObservableList<String> food = FXCollections.observableArrayList(); 
    ListView<String> foodView = new ListView<String>(food); 
    GridPane gridPane = new GridPane();    
    Button nextMenu= new Button("NEXT");
    Button backMenu= new Button("BACK");
    
    Button nextDish= new Button("NEXT");
    Button backDish= new Button("BACK");
    
    ArrayList<Menu> menuList= new ArrayList<Menu>();
    ArrayList<String> menuButton=new ArrayList<String>();
    
    
    Button buttonDish[]=new Button[6];
    GridPane dishSet = new GridPane();
    int menuPage=1;
    private class Quantity extends Application
    {

    	Text quantityLable =new Text("Quantity");
    	TextField quantityText= new TextField();
    	String quantity;
    	Boolean close=false;
    	String dishQuantity;
    	public Quantity(String name)
    	{
    		dishQuantity=name;
    	}
    	@Override
    	public void start(Stage stage)  {
    		
    		GridPane gridPane2= new GridPane();
    		gridPane2.setVgap(5);
    		gridPane2.add(quantityLable, 0, 0);
    		gridPane2.add(quantityText, 0, 1);
    		
    		
    		Scene scene=new Scene(gridPane2);
    		stage.setTitle("Quantity");
    		stage.setScene(scene);
    		Button confirm= new Button("Confirm");
    		confirm.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() { 
              @Override 
              public void handle(javafx.scene.input.MouseEvent e) { 
            	  quantity=quantityText.getText();
            	  System.out.println(quantity);
            	  stage.close();
            		  dishQuantity+= "\t\t"+ quantity;
            		  System.out.println(dishQuantity);
            		  food.add(dishQuantity);
     	
              } 
           });
    		gridPane2.add(confirm, 0, 2);
    		stage.show();

    	}
    }
    
	private class DishHandle implements EventHandler<javafx.scene.input.MouseEvent>
    {

	    String dishQuantity;
	    Button name;
		public DishHandle(Button name)
		{
			this.name=name;
		}
		@Override
		public void handle(MouseEvent arg0) {
			dishQuantity=name.getText();
			Quantity quantity = new Quantity(dishQuantity);
	         Stage scene= new Stage();
	         quantity.start(scene);
	         }
		
    }
	
	private class NextMenu implements EventHandler<javafx.scene.input.MouseEvent>
    {

		
		@Override
		public void handle(MouseEvent arg0) {
			backMenu.setDisable(false);
			System.out.println(menuPage);
			if (menuButton.size()-menuPage>0)
				menuPage+=6;
			int i;
			for (i=0;i<6;i++)
		      {
					if (menuPage+i <=menuButton.size())
					{
						buttonMenu[i].setText(menuButton.get(menuPage+i-1));
					}
					else break;
		      }
			while (i<6)
			{
				buttonMenu[i].setText("");
				buttonMenu[i].setDisable(true);
				nextMenu.setDisable(true);
				i++;
			}
			
		}
		
    }
	
	
	private class BackMenu implements EventHandler<javafx.scene.input.MouseEvent>
    {

		
		@Override
		public void handle(MouseEvent arg0) {
			nextMenu.setDisable(false);
			System.out.println(menuPage);
			if (menuPage!=1)
				menuPage-=6;
			int i;
			for (i=0;i<6;i++)
		      {
					if (menuPage+i <=menuButton.size())
					{
						buttonMenu[i].setText(menuButton.get(menuPage+i-1));
						buttonMenu[i].setDisable(false);
					}
					else break;
		      }
			while (i<6)
			{
				buttonMenu[i].setText("");
				buttonMenu[i].setDisable(true);
				nextMenu.setDisable(true);
				i++;
			}
			if (menuPage==1)
			{
				backMenu.setDisable(true);
			}
		}
		
    }
	@Override 
   public void start(Stage stage) {    
      // 
      // menu list
		//----------------------------------------
      menuList=Database.getInstance().getMenus();
      for (int i=0;i<menuList.size();i++)
      {
    	  menuButton.add(String.valueOf(i+1));
      }
      System.out.println(menuButton.size());
		if(menuButton.size()<=6)
		{
			backMenu.setDisable(true);
			nextMenu.setDisable(true);
			for (int i=0;i<6;i++)
		      {
		    	  if (i<menuButton.size())
		    		  buttonMenu[i]=new Button(menuButton.get(i));
		    	  else
		    		  {
		    		  	buttonMenu[i]=new Button("");	
		    		  	buttonMenu[i].setDisable(true);
		    		  }
		    	  buttonMenu[i].setMinSize(100, 100);

		      }
		}
		else
		{
			for (int i=0;i<6;i++)
			{
				buttonMenu[i]=new Button(menuButton.get(i));
				buttonMenu[i].setMaxSize(1000, 1000);
				buttonMenu[i].setMinSize(100, 100);
			}
			nextMenu.setOnMouseClicked(new NextMenu());
			backMenu.setOnMouseClicked(new BackMenu());
		}
		nextMenu.setMinSize(100, 100);
		backMenu.setMinSize(100, 100);
		buttonSet.add(nextMenu, 1, 4);
		buttonSet.add(backMenu, 0, 4);
		
		buttonSet.setVgap(5);
		buttonSet.setHgap(5);
		for (int i=0;i<6;i++)
		{
			buttonSet.add(buttonMenu[i], i%2, i/2);
		}
		
		//end menu list
     //--------------------------------------------------------------------
		
		
		
		
		
		// Dish list
		//-------------------------------------
		
		for (int i=0;i<6;i++)
		{
			buttonDish[i]=new Button();
			dishSet.add(buttonDish[i],i/2 , i%2);
			buttonDish[i].setMinSize(100, 100);
			buttonDish[i].setDisable(true);
			buttonDish[i].setOnMouseClicked(new DishHandle(buttonDish[i]));
		}
		nextDish.setMinSize(100, 100);
		backDish.setMinSize(100, 100);
		nextDish.setDisable(true);
		backDish.setDisable(true);
		dishSet.add(nextDish,3,0);
		dishSet.add(backDish, 3, 1);
		dishSet.setVgap(5);
		dishSet.setHgap(5);
		
		//end Dish list
		//-------------------------------------------------
      
      //Setting size for the pane 
      gridPane.setMinSize(720, 720); 
   
      //Setting the padding    
      gridPane.setPadding(new Insets(10, 10, 10, 10));  
      
      //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);       
      	
      //Setting the Grid alignment 
      gridPane.setAlignment(Pos.CENTER); 
       
      //Arranging all the nodes in the grid 
      
      gridPane.add(foodView, 0, 1);
      gridPane.add(menuLabel, 1, 0);
      gridPane.add(buttonSet, 1, 1);
      gridPane.add(dishSet, 0, 2,2,2);
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