package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Vertice {
    private String name;
    private HashMap<String, Edge> edges = new HashMap<String, Edge>();

    public Vertice(JSONObject jsonVertice) {

        this.name = (String) ((JSONObject) jsonVertice).get("state");
        JSONArray jsonEdges = (JSONArray) jsonVertice.get("transitions");
        if (jsonEdges == null) {
            edges = null;
            return;
        }

        for (Object jsonEdge : jsonEdges) {
            JSONArray conditions = (JSONArray) (((JSONObject) jsonEdge).get("read"));
            for (Object condition : conditions) {
                Edge edge = new Edge();
                /////
                String replace = ((String) ((JSONObject) jsonEdge).get("replace"));
                if (replace.equals("")) {
                    edge.setReplace((String) condition);
                } else {
                    edge.setReplace(replace);
                }
                edge.setDirection((String) ((JSONObject) jsonEdge).get("direction"));
                edge.setNextVertice((String) ((JSONObject) jsonEdge).get("nextState"));
                edge.setCondition((String) condition);
                this.edges.put((String) condition, edge);
            }
        }
    }

    public String getName() {
        return name;
    }

    public Edge getNextEdge(String condition) {
        if (edges == null) return null;
        return edges.get(condition);
    }
}
