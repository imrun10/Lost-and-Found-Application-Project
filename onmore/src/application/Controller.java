package application;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.util.Duration;

public class Controller {

    @FXML
    private TextArea clickDescription;

    @FXML
    private TableColumn<Items, LocalDate> dateColumn;

    @FXML
    private DatePicker dateLostFound;

    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<Items, String> desColumn;

    @FXML
    private Button editButton;

    @FXML
    private Button exportButton;

    @FXML
    private Menu helpMenu;

    @FXML
    private TableColumn<Items, String> idColumn;

    @FXML
    private MenuItem instructionsItem;

    @FXML
    private TextArea itemDescription;

    @FXML
    private ComboBox<String> itemLocation;

    @FXML
    private TextField itemName;

    @FXML
    private ComboBox<String> itemStatus;

    @FXML
    private TableView<Items> itemTable;

    @FXML
    private TableColumn<Items, String> locationColumn;

    @FXML
    private ListView<String> locationsList;

    @FXML
    private MenuBar menuBar;

    @FXML
    private TableColumn<Items, String> nameColumn;

    @FXML
    private Text notificationText;

    @FXML
    private Button saveButton;

    @FXML
    private TableColumn<Items, String> statusColumn;

    @FXML
    private TextField studentID;

    @FXML
    private Text systemDateTime;

    @FXML
    private Button undoButton;
    
    @FXML
    private PieChart lostChart;
    
    @FXML
    private PieChart foundChart;
    
