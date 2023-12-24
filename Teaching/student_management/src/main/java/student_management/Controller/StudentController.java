package student_management.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import student_management.Model.Entity.Student;
import student_management.Model.Entity.TypeStudent;
import student_management.Model.service.StudentService;

@Controller
@RequestMapping(value = "/")
public class StudentController {
    @Autowired
    StudentService studentService = new StudentService();

    // show a list of student
    @GetMapping(value = "/")
    public String doGet(Model model) {
        ArrayList<Student> students = studentService.findAllStudent();
        model.addAttribute("studentList", students);
        return "index";
    }

    // add new Student
    @GetMapping(value = "/add")
    public String showAddTemp(Model model, Student student, boolean flag) {
        String message = "";
        ArrayList<TypeStudent> typeStudentList = studentService.findAllTypeStudents();
        if (flag == true) {
            message = "Add success";
        } else {
            message = "Add fail";
        }
        model.addAttribute("typeStudentList", typeStudentList);
        model.addAttribute("student", student);
        model.addAttribute("message", message);
        return "add";
    }

    @PostMapping(value = "/add/addNew")
    public String addNew(@ModelAttribute("student") Student student, Model model) {
        boolean flag = false;
        // int typeStudentId = student.getTypeStudent().getTypeStudentId();
        flag = studentService.addNewStudent(student);
        return showAddTemp(model, student, flag);
    }

    // view and edit
    @GetMapping(value = "/view/{id}")
    public String showInforStudent(@PathVariable(name = "id") int id, Model model) throws Exception {
        String message = "";
        Student student = studentService.findStudentById(id);
        if (student != null) {
            model.addAttribute("student", student);
        } else {
            message = "Student not found";
        }
        model.addAttribute("message", message);
        System.out.println(id);
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editStudent(@ModelAttribute("student") Student student, Model model) throws Exception {
        boolean flag = false;
        flag = studentService.updateStudent(student);
        System.out.println(student.toString());
        return showInforStudent(Integer.parseInt(student.getIdStudent()), model);
    }

    // delete student
    @GetMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable(name = "id") int id, Model model) {
        boolean flag = false;
        String message = "";
        flag = studentService.deleteStudent(id);
        if (flag) {
            message = "Delete success";
        } else {
            message = "Delete fail";
        }
        model.addAttribute("message", message);
        return doGet(model);
    }

}
