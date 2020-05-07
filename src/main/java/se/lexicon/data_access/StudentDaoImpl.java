package se.lexicon.data_access;

import org.springframework.stereotype.Component;
import se.lexicon.model.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoImpl implements StudentDao {

    private List<Student> students;

    public StudentDaoImpl(){
        students = new ArrayList<>();
    }

    @Override
    public Student save(Student student) {
        Student addedStudent = null;
        if(!students.contains(student)){
            students.add(student);
            addedStudent = student;
        }
        return addedStudent;
    }

    @Override
    public Student find(int id) {
        Student foundStudent = null;
        for(Student student: students){
            if(student.getId() == id){
                foundStudent = student;
            }
        }
        return foundStudent;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void delete(int id) {
        Student foundStudent = find(id);
        students.remove(foundStudent);
    }
}
