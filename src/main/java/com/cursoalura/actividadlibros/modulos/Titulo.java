package com.cursoalura.actividadlibros.modulos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Titulo(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<Autor> autores
        /*@JsonAlias("subjects") List<String> temas,
        @JsonAlias("downloads") Integer descargas*/
) {
}
