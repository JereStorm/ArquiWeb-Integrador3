package springboot.app.dtos;

import java.util.Objects;

public class ReportDTO {

    private String nameCareer;
    private Long enrolled ;
    private Long graduated;

    private int yearReport;
    public ReportDTO(String nameCareer, Long enrolled, Long graduated, int yearReport) {
        this.nameCareer = nameCareer;
        this.enrolled = enrolled;
        this.graduated = graduated;
        this.yearReport = yearReport;
    }

    public ReportDTO(String nameCareer, Long enrolled, int yearReport) {
        this.nameCareer = nameCareer;
        this.enrolled = enrolled;
        this.graduated = graduated;
        this.yearReport = yearReport;
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
                " nameCareer='" + nameCareer + '\'' +
                ", enrolled=" + enrolled +
                ", graduated=" + graduated +
                ", yearReport=" + yearReport +
                '}' + "\n";  // Agregado un salto de línea aquí
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportDTO reportDTO = (ReportDTO) o;
        return yearReport == reportDTO.yearReport && Objects.equals(nameCareer, reportDTO.nameCareer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameCareer, yearReport);
    }

    public String getNameCareer() {
        return nameCareer;
    }

    public Long getEnrolled() {
        return enrolled;
    }

    public Long getGraduated() {
        return graduated;
    }

    public int getYearReport() {
        return yearReport;
    }
}
