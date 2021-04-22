package com.f1.championship.backend.api.models.entity;

public class RaceDriverResult {

	private String driverName;
	private String picture;
	private String team;
	private Integer position;
	private Integer points;
	private String time;

	public RaceDriverResult(String driverName, String picture, String team, Integer position, Integer points,
			String time) {
		this.driverName = driverName;
		this.picture = picture;
		this.team = team;
		this.position = position;
		this.points = points;
		this.time = time;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "RaceDriverResult [driverName=" + driverName + ", picture=" + picture + ", team=" + team + ", position="
				+ position + ", points=" + points + ", time=" + time + "]";
	}

}
