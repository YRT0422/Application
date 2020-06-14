package app.controller;
import app.model.Project;
import app.model.ProjectManager;
import app.model.Saver;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import app.controller.manageController;
import javafx.stage.WindowEvent;

public class startController implements Initializable {
    public Button manageButton;
    @FXML
    private ImageView imageView;
    @FXML
    private ListView<String> listView = new ListView<String>();
    private final Saver saver = new Saver();
    private ProjectManager projectManager = new ProjectManager();
    @FXML
    private TextField textField = new TextField();
    @FXML
    private Button addButton;
    private String selectedItem = "";
    private Project selectedProject;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/app/drawable/logo.png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
        saver.create("projectManager.txt");
        if(saver.read("projectManager.txt")==null){
            saver.write("projectManager.txt",projectManager);
        }
        projectManager = (ProjectManager) saver.read("projectManager.txt");
        ObservableList<String> items = FXCollections.observableArrayList(projectManager.getNameList());
        listView.setItems(items);
        listView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
            selectedItem = listView.getSelectionModel().getSelectedItem();
        });
    }


    @FXML
    private void manageButtonOnClicked(){
        if(!Objects.equals(selectedItem,"")) {
            try {
                selectedProject = projectManager.getProject(selectedItem);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/manage.fxml"));
                Pane mainPane = (Pane) loader.load();
                manageController controller = loader.<manageController>getController();
                controller.setProject(selectedProject);
                Stage newProjectStage = new Stage();
                newProjectStage.setTitle("管理项目");
                newProjectStage.setScene(new Scene(mainPane, 600, 400));
                newProjectStage.show();
                newProjectStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        projectManager.updateProject(selectedProject,controller.getProject());
                        saver.write("projectManager.txt", projectManager);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("请选择项目");
            a.show();
        }

    }

    @FXML
    private void addButtonOnClicked(){
        String newProjectName = textField.getText();
        if (!Objects.equals(newProjectName.replaceAll("\\s+",""), "")) {
            Project newProject = new Project(newProjectName);
            projectManager.addProject(newProject);
            saver.write("projectManager.txt", projectManager);
            ObservableList<String> items = FXCollections.observableArrayList(projectManager.getNameList());
            listView.setItems(items);
            System.out.println(projectManager.getNameList());
            textField.setText("");
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("请输入项目名称");
            a.show();
        }
    }

    @FXML
    private void deleteButtonOnClicked(){
        if(!Objects.equals(selectedItem,"")&&!Objects.equals(selectedItem,null)){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("确定删除该项目吗？");
            Optional<ButtonType> result = a.showAndWait();
            if (result.get() == ButtonType.OK){
                projectManager.deleteProject(selectedItem);
                saver.write("projectManager.txt",projectManager);
                selectedItem = null;
                a.close();
                ObservableList<String> items = FXCollections.observableArrayList(projectManager.getNameList());
                listView.setItems(items);
            }
        }else {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("请选择想删除的项目");
            a.show();
        }


    }

    public Project getSelectedProject() {
        return selectedProject;
    }
}
