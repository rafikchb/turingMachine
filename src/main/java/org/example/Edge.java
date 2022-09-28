package org.example;

public class Edge {
    private String alphabet;
    private String sens;
    private String nextVertice;

    public void setSens(String sens) {
        this.sens = sens;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public String getSens() {
        return sens;
    }

    public String getNextVertice() {
        return nextVertice;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public void setNextVertice(String nextVertice) {
        this.nextVertice = nextVertice;
    }
}
