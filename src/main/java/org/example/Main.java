package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // reading the json file to create the machine
        TuringMachine turingMachine = new TuringMachine("resources/program.json");
        System.out.println("Final Tape : #" + turingMachine.execute() + "#");
        System.out.println("fin");
    }
}
