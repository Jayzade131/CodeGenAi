package com.main.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OpenRouterRequest {

    private List<Message> messages;

    private String model;

    @JsonProperty("max_tokens")
    private Integer maxTokens;

    // Full constructor
    public OpenRouterRequest(List<Message> messages, String model, Integer maxTokens) {
        this.messages = messages;
        this.model = model;
        this.maxTokens = maxTokens;
    }

    // Convenience constructor
    public OpenRouterRequest(List<Message> messages, String model) {
        this(messages, model, 1000);
    }

    // Getters and Setters
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }
}
