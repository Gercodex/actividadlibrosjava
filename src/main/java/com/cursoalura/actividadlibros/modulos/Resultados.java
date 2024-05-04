package com.cursoalura.actividadlibros.modulos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Resultados(
        @JsonAlias("id") Integer iden,
        @JsonAlias("title") String  titulo,
        @JsonAlias("authors") List<Autor> autores,
        @JsonAlias("subjects") List<String> temas,
        @JsonAlias("download_count") Integer descargas
) {
}
