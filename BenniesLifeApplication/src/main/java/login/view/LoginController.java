/**
 * Sample Skeleton for 'LoginDialog.fxml' Controller Class
 */

package login.view;

import java.net.URL;
import java.util.ResourceBundle;

import databaseDAO.UserDao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import login.MainLoginApp;
import login.PasswordHandler;
import prayer.MainPrayerApp;


public class LoginController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtUsernmae"
    private TextField txtUsernmae; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtPassword"
    private PasswordField pwfPassword; // Value injected by FXMLLoader

    @FXML // fx:id="btnLogin"
    private Button btnLogin; // Value injected by FXMLLoader

    @FXML // fx:id="btnCreateNewUser"
    private Button btnCreateNewUser; // Value injected by FXMLLoader

    @FXML // fx:id="btnForgotPassword"
    private Button btnForgotPassword; // Value injected by FXMLLoader

    @FXML // fx:id="btnExit"
    private Button btnExit; // Value injected by FXMLLoader

    private MainLoginApp mainLoginApp;
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert pwfPassword != null : "fx:id=\"pwfPassword\" was not injected: check your FXML file 'LoginDialog.fxml'.";
        assert txtUsernmae != null : "fx:id=\"txtUsernmae\" was not injected: check your FXML file 'LoginDialog.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'LoginDialog.fxml'.";
        assert btnCreateNewUser != null : "fx:id=\"btnCreateNewUser\" was not injected: check your FXML file 'LoginDialog.fxml'.";
        assert btnForgotPassword != null : "fx:id=\"btnForgotPassword\" was not injected: check your FXML file 'LoginDialog.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'LoginDialog.fxml'.";

    }
    
    @FXML
    private void exit() {
    	btnExit.getScene().getWindow().hide();
    }
    
    
    @FXML
    public void login() throws Exception {
		if(preCheck()) {
			String userPassword =  new UserDao().getPassword(txtUsernmae.getText());
			PasswordHandler passwordHandler = new PasswordHandler();
			if (userPassword != null && passwordHandler.checkPassword(pwfPassword.getText(),userPassword)){
				
				new Alert(AlertType.INFORMATION, "Login was Succesfull.").showAndWait();
				new MainPrayerApp().start(mainLoginApp.getPrimaryStage());
			} else {
				new Alert(AlertType.ERROR, "The Enterd Username/Password was wrong. Please enter the correct Username and Password.").showAndWait();
				pwfPassword.setText(null);
			}	
		}
	}
    
private boolean preCheck() {
		if ((txtUsernmae.getText().equals(""))) {
			new Alert(AlertType.ERROR, "Please enter a Username.").showAndWait();
			return false;
		}
		if ((pwfPassword.getText().equals(""))) {
			new Alert(AlertType.ERROR, "Please enter your Password.").showAndWait();
			return false;
		}
		
		
		return true;
	}
    
    public void setMainApp(MainLoginApp mainLoginApp) {
        this.mainLoginApp = mainLoginApp;
        // Add observable list data to the table
    }
    
    @FXML
    private void handleCreateNewUser() {
    	mainLoginApp.showCreateDialog("CreateUser","User");
    }
    
    @FXML
    private void handleForgotPassword() {
    	mainLoginApp.showCreateDialog("ForgotPassword","User");
    }
}
