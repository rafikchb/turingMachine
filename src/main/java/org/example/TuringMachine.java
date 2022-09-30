package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.HashMap;

public class TuringMachine {
    private Tape tape;
    private HashMap<String, Vertice> vertices = new HashMap<String, Vertice>();
    private String initialState;

    public TuringMachine(String fileName) {
        try {
            FileReader program = new FileReader(fileName);
            JSONParser parser = new JSONParser();
            JSONObject jsonProgram = (JSONObject) parser.parse(program);
            this.tape = new Tape((String) jsonProgram.get("input"));
            this.initialState = (String) jsonProgram.get("startState");
            JSONArray jsonVertices = (JSONArray) jsonProgram.get("states");
            for (Object jsonVertice : jsonVertices) {
                String verticeName = (String) ((JSONObject) jsonVertice).get("state");
                Vertice vertice = new Vertice((JSONObject) jsonVertice);
                this.vertices.put(verticeName, vertice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String execute() throws InterruptedException {
        int i = 0;
        System.out.println("Initial Tape : #" + tape.toString() + "#");
        Vertice curentVertice = vertices.get(initialState);
        Edge nextEdge;
        do {
            Thread.sleep(100);
            // to slow down the print .
            System.out.println("Round : " + i + " #" + tape.toString() + "#");
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
