package org.example;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.HashMap;

public class Vertice {
    private String name;
    private HashMap<String, Edge> edges = new HashMap<String, Edge>();
    public Vertice(JSONObject jsonVertice) {

        this.name = (String) ((JSONObject) jsonVertice).get("state"); // setting the vertice name .
        JSONArray jsonEdges = (JSONArray) jsonVertice.get("transitions");// getting all the transitions as edges.
        if (jsonEdges == null) {
            edges = null;
            return;
        }
        for (Object jsonEdge : jsonEdges) {
            String condition = (String) ((JSONObject) jsonEdge).get("read");
            for (int i = 0; i < condition.length(); i++) {
                Edge edge = new Edge();
                edge.setReplace(((String) ((JSONObject) jsonEdge).get("replace")));
                edge.setDirection((String) ((JSONObject) jsonEdge).get("direction"));
                edge.setNextVertice((String) ((JSONObject) jsonEdge).get("nextState"));
                this.edges.put(String.valueOf(condition.charAt(i)), edge);
            }
        }
    }

    public String getName() {
        return name;
    }

    public Edge getNextEdge(String condition) {
        if (edges == null) return null;
        return edges.get(condition); // peut retourner null si la condition nai pas dans no transition , ou ida kayen edge sur kayen nex state
    }
}
