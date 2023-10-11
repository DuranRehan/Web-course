package g56055.webg5.pae.business;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g56055.webg5.pae.model.Course;
import g56055.webg5.pae.model.CourseDB;
import g56055.webg5.pae.model.Student;
import g56055.webg5.pae.model.StudentDB;

@Service
public class PAE {
    @Autowired
    CourseDB courseDB;

    @Autowired
    StudentDB studentDB;

    public Iterable<Course> getCourse() {
        return courseDB.findAll();
    }

    public Course getCourse(String id) {
        return courseDB.findById(id).get();
    }

    public void addCourse(Course course) {
        Logger log = LoggerFactory.getLogger("webg5.App");
        log.error("Course added: " + course);
        courseDB.save(course);
    }

    public Iterable<Student> getStudent() {
        return studentDB.findAll();
    }

    public Student getStudent(int id) {
        return studentDB.findById(id).get();
    }

    public void addStudent(Student student) {
        Logger log = LoggerFactory.getLogger("webg5.App");
        log.error("Student added: " + student);
        studentDB.save(student);
    }

    public void registerStudentCourse(int studentId, String courseId) {
        Student student = studentDB.findById(studentId).get();
        Course course = courseDB.findById(courseId).get();
        student.getCourses().add(course);
        course.getStudents().add(student);
        courseDB.save(course);
    }

    public Iterable<Student> filterStudent(String filter_name) {
        return studentDB.findByNameContainingIgnoreCase(filter_name);
    }



    
    public void RequestDerived() {
        var test = courseDB.findByCreditsGreaterThanEqual(10);
        var test2 = courseDB.findByIdLike("CAI%");
        System.out.println(test+"\n"+test2);
    }

    public void queryRequestTest() {
        var test = studentDB.getAllStudentName();
        System.out.println( "getAllStudentName");
        for(var student : test) {
            System.out.println(student);
        }
        System.out.println();
        var test2 = studentDB.getAllStudentMatriculeAndName();
        System.out.println("getAllStudentMatriculeAndName");
        for(var student : test2) {
            for(int i = 0; i < student.length; i++) {
                System.out.print(student[i] + " ");
            }
            System.out.println();
        }
        System.out.println();
        var test3 = studentDB.getAllStudentNameAndCourseCredit();
        System.out.println("getAllStudentNameAndCourseCredit");
        for(var object : test3) {
            for(int i = 0; i < object.length; i++) {
                System.out.print(object[i] + " ");
            }
            System.out.println();
        }
        System.out.println();
        var test4 = studentDB.getAllStudentNameAndCourseCreditGreaterThan(1);
        System.out.println("getAllStudentNameAndCourseCreditGreaterThan");
        for(var object : test4) {
            for(int i = 0; i < object.length; i++) {
                System.out.print(object[i] + " ");
            }
            System.out.println();
        }
    }
}