package com.f1.championship.backend.api.models.entity;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Championship {

	@SerializedName("data")
	@Expose
	private List<Driver> data = null;

	public List<Driver> getData() {
		return data;
	}

	public void setData(final List<Driver> data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = ((result * 31) + ((this.data == null) ? 0 : this.data.hashCode()));
		return result;
	}

	@Override
	public boolean equals(final Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Championship) == false) {
			return false;
		}
		final Championship rhs = ((Championship) other);
		return ((this.data == rhs.data) || ((this.data != null) && this.data.equals(rhs.data)));
	}

}