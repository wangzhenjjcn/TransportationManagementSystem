package org.myazure.transportation.response;

import java.util.List;

import org.myazure.response.StatusResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsersListResponse extends StatusResponse {

	@JsonProperty("data")
	private List<String> users;

	public UsersListResponse() {
		super();
	}

	public UsersListResponse(String msg) {
		super();
	}

	public UsersListResponse(String msg, boolean success) {
		super();
	}

	public UsersListResponse(String msg, int code, boolean success) {
		super();
	}

}
