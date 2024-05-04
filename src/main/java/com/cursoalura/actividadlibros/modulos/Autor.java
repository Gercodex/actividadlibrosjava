package com.cursoalura.actividadlibros.modulos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Autor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") Integer facheNacimiento,
        @JsonAlias("death_year") Integer fechaFalleimiento
) {
}
