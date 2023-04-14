module onmore {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.web;
	
	opens application to javafx.graphics, javafx.fxml, Items.java;
}
