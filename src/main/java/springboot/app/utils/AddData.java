package springboot.app.utils;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import springboot.app.repository.CareerRepository;
import springboot.app.repository.StudentRepository;
import springboot.app.repository.TuitionRepository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class AddData {

    private final StudentRepository studentRepository;
    private final CareerRepository careerRepository;
    private final TuitionRepository tuitionRepository;

    public AddData(StudentRepository studentRepository, CareerRepository careerRepository, TuitionRepository tuitionRepository) {
        this.studentRepository = studentRepository;
        this.careerRepository = careerRepository;
        this.tuitionRepository = tuitionRepository;
    }

    public void cargarDatosDesdeCSV() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/springboot/app/csv/estudiante.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
//                Direccion direccion = new Direccion();
//                direccion.setCiudad(csvRecord.get("ciudad"));
//                direccion.setCalle(csvRecord.get("calle"));
//                direccionRepository.save(direccion);

//                A IMPLEMENTAR ESTUDIANTE
            }
        }

        archivoCSV = ResourceUtils.getFile("src/main/java/springboot/app/csv/carreras.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
//                Direccion direccion = new Direccion();
//                direccion.setCiudad(csvRecord.get("ciudad"));
//                direccion.setCalle(csvRecord.get("calle"));
//                direccionRepository.save(direccion);

//                A IMPLEMENTAR CARRERAS
            }
        }

        archivoCSV = ResourceUtils.getFile("src/main/java/springboot/app/csv/estudianteCarrera.csv");


        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
//                Direccion direccion = new Direccion();
//                direccion.setCiudad(csvRecord.get("ciudad"));
//                direccion.setCalle(csvRecord.get("calle"));
//                direccionRepository.save(direccion);

//                A IMPLEMENTAR ESTUDIANTE-CARRERA
            }
        }
    }

}

