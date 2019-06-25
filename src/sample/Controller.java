package sample;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class Controller {
    // Variables misc.
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private MenuItem meLogin;
    @FXML
    private MenuBar mainMenu;

    // Variables de Welcome
    @FXML
    private Pane panel1;
    @FXML
    private AnchorPane anchorWelcome;
    @FXML
    private Hyperlink hyperGit;

    // Variables de StartNew
    @FXML
    private AnchorPane anchorStartNew;

    // Variables de CreateAlbum
    @FXML
    private Button btnCancel;
    @FXML
    private CheckBox checkSecret;
    @FXML
    private PasswordField txtSecret;
    @FXML
    private Label calbum_lblWarning;

    // Variables del Login
    @FXML
    private Label login_lblWarning;
    @FXML
    private Button login_btnCancel;

    @FXML
    private void close(ActionEvent event){
        Stage st = (Stage) panel1.getScene().getWindow();
        st.close();
    }

    @FXML
    private void closeNewAlb(){
        Stage st = (Stage) btnCancel.getScene().getWindow();
        st.close();
    }

    @FXML
    private void closeLogin(){
        Stage st = (Stage) login_btnCancel.getScene().getWindow();
        st.close();
    }

    @FXML
    private void minimize(ActionEvent event){
        Stage st = (Stage) panel1.getScene().getWindow();
        st.setIconified(true);
    }

    @FXML
    private void disableWelcome(){
        FadeTransition ft = new FadeTransition(Duration.millis(500), anchorWelcome);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.play();
        anchorWelcome.setDisable(true);
        ft = new FadeTransition(Duration.millis(1000), anchorStartNew);
        anchorStartNew.setVisible(true);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }

    @FXML
    private void createAlbum() throws IOException {
        Stage stage = new Stage();
        stage.getIcons().add(new Image(".//resources//leaf.png"));
        stage.setTitle("New album");
        stage.setResizable(false);

        stage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("createAlbum.fxml"));

        FadeTransition ft = new FadeTransition(Duration.millis(500), root);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();

        root.setOnMousePressed(event1 -> {
            xOffset = event1.getSceneX();
            yOffset = event1.getSceneY();
        });
        root.setOnMouseDragged(event12 -> {
            stage.setX(event12.getScreenX() - xOffset);
            stage.setY(event12.getScreenY() - yOffset);
        });

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void secretActivated(ActionEvent event){
        if(txtSecret.isDisabled()){
            txtSecret.setDisable(false);
        } else {
            txtSecret.setDisable(true);
        }
    }

    @FXML
    private void loginTab() throws IOException {
        Stage stage = new Stage();
        stage.getIcons().add(new Image(".//resources//leaf.png"));
        stage.setTitle("Login");
        stage.setResizable(false);

        stage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("loginAccount.fxml"));

        FadeTransition ft = new FadeTransition(Duration.millis(500), root);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();

        root.setOnMousePressed(event1 -> {
            xOffset = event1.getSceneX();
            yOffset = event1.getSceneY();
        });
        root.setOnMouseDragged(event12 -> {
            stage.setX(event12.getScreenX() - xOffset);
            stage.setY(event12.getScreenY() - yOffset);
        });

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void navToGit(){
        Desktop dk = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if(dk != null && dk.isSupported(Desktop.Action.BROWSE)){
            try{
                dk.browse(URI.create("https://github.com/Tomasdzn/Plantis.git"));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
