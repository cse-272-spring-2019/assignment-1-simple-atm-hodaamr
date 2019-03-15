import javafx.application.Application;
import javafx.stage.Stage;

public class Mymain extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ATM");
		GUI gui=new GUI (primaryStage);
		Menu menu = new Menu (primaryStage);
		Withdraw with = new Withdraw(primaryStage);
		Deposit dep = new Deposit(primaryStage);
		gui.prepareScene();
		menu.prepareScene();
		with.prepareScene();
		dep.prepareScene();
		gui.setMenu(menu);
		menu.setGUI(gui);
		menu.setWith(with);
		menu.setDep(dep);
		with.setMenu(menu);
		dep.setMenu(menu);
		primaryStage.setScene(gui.getScene());
		primaryStage.show();	
	}
	
}
