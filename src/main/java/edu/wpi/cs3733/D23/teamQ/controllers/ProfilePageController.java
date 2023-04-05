package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.db.impl.AccountDAOImpl;
import edu.wpi.cs3733.D23.teamQ.db.impl.PersonDaoImpl;
import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ProfilePageController {
    PersonDaoImpl dao = new PersonDaoImpl();
    @FXML private Button Edit_Profile;

    @FXML private Label Email_Display;

    @FXML private Label First_Name_Display;

    @FXML private Label ID_Number_Display;

    @FXML private Label Last_Name_Display;

    @FXML private Label Phone_Number_Display;

    @FXML private Label Title_Display;

    @FXML private Label Username_Display;

    @FXML
    private void initialize() {
        // DO ONE FOR PROFILE IMAGE AS WELL NEXT TIME
        String username = LoginController.getLoginUsername();
        this.Title_Display.setText();

        this.ID_Number_Display.setText();
        this.First_Name_Display.setText(First_Name_Display.getText());
        this.Last_Name_Display.setText(Last_Name_Display.getText());
        this.Email_Display.setText(Email_Display.getText());
        this.Phone_Number_Display.setText(Phone_Number_Display.getText());
        this.Username_Display.setText(Username_Display.getText());


        Title_Display.getText().add(dao.getTitle().get(0));

        this.Edit_Profile.setOnMouseClicked(event -> Navigation.navigate(Screen.PROFILE_PAGE));
    }
}
