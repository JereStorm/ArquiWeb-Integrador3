package springboot.app.utils;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import springboot.app.model.Career;
import springboot.app.model.Student;
import springboot.app.model.Tuition;
import springboot.app.repository.CareerRepository;
import springboot.app.repository.StudentRepository;
import springboot.app.repository.TuitionRepository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

@Component
public class AddData {


    private final StudentRepository studentRepository;
    private final CareerRepository careerRepository;
    private final TuitionRepository tuitionRepository;

    @Autowired
    public AddData(StudentRepository studentRepository, CareerRepository careerRepository, TuitionRepository tuitionRepository) {
        this.studentRepository = studentRepository;
        this.careerRepository = careerRepository;
        this.tuitionRepository = tuitionRepository;
    }


    public void cargarDatosDesdeCSV() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/springboot/app/csv/estudiantes.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
            Student student = new Student();
            for (CSVRecord csvRecord : csvParser) {
                student.setDNI(Long.parseLong(csvRecord.get("DNI")));
                student.setName(csvRecord.get("nombre"));
                student.setLastName(csvRecord.get("apellido"));
                student.setGenre(csvRecord.get("genero"));
                student.setCity(csvRecord.get("ciudad"));
                student.setAge(Integer.parseInt(csvRecord.get("edad")));
                student.setUniNumber(Integer.parseInt(csvRecord.get("LU")));
                studentRepository.save(student);
            }
        }

        archivoCSV = ResourceUtils.getFile("src/main/java/springboot/app/csv/carreras.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
            Career c = new Career();
            for (CSVRecord csvRecord : csvParser) {
                c.setIdCareer(Long.parseLong(csvRecord.get("id_carrera")));
                c.setName(csvRecord.get("carrera"));
                c.setDuration(Integer.parseInt(csvRecord.get("duracion")));
                careerRepository.save(c);

            }
        }

        archivoCSV = ResourceUtils.getFile("src/main/java/springboot/app/csv/estudianteCarrera.csv");


        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
            Tuition t = new Tuition();
            for (CSVRecord csvRecord : csvParser) {
                t.setId(Long.parseLong(csvRecord.get("id")));
                t.setAntiquity(Integer.parseInt(csvRecord.get("antiguedad")));
                t.setInscription(Integer.parseInt(csvRecord.get("inscripcion")));

                int aux = Integer.parseInt(csvRecord.get("graduacion"));
                t.setGraduation(aux);
                /*if(aux != 0){
                    t.setGraduation(aux);
                }else {
                    t.setGraduation(0);
                }*/


                Optional<Career> carrer = careerRepository.findById(Long.parseLong(csvRecord.get("id_carrera")));
                carrer.ifPresent(t::setCareer);

                Optional<Student> student = studentRepository.findById(Long.parseLong(csvRecord.get("id_estudiante")));
                student.ifPresent(t::setStudent);

                tuitionRepository.save(t);
            }
        }
    }

}

