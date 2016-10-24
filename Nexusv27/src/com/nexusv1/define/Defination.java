package com.nexusv1.define;

public final class Defination {

	private String b = "";
	private String c = "";
	public static String a = "http://localhost:9999/ReportServer/json/product/post";
	private String d = "";

	public Defination() {

		this.b = String.valueOf(this.a) + "/api/v1/project/key/auth";
		this.c = String.valueOf(this.a) + "/api/v1/build/sync/testng";
		this.d = "nexusConfig.json";
	}

	public final String a() {
		return this.d;
	}

	public final String b() {
		return this.b;
	}

	public final String c() {
		return this.c;
	}

}
