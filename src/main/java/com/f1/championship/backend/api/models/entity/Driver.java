package com.f1.championship.backend.api.models.entity;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Driver implements Comparable<Driver> {

	@SerializedName("_id")
	@Expose
	private String id;
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
	@SerializedName("races")
	@Expose
	private List<Race> races = null;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
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

	public List<Race> getRaces() {
		return races;
	}

	public void setRaces(final List<Race> races) {
		this.races = races;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + ((points == null) ? 0 : points.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((races == null) ? 0 : races.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Driver other = (Driver) obj;
		if (age == null) {
			if (other.age != null) {
				return false;
			}
		} else if (!age.equals(other.age)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (picture == null) {
			if (other.picture != null) {
				return false;
			}
		} else if (!picture.equals(other.picture)) {
			return false;
		}
		if (points == null) {
			if (other.points != null) {
				return false;
			}
		} else if (!points.equals(other.points)) {
			return false;
		}
		if (position == null) {
			if (other.position != null) {
				return false;
			}
		} else if (!position.equals(other.position)) {
			return false;
		}
		if (races == null) {
			if (other.races != null) {
				return false;
			}
		} else if (!races.equals(other.races)) {
			return false;
		}
		if (team == null) {
			if (other.team != null) {
				return false;
			}
		} else if (!team.equals(other.team)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", picture=" + picture + ", age=" + age + ", name=" + name + ", team=" + team
				+ ", races=" + races + ", position=" + position + ", points=" + points + "]";
	}

	@Override
	public int compareTo(final Driver driver2) {
		// TODO: si quieres quitar, le he dado la vuelta para ordenar de mayor a menor 
		// return this.points.compareTo(driver2.points);
		return driver2.points.compareTo(this.points);
	}

}