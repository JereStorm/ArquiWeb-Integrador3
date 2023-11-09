package springboot.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.app.dtos.StudentDTO;
import springboot.app.services.CareerService;
import springboot.app.services.StudentService;

@RestController("StudentController")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }


    }



    @PostMapping("")
    public ResponseEntity<?> post(@RequestBody StudentDTO student){
        System.out.println(student);
        try{
            return ResponseEntity.status(HttpStatus.OK).body(studentService.save(student));
        }catch (Exception e){
            //
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }




}
