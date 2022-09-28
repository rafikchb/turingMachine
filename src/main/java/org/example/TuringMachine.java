package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;

public class TuringMachine {
    String tape ;
    private HashMap<String, Vertice> vertices = new HashMap<String, Vertice>();
    // je devrait la changer par une hachmap comme sa je peux trouve la vertice directement .

    public TuringMachine(String fileName , String tape) {
        this.tape = tape;
        JSONArray jsonVertices;
        try {
            File program = new File(fileName);
            FileReader jsonProgram = new FileReader(program);
            JSONParser parser = new JSONParser();
            jsonVertices = (JSONArray) parser.parse(jsonProgram);
            for (Object jsonVertice : jsonVertices) {
                // creating a vertice from the curent name
                String verticeName = (String) ((JSONObject) jsonVertice).get("name");
                Vertice vertice = new Vertice((JSONObject) jsonVertice, this);
                // adding the vertice to the vertices liste
                this.vertices.put(verticeName, vertice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public HashMap<String, Vertice> getVertices() {
        return vertices;
    }

}
