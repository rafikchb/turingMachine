package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        // reading the json file to create the machine
        TuringMachine turingMachine = new TuringMachine("C:\\rafik\\etudes\\master-aix-marseille\\genie-logicielle\\TP\\TP-2\\turingMachine\\src\\main\\java\\org\\example\\program.json" , "ABC");


    }
}