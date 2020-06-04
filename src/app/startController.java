package app;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class startController {
    public Button newProjectButton;


    @FXML
    private void newProjectButtonOnClicked(){
        try {
            Parent newProjectRoot = FXMLLoader.load(getClass().getResource("newProject.fxml"));
            Stage newProjectStage = new Stage();
            newProjectStage.setTitle("新建项目");
            newProjectStage.setScene(new Scene(newProjectRoot, 600, 400));
            newProjectStage.show();
            Stage stage = (Stage) newProjectButton.getScene().getWindow();
            stage.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
