package org.launchcode.models;

public class Cheese {
    private int id;
    private String name;
    private String description;
    private static int nextId = 0;

    public Cheese(String name, String description) {
        this.id = nextId;
        this.name = name;
        this.description = description;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
