package com.example.zzmdemo.core.response;

import java.util.List;

public class PageResponse<T> implements Response {
	private String code;
	private String msg;
	private Integer page;
	private Long records;
	private List<T> datas;
	

    public PageResponse(List<T> datas, Integer page, Long records) {
        this.code = "1";
        this.msg = "success";
        this.datas = datas;
        this.page=page;
        this.records=records;
    }
	public PageResponse(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

    
    public List<T> getDatas() {
        return datas;
    }


	public Integer getPage() {
		return page;
	}


	public Long getRecords() {
		return records;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMsg() {
		return msg;
	}
}
