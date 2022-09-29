package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class TuringMachine {
    private Tape tape;// mon ruban .
    private HashMap<String, Vertice> vertices = new HashMap<String, Vertice>(); // list des somet .
    private String initialState;

    public TuringMachine(String fileName) {
        try {
            FileReader program = new FileReader(new File(fileName));
            JSONParser parser = new JSONParser();
            JSONObject jsonProgram = (JSONObject) parser.parse(program);
            // initialasing the tape with the input string
            this.tape = new Tape((String) jsonProgram.get("input"));
            // initialising the inisialState with the start state .
            this.initialState = (String) jsonProgram.get("startState");

            JSONArray jsonVertices = (JSONArray) jsonProgram.get("states");
            for (Object jsonVertice : jsonVertices) {
                // creating a vertices
                String verticeName = (String) ((JSONObject) jsonVertice).get("state");// setting the state name
                Vertice vertice = new Vertice((JSONObject) jsonVertice);// creating the state as vertice .
                // Vertice vertice = new Vertice((JSONObject) jsonVertice, this);// creating the state as vertice .

                this.vertices.put(verticeName, vertice);// adding the state to the vertices hashmap .
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String execute() throws InterruptedException {
        int i = 0;
        System.out.println("Initial Tape : #" + tape.toString()+"#");

        Vertice curentVertice = vertices.get(initialState);
        Edge nextEdge;
        do {
            System.out.println("Round : " + i + " #" + tape.toString()+"#");
            i++;
            nextEdge = curentVertice.getNextEdge(tape.read());
            if (nextEdge != null) {
                tape.write(nextEdge.getReplace(), nextEdge.getDirection());
                curentVertice = vertices.get(nextEdge.getNextVertice());
            }
        } while (nextEdge != null);
        return tape.toString();
    }

    public HashMap<String, Vertice> getVertices() {
        return vertices;
    }

}
