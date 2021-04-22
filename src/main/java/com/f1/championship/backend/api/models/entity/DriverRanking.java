package com.f1.championship.backend.api.models.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DriverRanking implements Comparable<DriverRanking> {

	@SerializedName("picture")
	@Expose
	private String picture;
	@SerializedName("age")
	@Expose
	private Integer age;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("team")
	@Expose
	private String team;
	@SerializedName("position")
	@Expose
	private Integer position = 0;
	@SerializedName("points")
	@Expose
	private Integer points = 0;

	public DriverRanking(String picture, Integer age, String name, String team, Integer position, Integer points) {
		this.picture = picture;
		this.age = age;
		this.name = name;
		this.team = team;
		this.position = position;
		this.points = points;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(final String picture) {
		this.picture = picture;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(final Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(final String team) {
		this.team = team;
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
	public String toString() {
		return "DriverRanking [picture=" + picture + ", age=" + age + ", name=" + name + ", team=" + team
				+ ", position=" + position + ", points=" + points + "]";
	}

	@Override
	public int compareTo(final DriverRanking driver2) {
		return driver2.points.compareTo(this.points);
	}

}