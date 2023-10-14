package com.registroVacinacao.wbservice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PacienteWBService {
    private final RestTemplate restTemplate;

    @Autowired
    public PacienteWBService() {
        this.restTemplate = new RestTemplate();
    }

    public JsonNode listaTodosPacientes() {
        String projectBUrl = "http://localhost:8082/pacientes";
        try {
            String pacienteData = restTemplate.getForObject(projectBUrl, String.class);
            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.readTree(pacienteData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JsonNode buscarPaciente(String id) {
        String projectBUrl = "http://localhost:8082/pacientes" + id;
        try {
            String pacienteData = restTemplate.getForObject(projectBUrl, String.class);
            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.readTree(pacienteData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
