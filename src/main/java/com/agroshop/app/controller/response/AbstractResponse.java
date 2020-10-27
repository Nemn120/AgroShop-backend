package com.agroshop.app.controller.response;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public abstract class AbstractResponse<T> implements Serializable{
	private static final long serialVersionUID = 1L;	
	public static final String SUCCESS = "1";
	public static final String ERROR = "0";
	
	private String responseCode;
	private String responseMessage;
	private List<String> errorList;
	private List<String> messageList;
	private List<T> datalist;
	private T data;
	private Map<Integer,List<T>> dataMap;



	public Map<Integer, List<T>> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<Integer, List<T>> map) {
		this.dataMap = map;
	}

	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public List<String> getErrorList() {
		return errorList;
	}
	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}
	public List<String> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}
	public List<T> getDatalist() {
		return datalist;
	}
	public void setDatalist(List<T> datalist) {
		this.datalist = datalist;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	

}
