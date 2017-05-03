package Projects;
import Projects.Controller.Controller;
import Projects.Intergration.*;
import Projects.Model.InspectionDTO;
import Projects.View.View;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Controller contr = new Controller();
        View view = new View(contr);
        view.initiateInspection();

    }
}
