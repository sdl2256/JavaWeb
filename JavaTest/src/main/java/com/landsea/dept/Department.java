package com.landsea.dept;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDL on 2015/8/25.
 */
public class Department {
    private String id;
    private String name;
    private Department parent;
    private List<Department> children;
    private int depth;

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Department() {
    }

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
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

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }

    public Department addDepartment(Department department) {
        if (children == null)
            children = new ArrayList<>();
        if (children.add(department)) {
            department.setParent(this);
            return department;
        } else
            return null;
    }

    @Override
    public String toString() {
        return "Department{" +
                "parent=" + parent +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
