/**
 * 
 */
package prayer.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import database.Person;
import database.Prayer;
import databaseDAO.PersonDao;
import databaseDAO.PrayerDao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import login.MainLoginApp;
import prayer.MainPrayerApp;

/**
 * @author bcwie
 *
 */
public class ManagePrayerController {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="cbAnswered"
	private CheckBox cbAnswered; // Value injected by FXMLLoader

	@FXML // fx:id="txtNotes"
	private TextArea txtNotes; // Value injected by FXMLLoader

	@FXML // fx:id="txtPrayerDescription"
	private TextArea txtPrayerDescription; // Value injected by FXMLLoader

	@FXML // fx:id="txtPrayerTopic"
	private TextField txtPrayerTopic; // Value injected by FXMLLoader

	@FXML // fx:id="dpDate"
	private DatePicker dpDate; // Value injected by FXMLLoader

	@FXML // fx:id="cbPersons"
	private ComboBox<String> cbPersons; // Value injected by FXMLLoader

	@FXML // fx:id="lblAddedPersons"
	private Label lblAddedPersons; // Value injected by FXMLLoader

	@FXML // fx:id="spImportance"
	private Spinner<Integer> spImportance; // Value injected by FXMLLoader

	private MainPrayerApp mainPrayerApp;

	private List<Person> pList = new ArrayList<>();

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert cbAnswered != null : "fx:id=\"cbAnswered\" was not injected: check your FXML file 'ManagePrayerView.fxml'.";
		assert txtNotes != null : "fx:id=\"txtNotes\" was not injected: check your FXML file 'ManagePrayerView.fxml'.";
		assert txtPrayerDescription != null : "fx:id=\"txtPrayerDescription\" was not injected: check your FXML file 'ManagePrayerView.fxml'.";
		assert txtPrayerTopic != null : "fx:id=\"txtPrayerTopic\" was not injected: check your FXML file 'ManagePrayerView.fxml'.";
		assert dpDate != null : "fx:id=\"dpDate\" was not injected: check your FXML file 'ManagePrayerView.fxml'.";
		assert cbPersons != null : "fx:id=\"cbPersons\" was not injected: check your FXML file 'ManagePrayerView.fxml'.";
		assert lblAddedPersons != null : "fx:id=\"lblAddedPersons\" was not injected: check your FXML file 'ManagePrayerView.fxml'.";
		assert spImportance != null : "fx:id=\"spImportance\" was not injected: check your FXML file 'ManagePrayerView.fxml'.";

	}

	public void setMainApp(MainPrayerApp mainPrayerApp) {
		this.mainPrayerApp = mainPrayerApp;

	}

	@FXML
	private void openMainPrayerView() {
		mainPrayerApp.showMainPrayerView();
	}

	public void setUp() {
		LoadPersons();
		fillSpinner();
	}

	public void LoadPersons() {
		cbPersons.getItems().clear();
		List<Person> pList = mainPrayerApp.getPeronData();
		for (Person person : pList) {
			cbPersons.getItems().add(person.getLastname() + ", " + person.getFirstname());
		}
	}

	@FXML
	private void addNewPerson() {
		MainLoginApp mLA = new MainLoginApp();
		mLA.showCreateDialog("CreatePerson","PrayFor");
		
	}
	
	@FXML
	private void addPerson() {
		if (!cbPersons.getValue().isEmpty()) {
			Person pAdd = getPerson();
			pList.add(pAdd);
			String newP = pAdd.getLastname() + " " + pAdd.getFirstname();
			cbPersons.getItems().remove(cbPersons.getValue());
			if (lblAddedPersons.getText().isEmpty()) {
				lblAddedPersons.setText(newP);
			} else {
				lblAddedPersons.setText(lblAddedPersons.getText() + "; " + newP);
			}
		}
	}

	@FXML
	private void removePerson() {
		cbPersons.getItems().clear();
		LoadPersons();
		lblAddedPersons.setText("");
		pList.clear();
	}

	@FXML
	private void addPrayer() {
		if (preCheck()) {
			Prayer prayer = new Prayer();
			prayer.setTopic(txtPrayerTopic.getText());
			prayer.setPrayerDescription(txtPrayerDescription.getText());
			prayer.setImportance(spImportance.getValue());
			if (dpDate.getValue() != null) {
				prayer.setDueDate(java.sql.Date.valueOf(dpDate.getValue()));
			}
			if (!txtNotes.getText().isEmpty()) {
				prayer.setNotes(txtNotes.getText());
			}
			if (cbAnswered.isSelected()) {
				prayer.setAnswered(true);
			} else {
				prayer.setAnswered(false);
			}
			prayer.setPerson(pList);
			for (Person person : pList) {
				person.setPrayer(prayer);
			}
			try {
				new PrayerDao().persist(prayer);
				txtPrayerTopic.getScene().getWindow().hide();
			} catch (Exception e) {
				new Alert(AlertType.ERROR, "Somthng went Wrong").showAndWait();
			}
			
			
		}

	}

	private boolean preCheck() {
		if (txtPrayerTopic.getText().isEmpty()) {
			new Alert(AlertType.ERROR, "Pleas Enter a Topic").showAndWait();
			return false;
		}
		if (txtPrayerDescription.getText().isEmpty()) {
			new Alert(AlertType.ERROR, "Pleas Enter a Description").showAndWait();
			return false;
		}
		return true;
	}

	private void fillSpinner() {
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
		spImportance.setValueFactory(valueFactory);
	}

	private Person getPerson() {
		String[] splitName = cbPersons.getValue().split(", ");
		List<Person> lPerson = new PersonDao().findByLastName(splitName[0]);
		for (Person person : lPerson) {
			if (person.getFirstname().equals(splitName[1])) {
				return person;
			} else {

			}
		}
		return null;
	}

}
