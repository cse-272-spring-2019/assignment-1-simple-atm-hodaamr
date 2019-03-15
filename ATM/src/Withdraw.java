import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Withdraw {
	 Stage stage;
     Menu menu;
     Scene scene;
     Account acc=new Account (0);
	public Withdraw (Stage stage) {
		this.stage=stage;
	}
	public void prepareScene () {
		Label withdrawLabel = new Label ("Enter Your Money Here: ");
		Label result= new Label();
		Label result2= new Label();
		TextField withdrawField = new TextField();
		Button enter = new Button("Enter");
		Button back = new Button ("Back");
		
		GridPane grid = new GridPane();
		grid.add(withdrawLabel, 0, 0);
		grid.add(withdrawField, 0, 1);
		grid.add(enter, 1, 1);
		grid.add(result, 0, 2);
		grid.add(result2, 0, 3);
		grid.add(back, 0, 4);
		
		grid.setVgap(7); 
	    grid.setHgap(7);
	    
	    withdrawLabel.setStyle("-fx-font: normal bold 18px 'serif' ;");
	    withdrawField.setStyle("-fx-font: normal bold 14px 'serif' ");
	    enter.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 16px 'serif';");
	    back.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 16px 'serif';");
	    result.setStyle("-fx-font: normal bold 14px 'serif'");
	    result2.setStyle("-fx-font: normal bold 14px 'serif'");
	    grid.setStyle("-fx-background-color: lightyellow;");
	    
	    GridPane.setHalignment(result, javafx.geometry.HPos.CENTER);
	    GridPane.setHalignment(result2, javafx.geometry.HPos.CENTER);
		
		enter.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				double w=Double.parseDouble(withdrawField.getText());
				
				if (acc.getBalance()>=w) {
					acc.withdraw(w);
					result.setText("Sucess!");
					result2.setText("Your New Balance is " +acc.getBalance() );
				}
				else {
					result.setText("Faild!");
				    result2.setText("Make Sure You Have Enough Balance " );
				}
			}
		});
        back.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(menu.getScene());
			}
		});
		scene = new Scene (grid,800,400);	
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
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
