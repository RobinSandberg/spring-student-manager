package se.lexicon;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.data_access.StudentManagement;
import se.lexicon.data_access.UserInputService;
import se.lexicon.model.Student;

import java.util.List;

public class SpringApp
{
    private static boolean running = true;
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        UserInputService userInputService= context.getBean(UserInputService.class);

        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        while (running){
            studentManagement.menu();
            int input = userInputService.getInt();
            Student student;
            switch (input){
                case 1:
                    student = studentManagement.create();
                    System.out.println("Do you wanna save following " + student.toString()
                    + "\n1. Yes \n2. No");
                    System.out.print("Make your choose: ");
                    input = userInputService.getInt();
                    if (input == 1){
                        student = studentManagement.save(student);
                        System.out.println(student.toString() + " has been saved.");
                    }else{
                        System.out.println(student.toString() + " was not saved.");
                    }
                    break;
                case 2:
                    System.out.print("Pick Id of student to edit: ");
                    student = studentManagement.find(userInputService.getInt());
                    student = studentManagement.edit(student);
                    System.out.println("The new name for the student is: " + student.toString());
                    break;
                case 3:
                    System.out.print("Pick Id of student to delete: ");
                    input = userInputService.getInt();
                    student = studentManagement.remove(input);
                    if(student != null){
                        System.out.println(student.toString() + " been deleted.");
                    }else{
                        System.out.println("Student id did no exist");
                    }
                    break;
                case 4:
                    System.out.print("Pick id of student you wanna find: ");
                    student = studentManagement.find(userInputService.getInt());
                    if(student != null){
                        System.out.println(student.toString() + " been found.");
                    }else{
                        System.out.println("Student id did no exist");
                    }
                    break;
                case 5:
                    List<Student> students = studentManagement.findAll();
                    for(Student s : students){
                        System.out.println(s.toString());
                    }
                    break;
                case 6:
                    running = false;
                    break;
            }
        }

        context.close();
    }
}
