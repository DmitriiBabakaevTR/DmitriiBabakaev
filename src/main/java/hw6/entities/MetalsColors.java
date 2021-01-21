package hw6.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class MetalsColors {

    @JsonProperty("summary")
    private List<String> summary;

    @JsonProperty("elements")
    private List<String> elements;

    @JsonProperty("color")
    private String color;

    @JsonProperty("metals")
    private String metals;

    @JsonProperty("vegetables")
    private List<String> vegetables;

    private String oddRadio;
    private String evenRadio;

    public MetalsColors(){ }

    public MetalsColors(List<String> elements, String color, String metals, List<String> vegetables, String oddRadio, String evenRadio) {
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
        this.oddRadio = oddRadio;
        this.evenRadio = evenRadio;
    }

    public List<String> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public void setSummary(List<String> summary) {
        this.summary = summary;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }

    public String getOddRadio() {
        return this.summary.get(0);
    }

    public String getEvenRadio() {
        return this.summary.get(1);
    }

    public void setOddRadio(String oddRadio) {
        this.oddRadio = oddRadio;
    }

    public void setEvenRadio(String evenRadio) {
        this.evenRadio = evenRadio;
    }

    public List<String> resultLogRows(){
        List<String> results = new ArrayList<>();
        int sum = Integer.parseInt(this.summary.get(0)) + Integer.parseInt(this.summary.get(1));
        String veg = "Vegetables: ";
        for (int i = 0; i < this.vegetables.size() - 1; i++) {
            veg += this.vegetables.get(i) + ", ";
        }
        veg += this.vegetables.get(this.vegetables.size() - 1);
        String el = "Elements: ";
        for (int i = 0; i < this.elements.size() -1; i++) {
            el += this.elements.get(i) + ", ";
        }
        el += this.elements.get(this.elements.size() - 1);
        results.add("Summary: " + sum);
        results.add(el);
        results.add("Color: " + this.color);
        results.add("Metal: " + this.metals);
        results.add(veg);
        return results;
    }
}