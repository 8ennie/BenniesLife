
/**
 * Sample Skeleton for 'CreateDialog.fxml' Controller Class
 */

package login.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import database.Person;
import database.PersonType;
import database.User;
import database.UserCategory;
import databaseDAO.PersonDao;
import databaseDAO.PersonTypeDao;
import databaseDAO.UserCategoryDao;
import databaseDAO.UserDao;
import login.PasswordHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import login.MainLoginApp;


public class CreateDialogController {
	
	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tpaneCreate"
    private TabPane tpaneCreate; // Value injected by FXMLLoader

    @FXML // fx:id="tabCreateUser"
    private Tab tabCreateUser; // Value injected by FXMLLoader

    @FXML // fx:id="cbPerson"
    private ComboBox<String> cbPerson; // Value injected by FXMLLoader

    @FXML // fx:id="btnGoToCreatePerson"
    private Button btnGoToCreatePerson; // Value injected by FXMLLoader

    @FXML // fx:id="txtUsername"
    private TextField txtUsername; // Value injected by FXMLLoader

    @FXML // fx:id="btnCeckUsername"
    private Button btnCeckUsername; // Value injected by FXMLLoader

    @FXML // fx:id="cbShowPassword"
    private CheckBox cbShowPassword; // Value injected by FXMLLoader

    @FXML // fx:id="pwPassword1"
    private PasswordField pwPassword1; // Value injected by FXMLLoader

    @FXML // fx:id="pwPassword2"
    private PasswordField pwPassword2; // Value injected by FXMLLoader

    @FXML // fx:id="lblShowPassword"
    private Label lblShowPassword; // Value injected by FXMLLoader

    @FXML // fx:id="btnCreateUser"
    private Button btnCreateUser; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnAddPerson"
    private Button btnAddPerson; // Value injected by FXMLLoader

    @FXML // fx:id="btnUExit"
    private Button btnUExit; // Value injected by FXMLLoader

    @FXML // fx:id="tabCreatePerson"
    private Tab tabCreatePerson; // Value injected by FXMLLoader

    @FXML // fx:id="txtFirstName"
    private TextField txtFirstName; // Value injected by FXMLLoader

    @FXML // fx:id="txtLastName"
    private TextField txtLastName; // Value injected by FXMLLoader

    @FXML // fx:id="datePickerBirthday"
    private DatePicker datePickerBirthday; // Value injected by FXMLLoader

    @FXML // fx:id="txtemailadresse"
    private TextField txtemailadresse; // Value injected by FXMLLoader

    @FXML // fx:id="txtPhoneNumber"
    private TextField txtPhoneNumber; // Value injected by FXMLLoader

    @FXML // fx:id="rbMale"
    private RadioButton rbMale; // Value injected by FXMLLoader

    @FXML // fx:id="rbFemale"
    private RadioButton rbFemale; // Value injected by FXMLLoader

    @FXML // fx:id="rbOther"
    private RadioButton rbOther; // Value injected by FXMLLoader

    @FXML // fx:id="btnCreatePerson"
    private Button btnCreatePerson; // Value injected by FXMLLoader

    @FXML // fx:id="btnPGoBack"
    private Button btnPGoBack; // Value injected by FXMLLoader

    @FXML // fx:id="btnPExit"
    private Button btnPExit; // Value injected by FXMLLoader

    @FXML // fx:id="tabForgotPassword"
    private Tab tabForgotPassword; // Value injected by FXMLLoader

    @FXML // fx:id="txtFPUsername"
    private TextField txtFPUsername; // Value injected by FXMLLoader

    @FXML // fx:id="txtFPFirstName"
    private TextField txtFPFirstName; // Value injected by FXMLLoader

    @FXML // fx:id="txtFPLastName"
    private TextField txtFPLastName; // Value injected by FXMLLoader

    @FXML // fx:id="pdFPPassword1"
    private PasswordField pdFPPassword1; // Value injected by FXMLLoader

    @FXML // fx:id="pdFPPassword2"
    private PasswordField pdFPPassword2; // Value injected by FXMLLoader

