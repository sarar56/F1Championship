package com.f1.championship.backend.api.models.entity;

import java.util.List;

public class RaceRanking {

	private String raceName;

	private List<RaceDriverResult> results;

	public RaceRanking(String raceName, List<RaceDriverResult> results) {
		this.raceName = raceName;
		this.results = results;
	}

	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public List<RaceDriverResult> getResults() {
		return results;
	}

	public void setResults(List<RaceDriverResult> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "RaceRanking [raceName=" + raceName + ", results=" + results + "]";
	}

}
