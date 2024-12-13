package com.varun.springmvc.typeconversion.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.varun.springmvc.typeconversion.model.NestedInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NestedInputConverter implements Converter<String, NestedInput> {

    private final ObjectMapper objectMapper;

    public NestedInputConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public NestedInput convert(String source) {
        try {
            return objectMapper.readValue(source, NestedInput.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid JSON format for NestedInput", e);
        }
    }
}