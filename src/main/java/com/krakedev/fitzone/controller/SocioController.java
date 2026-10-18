package com.krakedev.fitzone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.fitzone.entidades.Socio;
import com.krakedev.fitzone.services.ServicioSocio;

@RestController
@RequestMapping("/socios")
public class SocioController {

	private final ServicioSocio servicio;

	public SocioController(ServicioSocio servicio) {
		this.servicio = servicio;
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Socio socio) {
		try {
			Socio creado = servicio.crear(socio);
			return ResponseEntity.status(HttpStatus.CREATED).body(creado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear al Socio");
		}
	}

	@GetMapping
	public ResponseEntity<?> listar() {
		try {
			List<Socio> socios = servicio.listar();
			return ResponseEntity.ok(socios);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar a los socios");
		}
	}

	@GetMapping("/estado")
	public ResponseEntity<?> buscarPorActivo(@RequestParam(required = false) Boolean activo) {
		try {
			List<Socio> socios = new ArrayList<Socio>();

			if (activo != null) {
				socios = servicio.buscarPorEstado(activo);
			}

			if (socios.size() <= 0) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok(socios);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar al socio por activo");
		}

	}
}
