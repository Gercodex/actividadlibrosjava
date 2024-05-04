package com.cursoalura.actividadlibros.modulos;

public interface IConversor {
    <T> T convertir(String json, Class<T> clase);
}
