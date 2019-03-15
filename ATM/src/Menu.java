import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Menu {
	Stage stage;
	Scene scene;
	GUI gui;
	Withdraw with;
	Deposit dep;
	Account acc=new Account (0);
	History his;
	static int i=1;
	int flag=0;
	public Menu (Stage stage) {
		this.stage=stage;
	}
	public void prepareScene()
	{
		Label welcome = new Label("Select Your Desecion");
		Label result = new Label();
		Label Deposite = new Label("1-Deposit");
		Label Withdraw = new Label("2-Withdraw");
		Label Balance = new Label("3-Current Balance");
		Label Previous = new Label("4-Previous");
		Label Next = new Label("5-Next");
		Button zero = new Button("0");
		Button one = new Button("1");
		Button two = new Button("2");
		Button three = new Button("3");
		Button four = new Button("4");
		Button five = new Button("5");
		Button six = new Button("6");
		Button seven = new Button("7");
		Button eight = new Button("8");
		Button nine = new Button("9");
		
		GridPane grid = new GridPane();
		grid.add(welcome,2,0);
		grid.add(Deposite,2,1);
		grid.add(Withdraw,2,2);
		grid.add(Balance,2,3);
		grid.add(result, 2, 5);
		grid.add(Previous,1,4);
		grid.add(Next ,3,4);
		grid.add(zero ,6,4);
		grid.add(one ,5,1);
		grid.add(two ,6,1);
		grid.add(three ,7,1);
		grid.add(four ,5,2);
		grid.add(five ,6,2);
		grid.add(six ,7,2);
		grid.add(seven ,5,3);
		grid.add(eight ,6,3);
		grid.add(nine ,7,3);
		
		GridPane.setHalignment(welcome, javafx.geometry.HPos.CENTER);
		GridPane.setHalignment(Deposite, javafx.geometry.HPos.CENTER);
		GridPane.setHalignment(Withdraw, javafx.geometry.HPos.CENTER);
		GridPane.setHalignment(Balance, javafx.geometry.HPos.CENTER);
		GridPane.setHalignment(Previous, javafx.geometry.HPos.CENTER);
		GridPane.setHalignment(Next, javafx.geometry.HPos.CENTER);
		GridPane.setHalignment(result, javafx.geometry.HPos.CENTER);
		
		grid.setVgap(7); 
	    grid.setHgap(7);
	    
	    Deposite.setStyle("-fx-text-fill: lightcoral; -fx-font: normal bold 18px 'serif';");
	    Withdraw.setStyle("-fx-text-fill: lightcoral; -fx-font: normal bold 18px 'serif';");
	    Balance.setStyle("-fx-text-fill: lightcoral; -fx-font: normal bold 18px 'serif';");
	    Previous.setStyle("-fx-text-fill: lightcoral; -fx-font: normal bold 18px 'serif';");
	    Next.setStyle("-fx-text-fill: lightcoral; -fx-font: normal bold 18px 'serif';");
	    welcome.setStyle("-fx-font: normal bold 20px 'serif' ;");
	    result.setStyle("-fx-font: normal bold 16px 'serif' ;");
	    zero.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 16px 'serif';");
	    one.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 16px 'serif';");
	    two.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 16px 'serif';");
	    three.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 16px 'serif';");
	    four.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 16px 'serif';");
	    five.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 16px 'serif';");
	    six.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 16px 'serif';");
	    seven.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 16px 'serif';");
	    eight.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 16px 'serif';");
	    nine.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 16px 'serif';");
	    grid.setStyle("-fx-background-color: lightyellow;");
	    
		one.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(dep.getScene());
				
			}
		});
		two.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(with.getScene());
				
			}
			
		});
		
		three.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				acc.balanceInquiry();
				result.setText("Your Current Balance is " +acc.getBalance());
				
			}
		});
		four.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if (i>5) {
					result.setText("No More Transactions");
				}
				else if (i<=5 && !(History.getHistory().size()-i<0)) {
					result.setText(History.getHistory().get(History.getHistory().size()-i));
				    i++;
			    }
				else if(History.getHistory().isEmpty())
					result.setText("No More Transactions");
				else if (History.getHistory().size()-i<0)
					result.setText("No More Transactions");
			}
		});
		
		five.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if (flag==0) {
					i--;
					flag=1;
				}
				if (History.getHistory().size()-i==History.getHistory().size()-1) {
					result.setText("No More Transactions");
				}
				else if (History.getHistory().size()-i<History.getHistory().size()-1){
					i--;
					result.setText(History.getHistory().get(History.getHistory().size()-i));
				}
				else if(History.getHistory().isEmpty())
					result.setText("No More Transactions");
				else if (History.getHistory().size()-i<0)
					result.setText("No More Transactions");
				
			}
		});
	scene = new Scene (grid,800,400);
	}
	public Scene getScene () {
	    return scene;
	}
	public void setGUI(GUI gui) {
	    this.gui=gui;
	}
	public void setWith(Withdraw with) {
		this.with = with;
	}
	public Withdraw getWithdraw() {
		return with;
	}
	public Deposit getDep() {
		return dep;
	}
	public void setDep(Deposit dep) {
		this.dep = dep;
	}
	public static int getI() {
		i=1;
		return i;
	}
    
}
