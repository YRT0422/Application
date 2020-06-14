package app.controller;

import app.model.Project;
import app.model.ProjectManager;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.WindowEvent;

public class manageController{
    @FXML
    private Text text;
    public Project project;


    @FXML
    private void subprojectButtonOnClicked() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/subproject.fxml"));
            Pane mainPane = (Pane) loader.load();
            subprojectController controller = loader.<subprojectController>getController();
            controller.setProject(project);
            Stage newProjectStage = new Stage();
            newProjectStage.setTitle("管理项目");
            newProjectStage.setScene(new Scene(mainPane, 600, 400));
            newProjectStage.show();
            Stage thisStage = (Stage)text.getScene().getWindow();
            thisStage.close();
            newProjectStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    project = controller.getProject();
                    thisStage.show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void biddersButtonOnClicked(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/bidders.fxml"));
            Pane mainPane = (Pane) loader.load();
            biddersController controller = loader.<biddersController>getController();
            controller.setProject(project);
            Stage newProjectStage = new Stage();
            newProjectStage.setTitle("管理项目");
            newProjectStage.setScene(new Scene(mainPane, 600, 400));
            newProjectStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    @FXML
    private void resultButtonOnClicked(){
        try {
            Parent newProjectRoot = FXMLLoader.load(getClass().getResource("/app/view/result.fxml"));
            Stage newProjectStage = new Stage();
            newProjectStage.setTitle("计算结果");
            newProjectStage.setScene(new Scene(newProjectRoot, 600, 400));
            newProjectStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void setProject(Project selectedProject) {
        this.project = selectedProject;
        text.setText(project.getName());
    }

    public Project getProject() {
        return project;
    }
}
