package springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.app.services.CareerService;

@RestController("CareerController")
@RequestMapping("/career")
public class CareerController {

    @Autowired
    private CareerService careerService;

    @GetMapping("")
    public ResponseEntity getAll(){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(careerService.getAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @GetMapping("/inscriptos")
    public ResponseEntity<?> getCareersWhitStudents(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(careerService.getCareersWithStudents());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/report")
    public ResponseEntity<?> getReport(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(careerService.getReport());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
