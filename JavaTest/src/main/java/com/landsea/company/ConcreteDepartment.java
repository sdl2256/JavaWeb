package com.landsea.company;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体机构部门
 * Created by SDL on 2015/8/24.
 */
public class ConcreteDepartment extends AbstractCompany {
    String name;

    public ConcreteDepartment(String name) {
        super();
        this.name = name;
    }

    List<Position> pos = new ArrayList<Position>();
    protected List<AbstractCompany> departments = new ArrayList<AbstractCompany>();

    @Override
    int add(AbstractCompany company) {
        departments.add(company);
        return 0;
    }

    @Override
    int remove(AbstractCompany company) {
        departments.remove(company);
        return 0;
    }

    @Override
    AbstractCompany getChild(int index) {
        return departments.get(index);
    }

    void addPos(Position e) {
        this.pos.add(e);
    }

    void removePos(Position e) {
        this.pos.remove(e);
    }

    void displayPosition(int depth) {
        for (Position p : pos) {
            for (int i = 0; i < depth; i++) {
                System.out.print("-");
            }
            System.out.println("职位名称:" + p.getName() + ",职位级别：" + p.getGrade());
        }
    }

    @Override
    Object operate(int depth) {
        System.out.println(depth + "级部门：" + this.name);
        displayPosition(depth);
        for (AbstractCompany depart : departments) {
            for (int i = 0; i < depth; i++) {
                System.out.print("-");
            }
            depart.operate(depth + 1);
        }
        return null;
    }
}
