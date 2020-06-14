package app.controller;

import app.model.Project;
import javafx.scene.text.Text;

public class subprojectController {
    public Text text;
    private Project project;

    public void setProject(Project selectedProject) {
        this.project = selectedProject;
        text.setText(project.getName());
    }

    public Project getProject() {
        return project;
    }
}
