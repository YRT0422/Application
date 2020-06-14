package app.controller;

import app.model.Project;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class biddersController {

    @FXML
    private Text text;
    private Project project;
    public void setProject(Project selectedProject) {
        this.project = selectedProject;
        text.setText(project.getName());
    }
    @FXML
    private void priceButtonOnClicked(){
        try {
            Parent newProjectRoot = FXMLLoader.load(getClass().getResource("/app/view/price.fxml"));
            Stage newProjectStage = new Stage();
            newProjectStage.setTitle("价格列表");
            newProjectStage.setScene(new Scene(newProjectRoot, 600, 400));
            newProjectStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    @FXML
    private void techButtonOnClicked(){
        try {
            Parent newProjectRoot = FXMLLoader.load(getClass().getResource("/app/view/tech.fxml"));
            Stage newProjectStage = new Stage();
            newProjectStage.setTitle("竞标公司列表");
            newProjectStage.setScene(new Scene(newProjectRoot, 600, 400));
            newProjectStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
