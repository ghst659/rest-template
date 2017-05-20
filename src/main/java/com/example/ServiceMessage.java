package com.example;

public class ServiceMessage {
	private String text = null;
	public ServiceMessage() {
		// pass
	}
	public ServiceMessage(String message) {
		text = message;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
