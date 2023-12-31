package springboot.app.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.app.dtos.CareerDTO;
import springboot.app.dtos.ReportDTO;
import springboot.app.model.Career;
import springboot.app.repository.CareerRepository;
import springboot.app.repository.TuitionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service("CareerService")
public class CareerService {

    @Autowired
    private CareerRepository careerRepository;

    @Autowired
    private TuitionRepository tuitionRepository;

    @Transactional
    public List<CareerDTO> getAll() throws Exception {

        var careers = careerRepository.findAll();

        try{
            return careers.stream().map(career -> new CareerDTO()).collect(Collectors.toList());
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Transactional
    public List<CareerDTO> getCareersWithStudents() throws Exception{
        List<CareerDTO> careerDTOS = new ArrayList<>();
        try{
            List<Career> careers = tuitionRepository.getCareersWithStudentsInOrder();
            for (Career c: careers) {
                CareerDTO career = new CareerDTO();
                career.setIdCareer(c.getIdCareer());
                career.setName(c.getName());
                career.setCantEnrolled(c.getTuitions().size());
                careerDTOS.add(career);
            }

            return careerDTOS;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    public List<ReportDTO> getReport() {
        List<ReportDTO> reportInscriptionsDTO = new ArrayList<>();
        List<ReportDTO> reportGraduatesDTO = new ArrayList<>();
        List<ReportDTO> report = new ArrayList<>();

        int yearReport;
        Long cantGraduates, cantInscription;
        String careerName;

        reportInscriptionsDTO = tuitionRepository.getCountInscriptionsByCareer();
        reportGraduatesDTO = tuitionRepository.getCountGraduatesByCareer();

        for (ReportDTO inscriptions : reportInscriptionsDTO) {
            for (ReportDTO graduates : reportGraduatesDTO) {
                if (inscriptions.getYearReport() == graduates.getYearReport()
                        && Objects.equals(inscriptions.getNameCareer(), graduates.getNameCareer())) {
                    careerName = inscriptions.getNameCareer();
                    cantGraduates = graduates.getEnrolled();
                    cantInscription = inscriptions.getEnrolled();
                    yearReport = inscriptions.getYearReport();
                    ReportDTO r = new ReportDTO(careerName, cantInscription, cantGraduates, yearReport);
                    report.add(r);
                }
            }
        }

        return report;
    }
}
