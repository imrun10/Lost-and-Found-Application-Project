package application;



import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;


public class Items {
    
    private SimpleStringProperty itemName;
    private LocalDate itemDate;
    private SimpleStringProperty studentID;
    private SimpleStringProperty itemLocation;
    private SimpleStringProperty itemStatus;
    private SimpleStringProperty itemDescription;
    


    public Items(String name, LocalDate date, String id, String location, String status, String description) {
        this.itemName = new SimpleStringProperty(name);
        this.itemDate = date;
        this.studentID = new SimpleStringProperty(id);
        this.itemLocation = new SimpleStringProperty(location);
        this.itemStatus = new SimpleStringProperty(status);
        this.itemDescription = new SimpleStringProperty(description);
        }

    public String getItemName() {
        return itemName.get();
    }

    public void setItemName(String name) {
        itemName.set(name);
    }
    
    public LocalDate getItemDate() {
        return itemDate;
    }
    
    public void setItemDate(LocalDate date) {
        this.itemDate = date;
    }

    public String getStudentID() {
        return studentID.get();
    }

    public void setStudentID(String id) {
        studentID.set(id);
    }
    
    public String getItemLocation() {
        return itemLocation.get();
    }

    public void setItemLocation(String location) {
        itemLocation.set(location);
    }
    
    public String getItemStatus() {
        return itemStatus.get();
    }

    public void setItemStatus(String status) {
        itemStatus.set(status);
    }
    
    public String getItemDescription() {
        return itemDescription.get();
    }

    public void setItemDescription(String description) {
        itemDescription.set(description);
    }}
    	
