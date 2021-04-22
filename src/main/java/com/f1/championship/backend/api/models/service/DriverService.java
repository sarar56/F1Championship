package com.f1.championship.backend.api.models.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.f1.championship.backend.api.models.entity.Driver;
import com.f1.championship.backend.api.models.entity.DriverRanking;
import com.f1.championship.backend.api.models.entity.RaceDriverResult;
import com.f1.championship.backend.api.models.entity.RaceRanking;
import com.f1.championship.backend.api.models.entity.RaceResult;

@Service
public class DriverService { // implements IDriverService{

	/**
	 * @return
	 */
	public List<DriverRanking> getDrivers() {
		// Obtenemos la coleccion de pilotos
		Collection<Driver> values = ChampionshipService.getDrivers().values();
		// Crearemos una lista de tipo DriverRanking el cual contendra los datos en el
		// formato deseado para exponer por la API
		List<DriverRanking> list = new ArrayList<>();
		DriverRanking driverRanking;
		for (Driver driver : values) {
			driverRanking = new DriverRanking(driver.getPicture(), driver.getAge(), driver.getName(), driver.getTeam(),
					driver.getPosition(), driver.getPoints());
			list.add(driverRanking);
		}

		// Ordenamos el listado en base a la puntuacion, gracias al uso de Comparable
		Collections.sort(list);

		return list;
	}

	/**
	 * Obtendra los datos del piloto
	 *
	 * @param id
	 * @return
	 */
	public Driver getDriver(String id) {
		return ChampionshipService.getDrivers().get(id);
	}

	/**
	 *
	 * Obtiene el ranking de una carrera dada
	 *
	 * @param El ID de la carrera, el cual sera su nombre
	 * @return
	 */
	public RaceRanking getRanking(String id) {

		// Obtenemos los resultados de dicha carrera
		List<RaceResult> list = ChampionshipService.getRaces().get(id);

		List<RaceDriverResult> list2 = new ArrayList<>();

		RaceDriverResult raceDriverResult;

		// Iteramos sobre dichos resultados
		for (RaceResult raceResult : list) {
			String driverId = raceResult.getDriverId();

			// traemos el objeto Driver del elemento en curso para sacar la infomacion del
			// piloto que ademas del resultado de la carera
			Driver driver = ChampionshipService.getDrivers().get(driverId);

			// Construimos el objeto RaceDriverResult que contiene los datos deesados a
			// exponer en la API
			raceDriverResult = new RaceDriverResult(driver.getName(), driver.getPicture(), driver.getTeam(),
					raceResult.getPosition(), raceResult.getPoints(), raceResult.getTime());

			// y lo agregamos a la lista
			list2.add(raceDriverResult);

		}

		// Creamos el objeto RaceRanking, que contendra el nombre de la carrera y el
		// listado de los resultados. Para el nombre accedemos a list.get(0) ya que
		// cualquiera de ellos nos vale para sacar el nombre de la carrera
		RaceRanking raceRanking = new RaceRanking(list.get(0).getRaceName(), list2);

		return raceRanking;
	}

//	@Autowired
//	private DriverDao driverDao;
//
//	@Override
//	public ArrayList<DriverOld> findAll() {
//		return driverDao.findAll();
//	}
//
//	@Override
//	public DriverOld getDriver(String id) {
//		return driverDao.getDriver(id);
//	}
//
//	@Override
//	public ArrayList<DriverOld> getRaces(String id) {
//		return driverDao.getRaces(id);
//	}

}
