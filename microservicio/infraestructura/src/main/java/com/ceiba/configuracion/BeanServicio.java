package com.ceiba.configuracion;

import com.ceiba.estudiante.puerto.repositorio.RepositorioEstudiante;
import com.ceiba.estudiante.servicio.ServicioActualizarEstudiante;
import com.ceiba.estudiante.servicio.ServicioCrearEstudiante;
import com.ceiba.estudiante.servicio.ServicioEliminarEstudiante;
import com.ceiba.matricula_estudiante.puerto.repositorio.RepositorioMatriculaEstudiante;
import com.ceiba.matricula_estudiante.servicio.ServicioActualizarMatriculaEstudiante;
import com.ceiba.matricula_estudiante.servicio.ServicioCrearMatriculaEstudiante;
import com.ceiba.matricula_estudiante.servicio.ServicioEliminarMatriculaEstudiante;
import com.ceiba.pension.puerto.repositorio.RepositorioPension;
import com.ceiba.pension.servicio.ServicioActualizarPension;
import com.ceiba.pension.servicio.ServicioCrearPension;
import com.ceiba.pension.servicio.ServicioEliminarPension;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearEstudiante servicioCrearEstudiante(RepositorioEstudiante repositorioEstudiante) {
        return new ServicioCrearEstudiante(repositorioEstudiante);
    }

    @Bean
    public ServicioEliminarEstudiante servicioEliminarEstudiante(RepositorioEstudiante repositorioEstudiante) {
        return new ServicioEliminarEstudiante(repositorioEstudiante);
    }

    @Bean
    public ServicioActualizarEstudiante servicioActualizarEstudiante(RepositorioEstudiante repositorioEstudiante) {
        return new ServicioActualizarEstudiante(repositorioEstudiante);
    }

    @Bean
    public ServicioCrearMatriculaEstudiante servicioCrearMatriculaEstudiante(RepositorioMatriculaEstudiante repositorioMatriculaEstudiante) {
        return new ServicioCrearMatriculaEstudiante(repositorioMatriculaEstudiante);
    }

    @Bean
    public ServicioEliminarMatriculaEstudiante servicioEliminarMatriculaEstudiante(RepositorioMatriculaEstudiante repositorioMatriculaEstudiante) {
        return new ServicioEliminarMatriculaEstudiante(repositorioMatriculaEstudiante);
    }

    @Bean
    public ServicioActualizarMatriculaEstudiante servicioActualizarMatriculaEstudiante(RepositorioMatriculaEstudiante repositorioMatriculaEstudiante) {
        return new ServicioActualizarMatriculaEstudiante(repositorioMatriculaEstudiante);
    }

    @Bean
    public ServicioCrearPension servicioCrearPension(RepositorioPension repositorioPension) {
        return new ServicioCrearPension(repositorioPension);
    }

    @Bean
    public ServicioEliminarPension servicioEliminarPension(RepositorioPension repositorioPension) {
        return new ServicioEliminarPension(repositorioPension);
    }

    @Bean
    public ServicioActualizarPension servicioActualizarPension(RepositorioPension repositorioPension) {
        return new ServicioActualizarPension(repositorioPension);
    }

}
