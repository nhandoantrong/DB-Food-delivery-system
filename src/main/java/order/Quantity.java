package order;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Quantity extends Application
{

	Text quantityLable =new Text("Quantity");
	TextField quantityText= new TextField();
	@Override
	public void start(Stage stage)  {
		
		GridPane gridPane= new GridPane();
		gridPane.setVgap(5);
		gridPane.add(quantityLable, 0, 0);
		gridPane.add(quantityText, 0, 1);
		Scene scene=new Scene(gridPane);
		stage.setTitle("Quantity");
		stage.setScene(scene);
		stage.show();
	}
}