    ObservableList<Items> data = FXCollections.observableArrayList();
    ObservableList<Items> data1 = FXCollections.observableArrayList();
    ObservableList<PieChart.Data> lostData =  FXCollections.observableArrayList();
    ObservableList<PieChart.Data> foundData =  FXCollections.observableArrayList();
    String pieChartColors [] = {"RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "PURPLE", "BEIGE", "BROWN", "BLACK"};
    
 	int a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s;
    
 	PieChart.Data buildingAL = new PieChart.Data("Building A",a);
 	PieChart.Data buildingBL = new PieChart.Data("Building B",b);
 	PieChart.Data buildingCL = new PieChart.Data("Building C",c);
 	PieChart.Data buildingDL = new PieChart.Data("Building D",d);
 	PieChart.Data auditoriumL = new PieChart.Data("Auditorium",e);
 	PieChart.Data libraryL = new PieChart.Data("Library",f);
 	PieChart.Data sportsL = new PieChart.Data("Sports Center",g);
 	PieChart.Data studentsL = new PieChart.Data("Student Commons",h);
 	PieChart.Data welcomeL = new PieChart.Data("Welcome Center",j);
 	
 	PieChart.Data buildingAF = new PieChart.Data("Building A",k);
 	PieChart.Data buildingBF = new PieChart.Data("Building B",l);
 	PieChart.Data buildingCF = new PieChart.Data("Building C",m);
 	PieChart.Data buildingDF = new PieChart.Data("Building D",n);
 	PieChart.Data auditoriumF = new PieChart.Data("Auditorium",o);
 	PieChart.Data libraryF = new PieChart.Data("Library",p);
 	PieChart.Data sportsF = new PieChart.Data("Sports Center",q);
 	PieChart.Data studentsF = new PieChart.Data("Student Commons",r);
 	PieChart.Data welcomeF = new PieChart.Data("Welcome Center",s);
    
    @FXML
    void dateAction(ActionEvent event) {
    	dateLostFound.getValue();
    }

    @FXML
    void deleteAction(ActionEvent event) {
    	Items selected = itemTable.getSelectionModel().getSelectedItem();
		data1.add(selected);
		itemTable.getItems().remove(selected);
		notificationText.setText("The selected item has been deleted.");
		undoButton.setDisable(false);
		
		//Populate the data for both pie charts
    	lostData.removeAll(buildingAL,buildingBL,buildingCL,buildingDL,auditoriumL,libraryL,sportsL,studentsL,welcomeL);
    	foundData.removeAll(buildingAF,buildingBF,buildingCF,buildingDF,auditoriumF,libraryF,sportsF,studentsF,welcomeF);
    	
        a = b = c = d = e = f = g = h = j = k = l = m = n = o = p = q = r = s = 0;
    	
	 	for(int i = 0; i < data.size(); i++) {
	 		if (data.get(i).getItemLocation().toString() == "Building A" && data.get(i).getItemStatus().toString() == "Lost") 
	 			a-=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building B" && data.get(i).getItemStatus().toString() == "Lost") 
	 			b-=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building C" && data.get(i).getItemStatus().toString() == "Lost") 
	 			c-=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building D" && data.get(i).getItemStatus().toString() == "Lost") 
	 			d-=1;
	 		else if (data.get(i).getItemLocation().toString() == "Auditorium" && data.get(i).getItemStatus().toString() == "Lost") 
	 			e-=1;
	 		else if (data.get(i).getItemLocation().toString() == "Library" && data.get(i).getItemStatus().toString() == "Lost") 
	 			f-=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Sports Center" && data.get(i).getItemStatus().toString() == "Lost") 
	 			g-=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Student Commons" && data.get(i).getItemStatus().toString() == "Lost") 
				h-=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Welcome Center" && data.get(i).getItemStatus().toString() == "Lost") 
				j-=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Building A" && data.get(i).getItemStatus().toString() == "Found") 
	 			k-=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building B" && data.get(i).getItemStatus().toString() == "Found") 
	 			l-=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building C" && data.get(i).getItemStatus().toString() == "Found") 
	 			m-=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building D" && data.get(i).getItemStatus().toString() == "Found") 
	 			n-=1;
	 		else if (data.get(i).getItemLocation().toString() == "Auditorium" && data.get(i).getItemStatus().toString() == "Found") 
	 			o-=1;
	 		else if (data.get(i).getItemLocation().toString() == "Library" && data.get(i).getItemStatus().toString() == "Found") 
	 			p-=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Sports Center" && data.get(i).getItemStatus().toString() == "Found") 
	 			q-=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Student Commons" && data.get(i).getItemStatus().toString() == "Found") 
				r-=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Welcome Center" && data.get(i).getItemStatus().toString() == "Found") 
				s-=1;
	 	}

	 	buildingAL = new PieChart.Data("Building A",a);
	 	buildingBL = new PieChart.Data("Building B",b);
	 	buildingCL = new PieChart.Data("Building C",c);
	 	buildingDL = new PieChart.Data("Building D",d);
	 	auditoriumL = new PieChart.Data("Auditorium",e);
	 	libraryL = new PieChart.Data("Library",f);
	 	sportsL = new PieChart.Data("Sports Center",g);
	 	studentsL = new PieChart.Data("Student Commons",h);
	 	welcomeL = new PieChart.Data("Welcome Center",j);
	 	
	 	buildingAF = new PieChart.Data("Building A",k);
	 	buildingBF = new PieChart.Data("Building B",l);
	 	buildingCF = new PieChart.Data("Building C",m);
	 	buildingDF = new PieChart.Data("Building D",n);
	 	auditoriumF = new PieChart.Data("Auditorium",o);
	 	libraryF = new PieChart.Data("Library",p);
	 	sportsF = new PieChart.Data("Sports Center",q);
	 	studentsF = new PieChart.Data("Student Commons",r);
	 	welcomeF = new PieChart.Data("Welcome Center",s);
	 	
	 	if(a > 0)
	 		lostData.add(buildingAL);
	 	if(b > 0)
	 		lostData.add(buildingBL);
	 	if(c > 0)
	 		lostData.add(buildingCL);
	 	if(d > 0)
	 		lostData.add(buildingDL);
	 	if(e > 0)
	 		lostData.add(auditoriumL);
	 	if(f > 0)
	 		lostData.add(libraryL);
	 	if(g > 0)
	 		lostData.add(sportsL);
	 	if(h > 0)
	 		lostData.add(studentsL);
	 	if(j > 0)
	 		lostData.add(welcomeL);
	 	if(k > 0)
	 		foundData.add(buildingAF);
	 	if(l > 0)
	 		foundData.add(buildingBF);
	 	if(m > 0)
	 		foundData.add(buildingCF);
	 	if(n > 0)
	 		foundData.add(buildingDF);
	 	if(o > 0)
	 		foundData.add(auditoriumF);
	 	if(p > 0)
	 		foundData.add(libraryF);
	 	if(q > 0)
	 		foundData.add(sportsF);
	 	if(r > 0)
	 		foundData.add(studentsF);
	 	if(s > 0)
	 		foundData.add(welcomeF);
	 	
 		lostChart.setData(lostData);
 		foundChart.setData(foundData);
	 	
	 	//Constant pie chart colors
	 	int i = 0;
	 	for (PieChart.Data data : lostData) {
	 		data.getNode().setStyle("-fx-pie-color: " + pieChartColors[i % pieChartColors.length] + ";");
	 		i++;
	 	}
	 	int j = 0;
	 	for (PieChart.Data data : foundData) {
	 		data.getNode().setStyle("-fx-pie-color: " + pieChartColors[j % pieChartColors.length] + ";");
	 		j++;
	 	}

    }

    @FXML
    void editAction(ActionEvent event) {

    }

    @FXML
    void exportAction(ActionEvent event) throws Exception {
    	Writer writer = null;
        try {
            File file = new File("C:\\Person.csv.");
            writer = new BufferedWriter(new FileWriter(file));
            notificationText.setText("The table's data has been exported to a CSV file.");
            String tableHeader = nameColumn.getText() + "," + dateColumn.getText() + "," + idColumn.getText() +  "," + locationColumn.getText() + "," + statusColumn.getText() + "," + desColumn.getText() + "\n";
            writer.write(tableHeader);
            
            for (Items newItem : data) {
                String text = newItem.getItemName() + "," + newItem.getItemDate() + "," + newItem.getStudentID() +  "," + newItem.getItemLocation() + "," + newItem.getItemStatus() + "," + newItem.getItemDescription() + "\n";
                writer.write(text);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {

            writer.flush();
            writer.close();
        }

    }
    
    @FXML
    void instructionsAction(ActionEvent event) throws MalformedURLException {
    	String location =
                new File(
                        System.getProperty("user.dir") + File.separator + "test.txt"
                ).toURI().toURL().toExternalForm();

        WebView webView = new WebView();
        webView.getEngine().load(location);

    }

    @FXML
    void saveAction(ActionEvent event) {
    	Items newItem = new Items(itemName.getText(),dateLostFound.getValue(),studentID.getText(),itemLocation.getValue().toString(),itemStatus.getValue().toString(),itemDescription.getText());
    	itemTable.getItems().addAll(newItem);
    	notificationText.setText("Your inputs have been saved.");
    	itemName.clear();
    	studentID.clear();
    	itemDescription.clear();
    	
		//Populate the data for both pie charts
    	lostData.removeAll(buildingAL,buildingBL,buildingCL,buildingDL,auditoriumL,libraryL,sportsL,studentsL,welcomeL);
    	foundData.removeAll(buildingAF,buildingBF,buildingCF,buildingDF,auditoriumF,libraryF,sportsF,studentsF,welcomeF);
    	
        a = b = c = d = e = f = g = h = j = k = l = m = n = o = p = q = r = s = 0;
    	    	
	 	for(int i = 0; i < data.size(); i++) {
	 		if (data.get(i).getItemLocation().toString() == "Building A" && data.get(i).getItemStatus().toString() == "Lost") 
	 			a+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building B" && data.get(i).getItemStatus().toString() == "Lost") 
	 			b+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building C" && data.get(i).getItemStatus().toString() == "Lost") 
	 			c+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building D" && data.get(i).getItemStatus().toString() == "Lost") 
	 			d+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Auditorium" && data.get(i).getItemStatus().toString() == "Lost") 
	 			e+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Library" && data.get(i).getItemStatus().toString() == "Lost") 
	 			f+=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Sports Center" && data.get(i).getItemStatus().toString() == "Lost") 
	 			g+=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Student Commons" && data.get(i).getItemStatus().toString() == "Lost") 
				h+=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Welcome Center" && data.get(i).getItemStatus().toString() == "Lost") 
				j+=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Building A" && data.get(i).getItemStatus().toString() == "Found") 
	 			k+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building B" && data.get(i).getItemStatus().toString() == "Found") 
	 			l+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building C" && data.get(i).getItemStatus().toString() == "Found") 
	 			m+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building D" && data.get(i).getItemStatus().toString() == "Found") 
	 			n+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Auditorium" && data.get(i).getItemStatus().toString() == "Found") 
	 			o+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Library" && data.get(i).getItemStatus().toString() == "Found") 
	 			p+=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Sports Center" && data.get(i).getItemStatus().toString() == "Found") 
	 			q+=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Student Commons" && data.get(i).getItemStatus().toString() == "Found") 
				r+=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Welcome Center" && data.get(i).getItemStatus().toString() == "Found") 
				s+=1;
	 	}

	 	buildingAL = new PieChart.Data("Building A",a);
	 	buildingBL = new PieChart.Data("Building B",b);
	 	buildingCL = new PieChart.Data("Building C",c);
	 	buildingDL = new PieChart.Data("Building D",d);
	 	auditoriumL = new PieChart.Data("Auditorium",e);
	 	libraryL = new PieChart.Data("Library",f);
	 	sportsL = new PieChart.Data("Sports Center",g);
	 	studentsL = new PieChart.Data("Student Commons",h);
	 	welcomeL = new PieChart.Data("Welcome Center",j);
	 	
	 	buildingAF = new PieChart.Data("Building A",k);
	 	buildingBF = new PieChart.Data("Building B",l);
	 	buildingCF = new PieChart.Data("Building C",m);
	 	buildingDF = new PieChart.Data("Building D",n);
	 	auditoriumF = new PieChart.Data("Auditorium",o);
	 	libraryF = new PieChart.Data("Library",p);
	 	sportsF = new PieChart.Data("Sports Center",q);
	 	studentsF = new PieChart.Data("Student Commons",r);
	 	welcomeF = new PieChart.Data("Welcome Center",s);
	 	
	 	if(a > 0)
	 		lostData.add(buildingAL);
	 	if(b > 0)
	 		lostData.add(buildingBL);
	 	if(c > 0)
	 		lostData.add(buildingCL);
	 	if(d > 0)
	 		lostData.add(buildingDL);
	 	if(e > 0)
	 		lostData.add(auditoriumL);
	 	if(f > 0)
	 		lostData.add(libraryL);
	 	if(g > 0)
	 		lostData.add(sportsL);
	 	if(h > 0)
	 		lostData.add(studentsL);
	 	if(j > 0)
	 		lostData.add(welcomeL);
	 	if(k > 0)
	 		foundData.add(buildingAF);
	 	if(l > 0)
	 		foundData.add(buildingBF);
	 	if(m > 0)
	 		foundData.add(buildingCF);
	 	if(n > 0)
	 		foundData.add(buildingDF);
	 	if(o > 0)
	 		foundData.add(auditoriumF);
	 	if(p > 0)
	 		foundData.add(libraryF);
	 	if(q > 0)
	 		foundData.add(sportsF);
	 	if(r > 0)
	 		foundData.add(studentsF);
	 	if(s > 0)
	 		foundData.add(welcomeF);
	 	
 		lostChart.setData(lostData);
 		foundChart.setData(foundData);
	 	
	 	//Constant pie chart colors
	 	int i = 0;
	 	for (PieChart.Data data : lostData) {
	 		data.getNode().setStyle("-fx-pie-color: " + pieChartColors[i % pieChartColors.length] + ";");
	 		i++;
	 	}
	 	int j = 0;
	 	for (PieChart.Data data : foundData) {
	 		data.getNode().setStyle("-fx-pie-color: " + pieChartColors[j % pieChartColors.length] + ";");
	 		j++;
	 	}

    }

    @FXML
    void undoAction(ActionEvent event) {
	    itemTable.getItems().addAll(data1);
	    data1.clear();
	    notificationText.setText("The deleted item has been restored.");
	    undoButton.setDisable(true);
    	
		//Populate the data for both pie charts
    	lostData.removeAll(buildingAL,buildingBL,buildingCL,buildingDL,auditoriumL,libraryL,sportsL,studentsL,welcomeL);
    	foundData.removeAll(buildingAF,buildingBF,buildingCF,buildingDF,auditoriumF,libraryF,sportsF,studentsF,welcomeF);
    	
        a = b = c = d = e = f = g = h = j = k = l = m = n = o = p = q = r = s = 0;
    	    	
	 	for(int i = 0; i < data.size(); i++) {
	 		if (data.get(i).getItemLocation().toString() == "Building A" && data.get(i).getItemStatus().toString() == "Lost") 
	 			a+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building B" && data.get(i).getItemStatus().toString() == "Lost") 
	 			b+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building C" && data.get(i).getItemStatus().toString() == "Lost") 
	 			c+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building D" && data.get(i).getItemStatus().toString() == "Lost") 
	 			d+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Auditorium" && data.get(i).getItemStatus().toString() == "Lost") 
	 			e+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Library" && data.get(i).getItemStatus().toString() == "Lost") 
	 			f+=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Sports Center" && data.get(i).getItemStatus().toString() == "Lost") 
	 			g+=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Student Commons" && data.get(i).getItemStatus().toString() == "Lost") 
				h+=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Welcome Center" && data.get(i).getItemStatus().toString() == "Lost") 
				j+=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Building A" && data.get(i).getItemStatus().toString() == "Found") 
	 			k+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building B" && data.get(i).getItemStatus().toString() == "Found") 
	 			l+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building C" && data.get(i).getItemStatus().toString() == "Found") 
	 			m+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Building D" && data.get(i).getItemStatus().toString() == "Found") 
	 			n+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Auditorium" && data.get(i).getItemStatus().toString() == "Found") 
	 			o+=1;
	 		else if (data.get(i).getItemLocation().toString() == "Library" && data.get(i).getItemStatus().toString() == "Found") 
	 			p+=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Sports Center" && data.get(i).getItemStatus().toString() == "Found") 
	 			q+=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Student Commons" && data.get(i).getItemStatus().toString() == "Found") 
				r+=1;
	 	    else if (data.get(i).getItemLocation().toString() == "Welcome Center" && data.get(i).getItemStatus().toString() == "Found") 
				s+=1;
	 	}

	 	buildingAL = new PieChart.Data("Building A",a);
	 	buildingBL = new PieChart.Data("Building B",b);
	 	buildingCL = new PieChart.Data("Building C",c);
	 	buildingDL = new PieChart.Data("Building D",d);
	 	auditoriumL = new PieChart.Data("Auditorium",e);
	 	libraryL = new PieChart.Data("Library",f);
	 	sportsL = new PieChart.Data("Sports Center",g);
	 	studentsL = new PieChart.Data("Student Commons",h);
	 	welcomeL = new PieChart.Data("Welcome Center",j);
	 	
	 	buildingAF = new PieChart.Data("Building A",k);
	 	buildingBF = new PieChart.Data("Building B",l);
	 	buildingCF = new PieChart.Data("Building C",m);
	 	buildingDF = new PieChart.Data("Building D",n);
	 	auditoriumF = new PieChart.Data("Auditorium",o);
	 	libraryF = new PieChart.Data("Library",p);
	 	sportsF = new PieChart.Data("Sports Center",q);
	 	studentsF = new PieChart.Data("Student Commons",r);
	 	welcomeF = new PieChart.Data("Welcome Center",s);
	 	
	 	if(a > 0)
	 		lostData.add(buildingAL);
	 	if(b > 0)
	 		lostData.add(buildingBL);
	 	if(c > 0)
	 		lostData.add(buildingCL);
	 	if(d > 0)
	 		lostData.add(buildingDL);
	 	if(e > 0)
	 		lostData.add(auditoriumL);
	 	if(f > 0)
	 		lostData.add(libraryL);
	 	if(g > 0)
	 		lostData.add(sportsL);
	 	if(h > 0)
	 		lostData.add(studentsL);
	 	if(j > 0)
	 		lostData.add(welcomeL);
	 	if(k > 0)
	 		foundData.add(buildingAF);
	 	if(l > 0)
	 		foundData.add(buildingBF);
	 	if(m > 0)
	 		foundData.add(buildingCF);
	 	if(n > 0)
	 		foundData.add(buildingDF);
	 	if(o > 0)
	 		foundData.add(auditoriumF);
	 	if(p > 0)
	 		foundData.add(libraryF);
	 	if(q > 0)
	 		foundData.add(sportsF);
	 	if(r > 0)
	 		foundData.add(studentsF);
	 	if(s > 0)
	 		foundData.add(welcomeF);
	 	
 		lostChart.setData(lostData);
 		foundChart.setData(foundData);
	 	
	 	//Constant pie chart colors
	 	int i = 0;
	 	for (PieChart.Data data : lostData) {
	 		data.getNode().setStyle("-fx-pie-color: " + pieChartColors[i % pieChartColors.length] + ";");
	 		i++;
	 	}
	 	int j = 0;
	 	for (PieChart.Data data : foundData) {
	 		data.getNode().setStyle("-fx-pie-color: " + pieChartColors[j % pieChartColors.length] + ";");
	 		j++;
	 	}
	 	
    }
    
    @FXML
	void initialize() {
    	//Current time & date
    	Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->  
        systemDateTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
	    ),
	        new KeyFrame(Duration.seconds(1))
	    );
	    clock.setCycleCount(Animation.INDEFINITE);
	    clock.play();
	    
	    //System notification text
	    Timeline clock1 = new Timeline(new KeyFrame(Duration.ZERO, e -> 
	    {        
	    	notificationText.setText("");
	    }),
	         new KeyFrame(Duration.seconds(5))
	    );
	    clock1.setCycleCount(Animation.INDEFINITE);
	    clock1.play();
	    
	    //Disable future dates
	    dateLostFound.setDayCellFactory(param -> new DateCell() {
	        @Override
	        public void updateItem(LocalDate date, boolean empty) {
	            super.updateItem(date, empty);
	            setDisable(empty || date.compareTo(LocalDate.now()) > 0 );
	        }
	    });
	    
	    //Disable properties for the buttons
    	saveButton.disableProperty().bind(itemName.textProperty().isEmpty().or(dateLostFound.valueProperty().isNull()).or(itemLocation.valueProperty().isNull()).or(itemStatus.valueProperty().isNull()).or(itemDescription.textProperty().isEmpty()));
    	editButton.disableProperty().bind(itemTable.getSelectionModel().selectedItemProperty().isNull());
    	deleteButton.disableProperty().bind(itemTable.getSelectionModel().selectedItemProperty().isNull());
    	exportButton.disableProperty().bind(Bindings.size(data).isEqualTo(0));
    	undoButton.setDisable(true);
    	
	    //Populate the list view and combo boxes
    	String status[] = { "Lost", "Found" };
    	String allBuildings[] = { "Building A", "Building B", "Building C", "Building D", "Auditorium", "Library", "Sports Center", "Student Commons", "Welcome Center" };
    	String listBuildings[] = { "All Locations", "Building A", "Building B", "Building C", "Building D", "Auditorium", "Library", "Sports Center", "Student Commons", "Welcome Center" };
    	itemLocation.getItems().addAll(allBuildings);
    	itemStatus.getItems().addAll(status);
    	locationsList.getItems().addAll(listBuildings);
    	
    	//Set up the table's values
    	nameColumn.setCellValueFactory(new PropertyValueFactory<Items, String>("itemName"));
    	dateColumn.setCellValueFactory(new PropertyValueFactory<Items, LocalDate>("itemDate"));
    	idColumn.setCellValueFactory(new PropertyValueFactory<Items, String>("studentID"));
	    locationColumn.setCellValueFactory(new PropertyValueFactory<Items, String>("itemLocation"));
	    statusColumn.setCellValueFactory(new PropertyValueFactory<Items, String>("itemStatus"));
	    desColumn.setCellValueFactory(new PropertyValueFactory<Items, String>("itemDescription"));
	    itemTable.setItems(data);
	    
	    //Pie charts titles
	    lostChart.setTitle("Lost items per building at AUBH");
	    foundChart.setTitle("Found items per building at AUBH");
	    
	    //View data from clicked row
    	itemTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Items>() {
			@Override
			public void changed(ObservableValue<? extends Items> arg0, Items arg1, Items arg2) {
				clickDescription.setText("Name: "+ data.get(itemTable.getSelectionModel().getSelectedIndex()).getItemName().toString() + "\r\n" +
										"Date Lost/Found: "+ data.get(itemTable.getSelectionModel().getSelectedIndex()).getItemDate().toString() + "\r\n" +
										"Student ID: "+ data.get(itemTable.getSelectionModel().getSelectedIndex()).getStudentID().toString() + "\r\n" +
										"Location: "+ data.get(itemTable.getSelectionModel().getSelectedIndex()).getItemLocation().toString() + "\r\n" +
										"Status: "+ data.get(itemTable.getSelectionModel().getSelectedIndex()).getItemStatus().toString() + "\r\n" +
										"Description: "+ data.get(itemTable.getSelectionModel().getSelectedIndex()).getItemDescription().toString());
			}});
    	
    	//Filtering the table with the list view
	    locationsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2){
				
				clickDescription.clear();
				if(locationsList.getSelectionModel().getSelectedItem().toString() != "All Locations" && !data.isEmpty())
				{
					FilteredList<Items> data2 = new FilteredList<Items>(data, e -> e.getItemLocation().toString() == locationsList.getSelectionModel().getSelectedItem().toString());
					itemTable.setItems(data2);
					
					//View filtered data from clicked row
					itemTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Items>() {
						 @Override
							public void changed(ObservableValue<? extends Items> arg0, Items arg1, Items arg2) {
							 clickDescription.setText("Name: "+ data2.get(itemTable.getSelectionModel().getSelectedIndex()).getItemName().toString() + "\r\n" +
										"Date Lost/Found: "+ data2.get(itemTable.getSelectionModel().getSelectedIndex()).getItemDate().toString() + "\r\n" +
										"Student ID: "+ data2.get(itemTable.getSelectionModel().getSelectedIndex()).getStudentID().toString() + "\r\n" +
										"Location: "+ data2.get(itemTable.getSelectionModel().getSelectedIndex()).getItemLocation().toString() + "\r\n" +
										"Status: "+ data2.get(itemTable.getSelectionModel().getSelectedIndex()).getItemStatus().toString() + "\r\n" +
										"Description: "+ data2.get(itemTable.getSelectionModel().getSelectedIndex()).getItemDescription().toString());
						 }});
 	
				}
				else 
					itemTable.setItems(data);
			}});
    	
    }

}
