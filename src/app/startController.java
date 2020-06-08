package app;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class startController implements Initializable {
    public Button manageButton;
    @FXML
    private ImageView imageView;

    @FXML
    private void manageButtonOnClicked(){
        try {
            Parent newProjectRoot = FXMLLoader.load(getClass().getResource("subproject.fxml"));
            Stage newProjectStage = new Stage();
            newProjectStage.setTitle("新建项目");
            newProjectStage.setScene(new Scene(newProjectRoot, 600, 400));
            newProjectStage.show();
            Stage stage = (Stage) manageButton.getScene().getWindow();
            stage.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/app/drawable/logo.png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }
}
