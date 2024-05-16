package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class CalculatorApplication extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		//Load the FX file
		Parent root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
		

		primaryStage.setTitle("Calculator");
		primaryStage.setScene(new Scene(root, 220, 260));
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		//Launch
		launch(args);
	}
}
