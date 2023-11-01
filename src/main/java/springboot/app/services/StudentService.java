package springboot.app.services;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.app.dtos.StudentDTO;
import springboot.app.model.Student;
import springboot.app.model.Tuition;
import springboot.app.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service("StudentService")
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;



    @Transactional
    public List<StudentDTO> getAll() throws Exception{

        List<StudentDTO> studentsDTO = new ArrayList<>();
        try{
            List<Student> students = studentRepository.findAll();
            //RESOLVER PROBLEMA CON LOS DTO
            for (Student s: students) {
                List<String> carrers = new ArrayList<>();
                for (Tuition c: s.getCareers()) {
                    carrers.add(c.getCareer().getName());
                }
                studentsDTO.add(new StudentDTO(s.getName(),s.getCity(),s.getDNI(),carrers));
            }
            return studentsDTO;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

}
