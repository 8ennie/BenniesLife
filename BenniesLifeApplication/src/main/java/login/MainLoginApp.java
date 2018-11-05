package login;

import java.util.ArrayList;
import java.util.List;

import database.Person;
import databaseDAO.PersonDao;
import databaseDAO.PersonTypeDao;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import login.view.CreateDialogController;
import login.view.LoginController;

public class MainLoginApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Login");
		initRootLayout();
		showLoginView();	
	}

	public Stage getPrimaryStage() {
		return this.primaryStage;
	}
		
	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainLoginApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene =new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public boolean showCreateDialog(String routine, String pType) {
		try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainLoginApp.class.getResource("view/CreateDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();
		
	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Manage User/Person");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);
	        
	        CreateDialogController controller = loader.getController();
	        controller.setMainApp(this);
	        controller.loadPersons();
	        controller.setPersonType(new PersonTypeDao().getPersonType(pType));
	        controller.setUp(routine);
	        
	        dialogStage.showAndWait();
	       
	        return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public void showLoginView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainLoginApp.class.getResource("view/LoginDialog.fxml"));
			AnchorPane loginView = (AnchorPane) loader.load();
		
			rootLayout.setCenter(loginView);
			
			LoginController controller = loader.getController();
	        controller.setMainApp(this);
	       
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void Load() {
		launch();
	}
		
	private List<Person> personData = FXCollections.observableArrayList(); 
	
	private void refreshPerosnData() {
		List<Person> pList = new ArrayList<>();
		pList = new PersonDao().getAll();
		personData = pList;
	}
	
	public List<Person> getPeronData(){
		refreshPerosnData();
		return personData;
	}
	
}