    @FXML // fx:id="ceckBNoP"
    private CheckBox ceckBNoP; // Value injected by FXMLLoader

    @FXML // fx:id="btnResetPassword"
    private Button btnResetPassword; // Value injected by FXMLLoader

    private MainLoginApp mainLoginApp;
    
    private ToggleGroup genderGroup = new ToggleGroup();
    
    private PersonType personType = new PersonTypeDao().getPersonType("User");
    UserDao userDao = new UserDao();
    PersonDao personDao = new PersonDao();
	UserCategoryDao userCategoryDao = new UserCategoryDao();
	UserCategory userCategory = userCategoryDao.findById(3);//Temporary
	PasswordHandler passwordHandler = new PasswordHandler();
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert tpaneCreate != null : "fx:id=\"tpaneCreate\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert tabCreateUser != null : "fx:id=\"tabCreateUser\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert cbPerson != null : "fx:id=\"cbPerson\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert btnGoToCreatePerson != null : "fx:id=\"btnGoToCreatePerson\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert btnCeckUsername != null : "fx:id=\"btnCeckUsername\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert cbShowPassword != null : "fx:id=\"cbShowPassword\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert pwPassword1 != null : "fx:id=\"pwPassword1\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert pwPassword2 != null : "fx:id=\"pwPassword2\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert lblShowPassword != null : "fx:id=\"lblShowPassword\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert btnCreateUser != null : "fx:id=\"btnCreateUser\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert btnAddPerson != null : "fx:id=\"btnAddPerson\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert btnUExit != null : "fx:id=\"btnUExit\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert tabCreatePerson != null : "fx:id=\"tabCreatePerson\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert txtFirstName != null : "fx:id=\"txtFirstName\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert txtLastName != null : "fx:id=\"txtLastName\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert datePickerBirthday != null : "fx:id=\"datePickerBirthday\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert txtemailadresse != null : "fx:id=\"txtemailadresse\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert txtPhoneNumber != null : "fx:id=\"txtPhoneNumber\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert rbMale != null : "fx:id=\"rbMale\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert rbFemale != null : "fx:id=\"rbFemale\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert rbOther != null : "fx:id=\"rbOther\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert btnCreatePerson != null : "fx:id=\"btnCreatePerson\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert btnPGoBack != null : "fx:id=\"btnPGoBack\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert btnPExit != null : "fx:id=\"btnPExit\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert tabForgotPassword != null : "fx:id=\"tabForgotPassword\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert txtFPUsername != null : "fx:id=\"txtFPUsername\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert txtFPFirstName != null : "fx:id=\"txtFPFirstName\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert txtFPLastName != null : "fx:id=\"txtFPLastName\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert pdFPPassword1 != null : "fx:id=\"pdFPPassword1\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert pdFPPassword2 != null : "fx:id=\"pdFPPassword2\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert ceckBNoP != null : "fx:id=\"ceckBNoP\" was not injected: check your FXML file 'CreateDialog.fxml'.";
        assert btnResetPassword != null : "fx:id=\"btnResetPassword\" was not injected: check your FXML file 'CreateDialog.fxml'.";

       
        
