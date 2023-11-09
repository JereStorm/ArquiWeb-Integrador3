package springboot.app.services;


import jakarta.transaction.Transactional;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.app.dtos.StudentDTO;
import springboot.app.model.Career;
import springboot.app.model.Student;
import springboot.app.model.Tuition;
import springboot.app.repository.CareerRepository;
import springboot.app.repository.StudentRepository;
import springboot.app.repository.TuitionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("StudentService")
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CareerRepository careerRepository;

    @Autowired
    private TuitionRepository tuitionRepository;


    @Transactional
    public List<StudentDTO> getAll() throws Exception {
        List<StudentDTO> studentsDTO = new ArrayList<>();
        try {
            List<Student> students = studentRepository.findAll();
            //RESOLVER PROBLEMA CON LOS DTO
            for (Student s : students) {
                List<String> carrers = new ArrayList<>();
                for (Tuition c : s.getCareers()) {
                    carrers.add(c.getCareer().getName());
                }
                studentsDTO.add(new StudentDTO(s.getName(), s.getCity(), s.getDNI(), carrers));
            }
            return studentsDTO;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public StudentDTO save(StudentDTO student) throws Exception {
        System.out.println(student);
        try {
            System.out.println(!studentRepository.existsByDNI(student.getDNI()));
            if (!studentRepository.existsByDNI(student.getDNI())) {
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
                return new StudentDTO(entity.getName(), entity.getCity(), entity.getDNI(), entity.getAge(), entity.getUniNumber(), entity.getLastName(), entity.getGenre());
            } else throw new Exception("Error: Ya existe un usuario con este ID");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<StudentDTO> getAllByOrder() throws Exception {
        List<StudentDTO> studentsDTO = new ArrayList<>();
        try {
            List<Student> students = studentRepository.findAllByOrderByName();
            /*List<Student> students = studentRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));*/

            for (Student s : students) {
                List<String> carrers = new ArrayList<>();
                for (Tuition c : s.getCareers()) {
                    carrers.add(c.getCareer().getName());
                }
                studentsDTO.add(new StudentDTO(s.getName(), s.getCity(), s.getDNI(), carrers));
            }
            return studentsDTO;
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public StudentDTO getStudentByUniNumber(int uniNumber) throws Exception {
        Optional<Student> response = studentRepository.findByUniNumber(uniNumber);

        try {
            if (response.isPresent()) {
                Student student = response.get();
                StudentDTO studentDTO = new StudentDTO();
                List<String> careers = new ArrayList<>();
                studentDTO.setName(student.getName());
                studentDTO.setCity(student.getCity());
                studentDTO.setDNI(student.getDNI());
                studentDTO.setAge(student.getAge());
                studentDTO.setLastName(student.getLastName());
                studentDTO.setUniNumber(student.getUniNumber());
                studentDTO.setGenre(student.getGenre());

                for (Tuition career : student.getCareers()) {
                    careers.add(career.getCareer().getName());
                }
                studentDTO.setCareers(careers);
                return studentDTO;
            } else {
                throw new Exception("error, no existe estudiante con ese numero de libreta");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<StudentDTO> getStudentByGenre(String genre) throws Exception {
        List<Student> students = studentRepository.findAllByGenre(genre);
        boolean exist = studentRepository.existsByGenre(genre);
        System.out.println(exist);
        try {
            if (exist) {
                List<StudentDTO> studentDTOS = new ArrayList<>();

                for (Student student : students) {
                    StudentDTO studentDTO = new StudentDTO();
                    List<String> careers = new ArrayList<>();
                    studentDTO.setName(student.getName());
                    studentDTO.setCity(student.getCity());
                    studentDTO.setDNI(student.getDNI());
                    studentDTO.setAge(student.getAge());
                    studentDTO.setLastName(student.getLastName());
                    studentDTO.setUniNumber(student.getUniNumber());
                    studentDTO.setGenre(student.getGenre());

                    for (Tuition career : student.getCareers()) {
                        careers.add(career.getCareer().getName());
                    }
                    studentDTO.setCareers(careers);
                    studentDTOS.add(studentDTO);
                }

                return studentDTOS;
            } else {
                throw new Exception("error, el genero no existe");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public List<StudentDTO> getAllStudentsByCareerAndCity(String nameCareer, String city) throws Exception {
        try {
            if(careerRepository.existsByName(nameCareer) && studentRepository.existsByCity(city)){
                List<Student> students = tuitionRepository.findAllByCareerAndCity(nameCareer,city);
                List<StudentDTO> studentDTOS = new ArrayList<>();
                for (Student student : students) {
                    StudentDTO studentDTO = new StudentDTO();
                    List<String> careers = new ArrayList<>();
                    studentDTO.setName(student.getName());
                    studentDTO.setCity(student.getCity());
                    studentDTO.setDNI(student.getDNI());
                    studentDTO.setAge(student.getAge());
                    studentDTO.setLastName(student.getLastName());
                    studentDTO.setUniNumber(student.getUniNumber());
                    studentDTO.setGenre(student.getGenre());

                    for (Tuition tuition : student.getCareers()) {
                        careers.add(tuition.getCareer().getName());
                    }
                    studentDTO.setCareers(careers);
                    studentDTOS.add(studentDTO);
                }
                return studentDTOS;
            }else
                throw new Exception("Error:La ciudad del estudiante o la carrera que ingreso no existe");

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
