package springboot.app;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springboot.app.utils.AddData;

import java.io.IOException;


@SpringBootApplication
public class ArquiWebIntegrador3 {

    @Autowired
    private AddData cargaDeDatos;
    public static void main(String[] args) {
        SpringApplication.run(ArquiWebIntegrador3.class, args);
    }

    @PostConstruct
    public void init() throws IOException {
        cargaDeDatos.cargarDatosDesdeCSV();
    }
}
