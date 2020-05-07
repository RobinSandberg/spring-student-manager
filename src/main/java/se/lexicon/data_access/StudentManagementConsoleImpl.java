package se.lexicon.data_access;

import se.lexicon.model.Student;

import java.util.List;

public class StudentManagementConsoleImpl implements StudentManagement {

    private UserInputService userInputService;
    private StudentDao studentDao;
    private static int counterId = 0;

    public StudentManagementConsoleImpl(UserInputService userInputService, StudentDao studentDao){
        this.userInputService = userInputService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        Student student = new Student();
        student.setId(++counterId);
        System.out.print("Type in your name: ");
        student.setName(userInputService.getString());
        while (student.getName().isEmpty()){
            System.out.print("Invalid name try again: ");
            student.setName(userInputService.getString());
        }
        return student;
    }

    @Override
    public Student save(Student student) {
        student = studentDao.save(student);
        return student;
    }

    @Override
    public Student find(int id) {
        Student student = studentDao.find(id);
        return student;
    }

    @Override
    public Student remove(int id) {
        Student student = find(id);
        if(student != null) {
            studentDao.delete(student.getId());
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        System.out.print("Change name " + student.getName() + " to: ");
        student.setName(userInputService.getString());
        return student;
    }

    public void menu(){
        System.out.println("\nwelcome to student manager make your choose." +
                "\n1. Create student." +
                "\n2. Edit student." +
                "\n3. Delete student." +
                "\n4. Find student by id." +
                "\n5. Find all students." +
                "\n6. Exit student manager.");
    }
}
