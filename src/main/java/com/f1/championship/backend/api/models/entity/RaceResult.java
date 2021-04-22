package com.f1.championship.backend.api.models.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class RaceResult implements Comparable<RaceResult> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss.SSS");

	private String raceName;
	private String driverId;
	private Duration timeDuration;
	private String time;
	private Integer position = 0;
	private Integer points = 0;

	/**
	 * @param raceName
	 * @param driverId
	 * @param timeDuration
	 */
	public RaceResult(final String raceName, final String driverId, final Duration time) {
		this.raceName = raceName;
		this.driverId = driverId;
		this.timeDuration = time;
		this.points = 0;
		this.position = 0;
	}

	public RaceResult(final String raceName, final String driverId, final String time) throws ParseException {
		this.raceName = raceName;
		this.driverId = driverId;
		this.points = 0;
		this.position = 0;

		// Usamos el tipo Duration para gestionar el tiempo empleado en la carrera
		final Date parsedDate = dateFormat.parse(time);
		// se le suma una hora para que el calculo del tiempo de correcto
		parsedDate.setHours(parsedDate.getHours() + 1);

		this.timeDuration = Duration.ofMillis(parsedDate.getTime());

		this.time = time;

	}

	/**
	 * @return the raceName
	 */
	public String getRaceName() {
		return raceName;
	}

	/**
	 * @param raceName the raceName to set
	 */
	public void setRaceName(final String raceName) {
		this.raceName = raceName;
	}

	/**
	 * @return the driverId
	 */
	public String getDriverId() {
		return driverId;
	}

	/**
	 * @param driverId the driverId to set
	 */
	public void setDriverId(final String driverId) {
		this.driverId = driverId;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(final String time) {
		this.time = time;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(final Integer position) {
		this.position = position;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(final Integer points) {
		this.points = points;
	}

	@Override
	public int compareTo(final RaceResult race2) {
		return this.timeDuration.compareTo(race2.timeDuration);
	}

	@Override
	public String toString() {
		return "RaceResult [raceName=" + raceName + ", driverId=" + driverId + ", time=" + time + ", position="
				+ position + ", points=" + points + "]";
	}

}