       rbFemale.setToggleGroup(genderGroup);
       rbOther.setToggleGroup(genderGroup);
       rbMale.setToggleGroup(genderGroup);
       
      
    }
    
    public void setUp(String routine) {
    	switch (routine) {
		case "ForgotPassword":
			tabCreatePerson.setDisable(true);
			tabCreateUser.setDisable(true);
			tpaneCreate.getSelectionModel().select(tabForgotPassword);
			break;
		case "CreateUser":
			tabCreatePerson.setDisable(true);
		    tabForgotPassword.setDisable(true);
		    tpaneCreate.getSelectionModel().select(tabCreateUser);
			break;
		case "CreatePerson":
			tabForgotPassword.setDisable(true);
			tabCreateUser.setDisable(true);
			tpaneCreate.getSelectionModel().select(tabCreatePerson);
			break;
		default:
			break;
		}
    }
    
    @FXML
    public void loadPersons() {
    	cbPerson.getItems().clear();
    	List<Person> pList = mainLoginApp.getPeronData();
    	for (Person person : pList) {
			cbPerson.getItems().add(person.getLastname() + ", " + person.getFirstname());
		}
    }
    
    public void setMainApp(MainLoginApp mainLoginApp) {
        this.mainLoginApp = mainLoginApp;
    }
    
    
    
    //For the Create New USER tab
    
    @FXML
    private void exit() {
    	btnUExit.getScene().getWindow().hide();
    }
    
    @FXML
    public void checkUsername() {
    	if (userDao.findByUsername(txtUsername.getText())!=null)  {
			new Alert(AlertType.INFORMATION, "Username already Exists! Choose a different one.").showAndWait();
		}else {
			new Alert(AlertType.INFORMATION, "The Username is Valied!").showAndWait();
		}   	
    }
    
    @FXML
    private void createUser() {
		if(preCheckUser()) {
			User newUser = new User();
			newUser.setUsername(txtUsername.getText());
			newUser.setPassword(passwordHandler.getPassword(pwPassword1.getText()));
			newUser.setUserCategory(userCategory);
			userDao.persist(newUser);
			if(cbPerson.getValue() != null) {
				Person person = getPerson();
				newUser.setPerson(person);
				userDao.merge(newUser);
			}
			new Alert(AlertType.INFORMATION, "Username was created succelsfully").showAndWait();
			txtUsername.setText(null);
			cbPerson.setValue(null);
			pwPassword1.setText(null);
			pwPassword2.setText(null);
			exit();
		}
	}
    
    private boolean preCheckUser() {
		if ((txtUsername.getText().equals(""))) {
			new Alert(AlertType.ERROR, "Please Enter a Username").showAndWait();
			return false;
		}
		if ((pwPassword1.getText().equals("") || pwPassword2.getText().equals(""))) {
			new Alert(AlertType.ERROR, "Please Enter both Passwords").showAndWait();
			return false;
		}
		if (!(pwPassword1.getText().equals(pwPassword2.getText()))) {
			new Alert(AlertType.ERROR, "Passwords don't match").showAndWait();
			pwPassword2.setText(null);
			pwPassword2.setText(null);
			return false;
		}
		if (userDao.findByUsername(txtUsername.getText())!=null)  {
			new Alert(AlertType.ERROR, "Username already Exists! Pleas Chooes a new Username").showAndWait();
			return false;
		}
		return true;
	}
    
    @FXML
    private void goToCreatePerson() {
    	tabCreatePerson.setDisable(false);
    	tpaneCreate.getSelectionModel().select(tabCreatePerson);
    }
    
    @FXML
    private void showPasswod() {
    	if(cbShowPassword.isSelected()) {
    		lblShowPassword.setVisible(true);
    		lblShowPassword.setText(pwPassword1.getText());
    	}else{
    		lblShowPassword.setVisible(false);
    		lblShowPassword.setText(null);
    	}
    }
    
    //For the Create PERSON tab
    
    @FXML
    private void back() {
    	tpaneCreate.getSelectionModel().select(tabCreateUser);
    }
    
    private Person getPerson() {
    	String[]  splitName = cbPerson.getValue().split(", ");
		List<Person> lPerson = personDao.findByLastName(splitName[0]);
		for (Person person : lPerson) {
			if(person.getFirstname().equals(splitName[1])) {
				return person;
			} else {
				
			}
		}
		return null;
    }
    
    @FXML
    public void addPerson() {
    	try {
    		User user = userDao.findByUsername(txtUsername.getText());
			PasswordHandler passwordHandler = new PasswordHandler();
			if (user != null && passwordHandler.checkPassword(pwPassword1.getText(),user.getPassword()) && cbPerson.getValue() != null){
				Person person = getPerson();
				user.setPerson(person);
				userDao.merge(user);
				new Alert(AlertType.INFORMATION, "Person Addes Successfully!").showAndWait();
			} else {
				new Alert(AlertType.ERROR, "The Enterd Username/Password was wrong. Please enter the correct Username and Password and add a Person.").showAndWait();
			}	
		} catch (Exception e) {
			// TODO: handle exception
			new Alert(AlertType.ERROR, "An Error ocured").showAndWait();
		}
    	
    }
    
    public void setPersonType(PersonType personType) {
		this.personType = personType;
	}
    
    @FXML
    private void createPerson() {
    	try {
			if(preCheckPerson()) {
	    		Person newPerson = new Person();
	    		newPerson.setFirstname(txtFirstName.getText());
	    		newPerson.setLastname(txtLastName.getText());
	    		newPerson.setBirthday(java.sql.Date.valueOf(datePickerBirthday.getValue()));
	    		newPerson.addPersonType(personType);
	    		personType.addPerson(newPerson);
	    		if(!(txtemailadresse.getText().equals(""))) {
	    			newPerson.setEmailadress(txtemailadresse.getText());
	    		}
	    		if(!(txtPhoneNumber.getText().equals(""))) {
	    			newPerson.setPhoneNumber(txtPhoneNumber.getText());;
	    		}
	    		if(genderGroup.getSelectedToggle() == rbMale) {
	    			newPerson.setGender("Male");
	    		}else if(genderGroup.getSelectedToggle() == rbFemale) {
	    			newPerson.setGender("Female");
	    		}else{
	    			newPerson.setGender("Other");
	    		}
	    		personDao.persist(newPerson);
	    		loadPersons();
	    		cbPerson.getSelectionModel().select(newPerson.getLastname() + ", " + newPerson.getFirstname());
	    		new Alert(AlertType.INFORMATION, "Person Added Successfully!").showAndWait();
				tpaneCreate.getSelectionModel().select(tabCreateUser);
				txtFirstName.setText("");
				txtLastName.setText("");
				txtPhoneNumber.setText("");
				txtemailadresse.setText("");
				datePickerBirthday.setValue(null);
				genderGroup.getSelectedToggle().setSelected(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			new Alert(AlertType.ERROR, "Somthing whent Wrong!").showAndWait();
    	
    	}
    	
    }
    
    private boolean preCheckPerson() {
    	if(txtFirstName.getText().equals("")) {
    		new Alert(AlertType.ERROR, "Please Insert a First Name").showAndWait();
    		return false;
    	}
    	if(txtLastName.getText().equals("")) {
    		new Alert(AlertType.ERROR, "Please Insert a Last Name").showAndWait();
    		return false;
    	}
    	if(datePickerBirthday.getValue() == null) {
    		new Alert(AlertType.ERROR, "Please Enter Your Birthday").showAndWait();
    		return false;
    	}
    	if(genderGroup.getSelectedToggle() == null) {
    		new Alert(AlertType.ERROR, "Please Choose a Gender").showAndWait();
    		return false;
    	}
    	return true;
    }
    
    // For Forgot Password tab

    @FXML
    private void resetPassword() {
    	if(preCheckFP()) {
    		User user = userDao.findByUsername(txtFPUsername.getText());
    		user.setPassword(passwordHandler.getPassword(pdFPPassword1.getText()));
    		userDao.merge(user);
    		
    		exit();
    	}
    }
    
    private boolean preCheckFP() {
    	if ((txtFPUsername.getText().equals(""))) {
			new Alert(AlertType.ERROR, "Please enter a Username.").showAndWait();
			return false;
		}
    	if(userDao.findByUsername(txtFPUsername.getText()) == null) {
    		new Alert(AlertType.ERROR, "Wrong Username.").showAndWait();
			return false;
    	}
		if ((pdFPPassword1.getText().equals("")) && (pdFPPassword2.getText().equals(""))) {
			new Alert(AlertType.ERROR, "Please enter both Password.").showAndWait();
			return false;
		}
		if (!(pdFPPassword1.getText().equals(pdFPPassword2.getText()))) {
			new Alert(AlertType.ERROR, "The Passwords don't match.").showAndWait();
			return false;
		}
		return true;
    }

}
