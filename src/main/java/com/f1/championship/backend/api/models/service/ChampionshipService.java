package com.f1.championship.backend.api.models.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.f1.championship.backend.api.models.entity.Championship;
import com.f1.championship.backend.api.models.entity.Driver;
import com.f1.championship.backend.api.models.entity.Race;
import com.f1.championship.backend.api.models.entity.RaceResult;
import com.google.gson.Gson;

/**
 * Componente que carga los datos provenientes del fichero en formato JSON.
 *
 */
@Component
public class ChampionshipService {

	/**
	 * Mapa que contiene los datos para el sistema de puntos.
	 *
	 * @see https://es.wikipedia.org/wiki/Sistemas_de_puntuaci%C3%B3n_de_F%C3%B3rmula_1
	 */
	private static final Map<Integer, Integer> POINTS_MAP = Map.of(1, 25, 2, 18, 3, 15, 4, 12, 5, 10, 6, 8, 7, 6, 8, 4,
			9, 2, 10, 1);
	
	/**
	 * Los datos del campeonato leidos del fichero JSON
	 */
	private static Championship championship;
	/**
	 * Mapa que contiene los datos de los pilotos con clave su identificador.
	 */
	private static Map<String, Driver> drivers;
	/**
	 * Mapa que contiene los resultados de las carreras teniendo como clave el
	 * nombre de la carrera / circuito.
	 */
	private static Map<String, List<RaceResult>> races;

	/**
	 *
	 * Constructor del componente. El cual al instanciarse en el momento de arrancar
	 * la aplicacion cargara los datos del campeonato.
	 *
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	public ChampionshipService() throws FileNotFoundException, ParseException {

		// Leemos el fichero y al usar Gson facilitara el proceso,
		// Observar la clase Championship para ver los detalles intrinsecos de como se
		// parsea.
		final Reader reader = new FileReader("src/main/resources/data/data.json");
		championship = new Gson().fromJson(reader, Championship.class);

		// TODO: esto simplemente para verificar que los datos se cargan correctamente.
		// final List<Driver> data = championship.getData();
		// for (final Driver driver : data) {
		// System.out.println(driver);
		// }

		// Creamos los mapas para los pilotos y las carreras
		drivers = new HashMap<>();
		races = new HashMap<>();

		// Ahora iteraremos sobre cada unos de los datos de los pilotos e iremos
		// montando las estrucutras de datos necesarias para acceder a los datos mas
		// facilmente posteriormente.
		for (final Driver driver : championship.getData()) {

			// insertamos en el mapa de los pilotos el piloto sobre el que estamos iterando
			drivers.put(driver.getId(), driver);

			// Para dicho piloto extraemos los datos de sus carreras
			final List<Race> driverRaces = driver.getRaces();

			List<RaceResult> list;

			// Iteraremos sobre cada una de sus carreras para
			for (final Race driverRace : driverRaces) {

				// Buscamos los datos de la carrera en nuestra estrucutra
				list = races.get(driverRace.getName());
				// Si no esta, inicializamos su listado de resultados
				if (list == null) {
					list = new ArrayList<>();

				}

				// incluimos el resultado del piloto en dicha carrera
				list.add(new RaceResult(driverRace.getName(), driver.getId(), driverRace.getTime()));

				// A continuacion insertamos en el mapa de las carreras la clave de la carrera
				// junto con la lista de los resultados
				races.put(driverRace.getName(), list);

			}

		}

		// Aqui iteraremos sobre los resultados de las carreras para calcular los puntos
		// obtenidos por cada piloto
		final Set<String> racesKeySet = races.keySet();
		for (final String race : racesKeySet) {

			final List<RaceResult> list2 = races.get(race);
			// Primero ordenamos los resultados de cada carrera
			Collections.sort(list2);

			// Iteramos sobre dichos resultados
			for (int i = 0; i < list2.size(); i++) {

				RaceResult raceResult = list2.get(i);

				// Le damos a cada piloto la posicion obtenida en dicha carrera, ya que los
				// datos estan ordenados
				raceResult.setPosition(i + 1);

				// Aqui le damos los puntos obtenidos en base a su posicion en la carrera
				if (raceResult.getPosition() <= 10) {
					raceResult.setPoints(POINTS_MAP.get(i + 1));
				} else {
					raceResult.setPoints(0);
				}

				// Obtenemos el piloto en cuestion y le sumamos los puntos obtenidos en la
				// carrera
				Driver driver2 = drivers.get(raceResult.getDriverId());
				driver2.setPoints(driver2.getPoints() + raceResult.getPoints());

				List<Race> races2 = driver2.getRaces();

				// Buscamos para dicho piloto la carrera en cuestion y le indicamos la posicion
				// obtenida
				for (Race element : races2) {

					if (element.getName().equals(raceResult.getRaceName())) {
						element.setPosition(raceResult.getPosition());

					}

				}

			}

		}

		// Ahora que tenemos las estructuras listas vamos a asignar la posicion en el
		// raking a cada piloto en base a los puntos
		Collection<Driver> values = drivers.values();
		List<Driver> driverListSort = new ArrayList<Driver>();
		driverListSort.addAll(values);

		Collections.sort(driverListSort);

		for (int i = 0; i < driverListSort.size(); i++) {
			driverListSort.get(i).setPosition(i + 1);
		}

	}

	/**
	 * @return the championship
	 */
	public static Championship getChampionship() {
		return championship;
	}

	/**
	 * @param championship the championship to set
	 */
	public static void setChampionship(final Championship championship) {
		ChampionshipService.championship = championship;
	}

	/**
	 * @return the drivers
	 */
	public static Map<String, Driver> getDrivers() {
		return drivers;
	}

	/**
	 * @param drivers the drivers to set
	 */
	public static void setDrivers(final Map<String, Driver> drivers) {
		ChampionshipService.drivers = drivers;
	}

	/**
	 * @return the races
	 */
	public static Map<String, List<RaceResult>> getRaces() {
		return races;
	}

	/**
	 * @param races the races to set
	 */
	public static void setRaces(final Map<String, List<RaceResult>> races) {
		ChampionshipService.races = races;
	}

}
