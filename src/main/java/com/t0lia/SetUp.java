package com.t0lia;

import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;

import static com.t0lia.ExceptionWrapper.wrap;

class SetUp {
    static void unirest() {
        ObjectMapper mapper = new ObjectMapper() {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();

            public String writeValue(Object value) {
                return wrap(() -> mapper.writeValueAsString(value));
            }

            public <T> T readValue(String value, Class<T> valueType) {
                return wrap(() -> mapper.readValue(value, valueType));
            }
        };
        Unirest.setObjectMapper(mapper);
    }
}
