package com.tests.constants;

public enum EndPoint {

	LOGIN(""),
	APILOGIN(""),
	HOME("");


	public final String url;

	EndPoint(String url) {
		this.url = url;
	}
}
