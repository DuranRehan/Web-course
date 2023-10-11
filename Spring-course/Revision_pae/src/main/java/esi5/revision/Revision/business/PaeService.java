package esi5.revision.Revision.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esi5.revision.Revision.model.AnnualProgram;
import esi5.revision.Revision.model.AnnualProgramRepository;
import esi5.revision.Revision.model.Section;
import esi5.revision.Revision.model.Student;
import esi5.revision.Revision.model.StudentRepository;

@Service
public class PaeService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AnnualProgramRepository annualRepository;

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    public AnnualProgram getAnnualProgramByStudentId(int id) {
        return annualRepository.findByStudentNumber(id);
    }

    public Iterable<Student> getAllStudentsWithCriteria(int number, String name, int bloc, Section section) {
        
        return studentRepository.findByNumberOrNameContainingOrSectionOrBloc(number, name, section, bloc);
    }

    public int getStudentByUsername(int number) {
        return studentRepository.findByNumber(number).getNumber();
    }

}
