package com.krakedev.fitzone.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.fitzone.entidades.Socio;
import com.krakedev.fitzone.repository.SocioRepository;

@Service
public class ServicioSocio {
	
	public final SocioRepository socioRepository;
	
	public ServicioSocio(SocioRepository socioRepository) {
		this.socioRepository = socioRepository;
	}
	
	public Socio crear(Socio socio) {
		if(socio.getEdad() < 14) {
			throw new IllegalArgumentException("La edad mínima permitida es14 años.");
		}
		return socioRepository.save(socio);
	}
	
	public List<Socio> listar() {
	    return socioRepository.findAll();
	}
	
	public List<Socio> buscarPorEstado(boolean activo) {
		return socioRepository.findByActivo(activo);
	}
}
