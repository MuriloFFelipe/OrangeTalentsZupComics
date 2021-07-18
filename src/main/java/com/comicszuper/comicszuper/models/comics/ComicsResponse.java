package com.comicszuper.comicszuper.models.comics;

public class ComicsResponse {
	public ComicsData data = new ComicsData();
	private Integer code;
    private String status;
    
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ComicsData getData() {
		return data;
	}

	public void setData(ComicsData data) {
		this.data = data;
	}
}
