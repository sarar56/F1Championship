package com.f1.championship.backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.f1.championship.backend.api.models.entity.Driver;
import com.f1.championship.backend.api.models.entity.DriverRanking;
import com.f1.championship.backend.api.models.entity.RaceRanking;
import com.f1.championship.backend.api.models.service.DriverService;

@RestController
public class DriverController {

	/*
	 * Recibo los datos obtenidos en el api rest con los datos de la interfaz
	 * driverService
	 */
	@Autowired
	private DriverService driverService;
//	private IDriverService driverService;

	/*
	 * Muestro los pilotos y los devuelvo en json
	 */
	@GetMapping(value = "/ranking")
	public List<DriverRanking> list() {

		return driverService.getDrivers();

	}

	/*
	 * Muestro un piloto por su id
	 */
	@RequestMapping(value = "/driver", params = "id")
	public Driver getId(@RequestParam final String id) {

		return driverService.getDriver(id);

		// driverService.findAll();
		// return driverService.getDriver(id);
	}

	/*
	 * Muestro una carrera comun en todos los pilotos
	 */

	@RequestMapping(value = "/ranking", params = "id")
	public RaceRanking getRaceId(@RequestParam final String id) {

		return driverService.getRanking(id);

//		final Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
//		driverService.findAll();
//		return gson.toJson(driverService.getRaces(id));
	}

}
