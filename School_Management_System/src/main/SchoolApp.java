package main;

import entities.Student;
import entities.SeniorStudent;
import services.StudentService;
import utils.InputHandler;

public class SchoolApp {

    // one service object for the whole app 
    private StudentService studentService = new StudentService();
    private InputHandler input = new InputHandler();

    public static void main(String[] args) {
        SchoolApp app = new SchoolApp();
        app.loadSampleData();
        app.run();
    }

