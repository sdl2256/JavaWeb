package com.landsea.memu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDL on 2015/7/13.
 */
public class ContextMenuConfig {
    private String id;
    private String name;
    private List<String> subCompIds = new ArrayList<String>();
    private List<String> eventTypes = new ArrayList<String>();


    public List<String> add(String id) {
        if (!subCompIds.contains(id)) {
            subCompIds.add(id);
        }
        return subCompIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSubCompIds() {
        return subCompIds;
    }

    public void setSubCompIds(List<String> subCompIds) {
        this.subCompIds = subCompIds;
    }

    public List<String> getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(List<String> eventTypes) {
        this.eventTypes = eventTypes;
    }

    @Override
    public String toString() {
        return "ContextMenuConfig{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", subCompIds=" + subCompIds +
                ", eventTypes=" + eventTypes +
                '}';
    }
}
