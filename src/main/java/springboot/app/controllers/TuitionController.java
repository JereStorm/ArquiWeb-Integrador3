package springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.app.dtos.TuitionDTO;
import springboot.app.model.Tuition;
import springboot.app.services.TuitionService;

@RestController
@RequestMapping("/tuition")
public class TuitionController {

    @Autowired
    TuitionService tuitionService;

    @PostMapping("")
    public ResponseEntity<?> post(@RequestBody TuitionDTO tuition) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(tuitionService.addTuition(tuition));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
