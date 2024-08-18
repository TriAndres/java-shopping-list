package ru.practicum.model;

public class Shopping {
    private Long id;
    private String name;

    public Shopping(String name) {
        this.name = name;
    }

    public Shopping(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Shopping() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
