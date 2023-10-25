package springboot.app.dtos;

public class StudentDTO {

    private String name;

    private String city;

    private Long DNI;

    private String careerName;

    public StudentDTO(String name, String city, Long DNI, String careerName) {
        this.name = name;
        this.city = city;
        this.DNI = DNI;
        this.careerName = careerName;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Long getDNI() {
        return DNI;
    }

    public String getCareerName() {
        return careerName;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", DNI=" + DNI +
                ", careerName='" + careerName + '\'' +
                "} \n";
    }
}
