package app.model;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Objects;

public class ProjectManager implements Serializable {
    private ArrayList<Project> manager = new ArrayList<Project>();
    public ProjectManager(){
    }
    public void addProject(Project project){
        manager.add(project);
    }
    public void deleteProject(String projectName){
        manager.removeIf(project -> project.getName().equals(projectName));
    }
    public ArrayList<String> getNameList(){
        ArrayList<String> nameList = new ArrayList<String>();
        for (Project project: manager){
            nameList.add(project.getName());
        }
        return nameList;
    }

    public Project getProject(String projectName){ ;
        for (Project project: manager){
            if(Objects.equals(project.getName(),projectName)){
                return project;
            }
        }
        return null;
    }
    public void updateProject(Project oldProject, Project newProject){
        deleteProject(oldProject.getName());
        addProject(newProject);
    }


}
