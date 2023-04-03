package edu.wpi.cs3733.D23.teamQ.controllers;

import edu.wpi.cs3733.D23.teamQ.navigation.Navigation;
import edu.wpi.cs3733.D23.teamQ.navigation.Screen;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HomeController {
  @FXML Button CRReservationButton;
  @FXML Button FDRequestButton;
  @FXML Button SPButton;
  @FXML Button LMButton;

  @FXML Button nextButton;

  @FXML MenuItem exit;
  @FXML MenuItem logout;
  @FXML Button settingButton;
  @FXML TextField searchField;
  @FXML TextField usernameField;
  @FXML TextField passwordField;
  @FXML Button loginButton;
  @FXML Button FUButton;
  @FXML Button FPButton;

  @FXML
  public void initialize() {}

  /** Navigate to the conference room request page when the CRReservationButton is clicked. */
  @FXML
  public void CRReservationButtonClicked() {
    Navigation.navigate(Screen.CONFERENCE_ROOM_REQUEST);
  }

  /** Navigate to the flower delivery request page when the FDRequestButton is clicked. */
  @FXML
  public void FDRequestButtonClicked() {
    Navigation.navigate(Screen.FLOWER_REQUEST);
  }

  /** Navigate to the signage page when the SPButton is clicked. */
  @FXML
  public void SPButtonClicked() {

    Navigation.navigate(Screen.SIGNAGE);
  }

  /** Navigate to the help page when the LMButton is clicked. */
  @FXML
  public void LMButtonClicked() {
    Navigation.navigate(Screen.HELP);
    // System.out.println("Navigate to an information screen.");
  }

  /** Exit the application when the exitMenu is clicked. */
  @FXML
  public void exitMenuClicked() {
    Platform.exit();
  }

  @FXML
  public void nextButtonClicked() {
    Navigation.navigate(Screen.HOME2);
  }

  /** Features might be added in the future. */
  @FXML
  public void settingButtonClicked() {
    System.out.println("Pops up a setting screen.");
  }

  @FXML
  public void searchFieldEntered(KeyEvent e) {
    if (e.getCode().equals(KeyCode.ENTER)) {
      System.out.println("Navigate to a specific page according to the text being entered.");
    }
  }

  @FXML
  public void logout() {
    Navigation.navigate(Screen.LOGIN);
  }
}
