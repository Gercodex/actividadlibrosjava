package com.cursoalura.actividadlibros;

import com.cursoalura.actividadlibros.principal.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActividadlibrosApplication {

	static Principal principal;
	public static void main(String[] args) {
		SpringApplication.run(ActividadlibrosApplication.class, args);
		principal = new Principal();
        try {
            principal.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
