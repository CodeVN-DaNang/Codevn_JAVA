package student_management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import student_management.Model.entities.Student;
import student_management.Model.entities.TypeStudent;
import student_management.Model.service.StudentService;

@Controller
@RequestMapping(value = {"/student", "/student/"})
public class StudentController {
    StudentService studentService = new StudentService();

    @GetMapping(value = "")
    public String showList(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "/index";
    }

    // show add
    @GetMapping(value = "/add")
    public String showAdd(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("typeStudentList", studentService.getAllTypeStudents());
        return "/add";
    }
    // action add
    @PostMapping(value = "/add")
    public String addAction(@ModelAttribute("student") Student student ,@RequestParam("typeStudent") int typeId ,Model model){
        student.setTypeStudent(studentService.getTypeStudentById(typeId));;
        System.out.println(typeId);
        studentService.addStudent(student);
        return "redirect:/student/add";
    }
    // show update
    
    // action update

    // action delete

}
