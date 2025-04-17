package com.main.dto;

public class Choice {

    private Message message;

    public Choice(Message message) {
        this.message = message;
    }

    // Getters and Setters
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
