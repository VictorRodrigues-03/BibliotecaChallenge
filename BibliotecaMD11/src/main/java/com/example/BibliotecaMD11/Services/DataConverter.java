package com.example.BibliotecaMD11.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter {
     private ObjectMapper mapper = new ObjectMapper();

     public <T> T obterDados(String json, Class<T> classe) {
         try {
             return mapper.readValue(json, classe);
         }catch (JsonProcessingException e){
             throw new RuntimeException(e);
         }
     }

}
