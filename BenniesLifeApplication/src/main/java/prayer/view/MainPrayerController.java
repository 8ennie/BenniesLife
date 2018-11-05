/**
 * 
 */
package prayer.view;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import database.Person;
import database.Prayer;
import databaseDAO.PrayerDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import prayer.MainPrayerApp;
import prayer.model.PrayerM;


/**
 * @author bcwie
 *
 */
public class MainPrayerController {


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lblWeek"
    private Label lblWeek; // Value injected by FXMLLoader

    @FXML // fx:id="tvPrayers"
    private TableView<PrayerM> tvPrayers; // Value injected by FXMLLoader
    
    @FXML // fx:id="tcDate"
    private TableColumn<PrayerM, Date> tcDate; // Value injected by FXMLLoader

    @FXML // fx:id="tcPerson"
    private TableColumn<PrayerM, String> tcPerson; // Value injected by FXMLLoader

    @FXML // fx:id="tcTopic"
    private TableColumn<PrayerM, String> tcTopic; // Value injected by FXMLLoader

    @FXML // fx:id="tcDescription"
    private TableColumn<PrayerM, String> tcDescription; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lblWeek != null : "fx:id=\"lblWeek\" was not injected: check your FXML file 'MainPrayerView.fxml'.";
        assert tcDate != null : "fx:id=\"tcDate\" was not injected: check your FXML file 'MainPrayerView.fxml'.";
        assert tvPrayers != null : "fx:id=\"tvPrayers\" was not injected: check your FXML file 'MainPrayerView.fxml'.";
        assert tcPerson != null : "fx:id=\"tcPerson\" was not injected: check your FXML file 'MainPrayerView.fxml'.";
        assert tcTopic != null : "fx:id=\"tcTopic\" was not injected: check your FXML file 'MainPrayerView.fxml'.";
        assert tcDescription != null : "fx:id=\"tcDescription\" was not injected: check your FXML file 'MainPrayerView.fxml'.";

        tcTopic.setCellValueFactory(cellData -> cellData.getValue().getTopic());
        tcDescription.setCellValueFactory(cellData -> cellData.getValue().getPrayerDescription());
        tcPerson.setCellValueFactory(cellData -> cellData.getValue().getPersons());
    }
 
    private ObservableList<PrayerM> prayerData = FXCollections.observableArrayList();
	
	private MainPrayerApp mainPrayerApp;
	
	public void setMainApp(MainPrayerApp mainPrayerApp) {
        this.mainPrayerApp = mainPrayerApp;
    }
	
	@FXML
	private void openManagePrayerView() {
		mainPrayerApp.showManagePrayerView();
	}
	
	private void loadTableView() {
		prayerData.clear();
		List<Prayer> pList = new PrayerDao().getAll();
		for (Prayer prayer : pList) {
			String persons = "";
			if(!prayer.getPerson().isEmpty()) {
				for (Person person : prayer.getPerson()) {
					if(persons == "") {
						persons = person.getFirstname() + " " + person.getLastname();
					}else {
						persons = persons + "; " + person.getFirstname() + " " + person.getLastname();
					}
				}
			}
			PrayerM pM = new PrayerM(prayer.getPrayer_id(), prayer.getTopic(), prayer.getPrayerDescription(),persons, prayer.getDueDate());
			prayerData.add(pM);
		}
		tvPrayers.setItems(prayerData);
	}
	
	@FXML
	private void refreshTableView() {
		loadTableView();
	}
	
	public void setUp() {
		loadTableView();
	}
}
