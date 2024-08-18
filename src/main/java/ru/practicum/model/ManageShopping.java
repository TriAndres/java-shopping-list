package ru.practicum.model;

import java.util.ArrayList;
import java.util.List;

public class ManageShopping {
    private List<Shopping> list = new ArrayList<>();
    private static Long id = 0L;

    public static Long getId() {
        return ++id;
    }

    public Shopping add(Shopping shopping) {
            shopping.setId(getId());
            list.add(shopping);
            return shopping;
    }

    public List<Shopping> getList() {
        return list;
    }

    public void setList(List<Shopping> list) {
        this.list = list;
    }

    public void clear() {
        list.clear();
    }



}
