package springboot.app.services;

import jakarta.transaction.Transactional;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.app.dtos.TuitionDTO;
import springboot.app.model.Career;
import springboot.app.model.Student;
import springboot.app.model.Tuition;
import springboot.app.repository.CareerRepository;
import springboot.app.repository.StudentRepository;
import springboot.app.repository.TuitionRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service("TuitionService")
public class TuitionService {

    @Autowired
    private TuitionRepository tuitionRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CareerRepository careerRepository;

@Transactional
    public TuitionDTO addTuition(TuitionDTO tuitionDTO) throws Exception {
        Optional<Student> studentOptional = studentRepository.findByDNI(tuitionDTO.getDNI());
        Optional<Career> careerOptional = careerRepository.findById(tuitionDTO.getId_career());

        if (studentOptional.isPresent() && careerOptional.isPresent()){

            Career career = careerOptional.get();
            Student student = studentOptional.get();

            if(!tuitionRepository.existsByStudentAndCareer(student,career)){

                Tuition tuition = new Tuition();
                tuition.setCareer(career);
                tuition.setStudent(student);
                tuition.setAntiquity(0);
                tuition.setGraduation(0);
                tuition.setInscription(LocalDate.now().getYear());
                tuitionRepository.save(tuition);

                career.addTuition(tuition);
                careerRepository.save(career);

                student.addTuition(tuition);
                studentRepository.save(student);

                TuitionDTO tuitionResponse = new TuitionDTO();
                tuitionResponse.setDNI(tuition.getStudent().getDNI());
                tuitionResponse.setName(tuition.getStudent().getName());
                tuitionResponse.setId_career(tuition.getCareer().getIdCareer());
                tuitionResponse.setId(tuition.getId());
                tuitionResponse.setLastName(tuition.getStudent().getLastName());
                tuitionResponse.setInscription(tuition.getInscription());
                tuitionResponse.setCareerName(tuition.getCareer().getName());

                return tuitionResponse;
            }else
                throw new Exception("Error: La Matricula que quiere crear ya existe!!");
        }else
            throw new Exception("Error: El estudiante o la carrera que ingreso no existe!!");
    }


}
