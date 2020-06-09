package app;
import app.model.Project;
import app.model.ProjectManager;
import app.model.Saver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
    private ListView<String> listView = new ListView<String>();
    private final Saver saver = new Saver();
    private ProjectManager projectManager = new ProjectManager();
    @FXML
    private TextField textField = new TextField();
    @FXML
    private Button addButton;
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
    }

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

    @FXML
    private void addButtonOnClicked(){
        String newProjectName = textField.getText();
        Project newProject = new Project(newProjectName);
        projectManager.addProject(newProject);
        saver.write("projectManager.txt",projectManager);
        ObservableList<String> items = FXCollections.observableArrayList(projectManager.getNameList());
        listView.setItems(items);
        System.out.println(projectManager.getNameList());
        textField.setText("");
    }




}
