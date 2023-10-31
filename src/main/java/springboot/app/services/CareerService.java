package springboot.app.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.app.dtos.CareerDTO;
import springboot.app.repository.CareerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service("CareerService")
public class CareerService {

    @Autowired
    private CareerRepository careerRepository;

    @Transactional
    public List<CareerDTO> getAll() throws Exception {

        var careers = careerRepository.findAll();

        try{
            return careers.stream().map(career -> new CareerDTO()).collect(Collectors.toList());
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
