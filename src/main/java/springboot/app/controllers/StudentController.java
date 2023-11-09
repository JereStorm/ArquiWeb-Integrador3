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

    @GetMapping("/{career}/{city}")
    public ResponseEntity<?> getAllStudentsByCareerAndCity(@PathVariable String career, @PathVariable String city){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudentsByCareerAndCity(career,city));
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

    @GetMapping("/order/name")
    public ResponseEntity<?> getAllByOrder(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllByOrder());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{uniNumber}")
    public ResponseEntity<?> getStudentByUniNumber(@PathVariable int uniNumber){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentByUniNumber(uniNumber));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/genero/{genre}")
    public ResponseEntity<?> getStudentByGenre(@PathVariable String genre){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentByGenre(genre));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}