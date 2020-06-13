package app.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class manageController {

    @FXML
    private void subprojectButtonOnClicked() {
        try {
            Parent newProjectRoot = FXMLLoader.load(getClass().getResource("/app/view/subproject.fxml"));
            Stage newProjectStage = new Stage();
            newProjectStage.setTitle("管理子项目");
            newProjectStage.setScene(new Scene(newProjectRoot, 600, 400));
            newProjectStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void biddersButtonOnClicked(){
        try {
            Parent newProjectRoot = FXMLLoader.load(getClass().getResource("/app/view/bidders.fxml"));
            Stage newProjectStage = new Stage();
            newProjectStage.setTitle("竞标公司列表");
            newProjectStage.setScene(new Scene(newProjectRoot, 600, 400));
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
}
