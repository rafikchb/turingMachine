package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.LinkedList;

public class Vertice {
    private String name;
    private LinkedList<Edge> edges = new LinkedList<Edge>();
    private TuringMachine assosiatedTuringMachine =  null;

    public Vertice(JSONObject jsonVertice, TuringMachine assosiatedTuringMachine) {
        // chaque vertice doit conaitre la machine de turing a la qeulle elle est asossier
        this.assosiatedTuringMachine = assosiatedTuringMachine;
        // extracting the vertice name
        this.name = (String) ((JSONObject) jsonVertice).get("name");
        // extracting all the edges of these vertice
        JSONArray jsonEdges = (JSONArray) jsonVertice.get("edges");
        for (Object jsonEdge : jsonEdges) {
            Edge edge = new Edge();
            edge.setAlphabet((String) ((JSONObject) jsonEdge).get("alphabet"));
            edge.setSens((String) ((JSONObject) jsonEdge).get("sens"));
            edge.setNextVertice((String) ((JSONObject) jsonEdge).get("nextVertice"));
            this.edges.add(edge);
        }
    }

    public String getName() {
        return name;
    }

    public Vertice getNextVertice(String alphabet) {
        // on parcour les edge de ce vertice
        for (Edge edge : this.getEdges()) {
            if (edge.getAlphabet().contains(alphabet)) {
                return this.assosiatedTuringMachine.getVertices().get(edge.getNextVertice());
            }
        }
        // pour dire que le vertice suivant na pas de suite .
        return null;
    }
    public LinkedList<Edge> getEdges() {
        return edges;
    }
}
