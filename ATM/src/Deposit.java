import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Deposit {
	Stage stage;
	Scene scene;
	Menu menu;
	Account acc=new Account(0);
	
	public Deposit (Stage stage) {
		this.stage=stage;
	}
	public void prepareScene () {
		Label depositeLabel = new Label ("Enter Your Money Here: ");
		Label result= new Label();
		Label result2= new Label();
		TextField depositeField = new TextField();
		Button enter = new Button("Enter");
		Button back = new Button ("Back");
		
		GridPane grid = new GridPane();
		grid.add(depositeLabel, 0, 0);
		grid.add(depositeField, 0, 1);
		grid.add(enter, 1, 1);
		grid.add(result, 0, 2);
		grid.add(result2, 0, 3);
		grid.add(back, 0, 4);
		
		
		grid.setVgap(7); 
	    grid.setHgap(7);
	    
	    depositeLabel.setStyle("-fx-font: normal bold 18px 'serif' ;");
	    depositeField.setStyle("-fx-font: normal bold 14px 'serif' ");
	    enter.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 14px 'serif';");
	    back.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 14px 'serif';");
	    grid.setStyle("-fx-background-color: lightyellow;");
	    result.setStyle("-fx-font: normal bold 14px 'serif'");
	    result2.setStyle("-fx-font: normal bold 14px 'serif'");
	    
	    GridPane.setHalignment(result, javafx.geometry.HPos.CENTER);
	    GridPane.setHalignment(result2, javafx.geometry.HPos.CENTER);
		
		enter.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				double d=Double.parseDouble(depositeField.getText());
				acc.Deposit(d);
				result.setText("Sucess!");
				result2.setText("Your New Balance is " +acc.getBalance() );
				
			}
		});
		back.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				stage.setScene(menu.getScene());
			}
		});
		scene = new Scene (grid,800,400);
	}
	public void setMenu (Menu menu) {
		this.menu=menu;
	}
	public Menu getMenu () {
		return menu;
	}
    public Scene getScene() {
		return scene;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	
}


