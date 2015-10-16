package com.landsea.company;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *末端部门
 * Created by SDL on 2015/8/24.
 */
public class EndDepartment extends AbstractCompany {

    public EndDepartment(String name) {
        this.name = name;
    }

    String name;

    List<Position> pos = new ArrayList<Position>();

    int add(AbstractCompany company) {
        System.out.println("已经是最后子级部门,不能添加子部门");
        return -1;
    }

    int remove(AbstractCompany company) {
        System.out.println("已经是最后子级部门,没有子部门了");
        return -1;
    }

    Object operate(int depth) {
        System.out.println(depth + "级部门：" + this.name);
        displayPosition(depth);
        return null;
    }

    AbstractCompany getChild(int index) {
        return null;
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

    ;
}
