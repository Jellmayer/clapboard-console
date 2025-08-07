package br.com.jellmayer.clapboard.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T parseJson(String json, Class<T> targetClass) {
        try {
            return objectMapper.readValue(json, targetClass);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON", e);
        }
    }
}
