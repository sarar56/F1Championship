//package com.f1.championship.backend.api.models.dao;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.Reader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.f1.championship.backend.api.models.entity.Driver;
//import com.f1.championship.backend.api.models.entity.DriverOld;
//import com.f1.championship.backend.api.models.entity.RaceOld;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//@Repository
//public class DriverDao implements IDriverDao {
//
//	private final ArrayList<DriverOld> listd;
//
//	public DriverDao(final ArrayList<DriverOld> listd) {
//		this.listd = listd;
//	}
//
//	/*
//	 * Meto los datos del json en un arraylist y muestro los datos ordenados
//	 */
//	@Override
//	public ArrayList<Driver> findAll() {
//		listd.clear();
//		try (Reader reader = new FileReader("src/main/resources/data/data.json")) {
//			final List<Driver> driver = new Gson().fromJson(reader, new TypeToken<List<Driver>>() {
//			}.getType());
//
//			//
//			for (final Driver driver2 : driver) {
//				listd.add(driver2);
//
//			}
//
//		} catch (final FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		} catch (final IOException e) {
//			// TODO Auto-generated catch block
//			//
//
//			e.printStackTrace();
//		}
//
//		Collections.sort(listd, new DriverOld());
//
//		int pos = 1;
//
//		for (final DriverOld driver : listd) {
//			driver.setPosglobal(pos);
//			pos++;
//		}
//		return listd;
//
//	}
//
//	/*
//	 * Muestro un piloto por su id
//	 */
//	@Override
//	public DriverOld getDriver(final String id) {
//		DriverOld d = null;
//
//		for (final DriverOld driver2 : listd) {
//
//			if (driver2.getId().equals(id)) {
//				d = driver2;
//			}
//		}
//
//		final ArrayList<RaceOld> listr = (ArrayList<RaceOld>) d.getRaces();
//		final String iddriv = d.getId();
//		for (final RaceOld race : listr) {
//
//			final ArrayList<DriverOld> driverforrace = getRaces(race.getName());
//
//			for (final DriverOld driverfor : driverforrace) {
//				if (driverfor.getId().equals(iddriv)) {
//					final ArrayList<RaceOld> racesdriv = (ArrayList<RaceOld>) driverfor.getRaces();
//					race.setPosition(racesdriv.get(0).getPosition());
//
//					break;
//				}
//			}
//		}
//		return d;
//	}
//
//	/*
//	 * Muestro los pilotos de una carrera ordenados
//	 */
//	@Override
//	public ArrayList<DriverOld> getRaces(final String id) {
//		final ArrayList<DriverOld> driverinRace = new ArrayList<>();
//
//		for (final DriverOld driverId : listd) {
//			final ArrayList<RaceOld> idRace = new ArrayList<>();
//			final ArrayList<RaceOld> listr = (ArrayList<RaceOld>) driverId.getRaces();
//
//			for (final RaceOld race : listr) {
//
//				if (race.getName().equals(id)) {
//					final DriverOld driv = new DriverOld(driverId);
//					idRace.add(race);
//					driv.setRaces(idRace);
//					driverinRace.add(driv);
//
//					break;
//				}
//			}
//		}
//
//		Collections.sort(driverinRace, new DriverOld());
//
//		int pos = 1;
//
//		for (final DriverOld driverfor : driverinRace) {
//			driverfor.getRaces().get(0).setPosition(pos);
//			pos++;
//		}
//		return driverinRace;
//	}
//
//}
