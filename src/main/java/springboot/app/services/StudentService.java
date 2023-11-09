package springboot.app.services;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springboot.app.dtos.StudentDTO;
import springboot.app.model.Career;
import springboot.app.model.Student;
import springboot.app.model.Tuition;
import springboot.app.repository.CareerRepository;
import springboot.app.repository.StudentRepository;
import springboot.app.repository.TuitionRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("StudentService")
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CareerRepository careerRepository;

    @Autowired
    private TuitionRepository tuitionRepository;



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



    @Transactional
    public StudentDTO save(StudentDTO student) throws Exception{
        System.out.println(student);
        try{
            System.out.println(!studentRepository.existsByDNI(student.getDNI()));
            if(!studentRepository.existsByDNI(student.getDNI())){
                System.out.println("Entramos al if");
                Student entity = new Student();
                entity.setName(student.getName());
                entity.setDNI(student.getDNI());
                entity.setCity(student.getCity());
                entity.setGenre(student.getGenre());
                entity.setLastName(student.getLastName());
                entity.setAge(student.getAge());
                entity.setUniNumber(student.getUniNumber());
                studentRepository.save(entity);
                System.out.println(entity);
                return new StudentDTO(entity.getName(), entity.getCity(), entity.getDNI(),entity.getAge(),entity.getUniNumber(),entity.getLastName(),entity.getGenre());
            }else throw new Exception("Error: Ya existe un usuario con este ID");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
