package app.model;

import java.util.ArrayList;
import java.io.Serializable;
public class ProjectManager implements Serializable {
    private ArrayList<Project> manager = new ArrayList<Project>();
    public ProjectManager(){
    }
    public void addProject(Project project){
        manager.add(project);
    }
    public void deleteProject(Project project){
        manager.remove(project);
    }
    public ArrayList<String> getNameList(){
        ArrayList<String> nameList = new ArrayList<String>();
        for (Project project: manager){
            nameList.add(project.getName());
        }
        return nameList;
    }

}
