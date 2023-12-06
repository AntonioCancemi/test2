package com.json.test.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.test.entities.JsonbEntity;
import com.json.test.entities.TestJson;
import com.json.test.repository.IJsonbRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


@Service
public class JsonbService {

       @Autowired
       IJsonbRepo repo;
@Autowired
EntityManager entityManager;
    public void saveJsonB() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Crea un oggetto Java da salvare
        JsonbEntity jsonbEntity = new JsonbEntity();
        // Imposta i valori dell'oggetto...
        TestJson testJson = new TestJson("pippo","pluto","Milano");

        // Converte l'oggetto Java in una stringa JSON
            String jsonString = objectMapper.writeValueAsString(testJson);

        // Crea un'istanza di JsonB e imposta la colonna jsonb
        jsonbEntity.setJsonData(jsonString);

        // Salva l'istanza nel database
            repo.save(jsonbEntity);
    }
    public String extractFieldFromJsonB(Long id, String fieldName) {
        Query query = entityManager.createNativeQuery("SELECT json_data->>'" + fieldName + "' FROM secondary_table WHERE id = :id");
        query.setParameter("id", id);
        return (String) query.getSingleResult();
    }

    public void sendCSV () throws IOException {
        String filePath="C:\\Users\\Utente\\Desktop\\HubEni\\kraken-int\\test\\src\\main\\resources\\CSV\\test.csv";
        try (BufferedWriter writer=new BufferedWriter(new FileWriter(filePath))){
            writer.write("nome");
            writer.newLine();
            writer.write(extractFieldFromJsonB(1L,"nome"));
            writer.newLine();
            System.out.println("file creato");
        }catch (IOException e){
            System.out.println("errore");
        }
    }
    public void sendCSV2 () throws IOException {
        String filePath="C:\\Users\\Utente\\Desktop\\HubEni\\kraken-int\\test\\src\\main\\resources\\CSV\\test2.csv";
        try (PrintWriter writer=new PrintWriter(new FileWriter(filePath))){

            String header = "NomeColonna1,NomeColonna2,NomeColonna3";
            writer.println(header);
            String[] dataRow= {extractFieldFromJsonB(1L,"nome"),extractFieldFromJsonB(1L,"cognome"),extractFieldFromJsonB(1L,"citta")};
            writer.println(String.join(";",dataRow));
            System.out.println("file creato");
        }catch (IOException e){
            System.out.println("errore");
        }
    }
}
