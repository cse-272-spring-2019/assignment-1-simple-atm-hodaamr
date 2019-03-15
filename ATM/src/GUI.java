import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI {
	Stage stage;
	Scene scene;
	Authentication authentication = new Authentication();
	Menu menu;
	
	public GUI (Stage stage) {
		this.stage=stage;
	}
	public void prepareScene () {
		Label cardnumberLabel= new Label("Card Number: ");
		PasswordField cardnumberField = new PasswordField();
		Button submit = new Button("Submit");
		Label validationLabel = new Label();
		
		GridPane grid = new GridPane();
		grid.add(cardnumberLabel, 0, 0);
		grid.add(cardnumberField, 1, 0);
		grid.add(submit, 1, 1);
		grid.add(validationLabel, 1,2);
		
		grid.setVgap(7); 
	    grid.setHgap(7);
	    
	    cardnumberLabel.setStyle("-fx-font: normal bold 18px 'serif' ");
	    cardnumberField.setStyle("-fx-font: normal bold 14px 'serif' ");
	    grid.setStyle("-fx-background-color: lightyellow;");
	    submit.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 16px 'serif';");
	    validationLabel.setStyle("-fx-font: normal bold 14px 'serif' ;");
		
		submit.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String cardnum=cardnumberField.getText();
				
				if (authentication.validate(cardnum)) {
					validationLabel.setText("Welcome !");
					stage.setScene(menu.getScene());
				}
				else 
					validationLabel.setText("Wrong Card Number");
			}
		});
		
		scene=new Scene (grid,800,400);
	}
	public Scene getScene() {
		return this.scene;
	}
	public void setMenu (Menu menu) {
		this.menu=menu;
	}

}
