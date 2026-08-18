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

    // main only starts the app; the work is in small methods 
    public void run() {
        boolean exit = false;
        while (exit == false) {
            printMenu();
            int choice = input.getIntInput("Choose:", 1, 4);
            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewAllStudents(); break;
                case 3: searchStudent(); break;
                case 4: exit = true; break;
            }
        }
        System.out.println("Goodbye.");
    }
