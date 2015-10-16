package com.landsea.company;

/**
 * Created by SDL on 2015/8/24.
 */
public class CompositeClient {
    public static void main(String[] args) {
        AbstractCompany department = new ConcreteDepartment("研发部");
        ConcreteDepartment d1 = new ConcreteDepartment("研发部一级");
        d1.addPos(new Position("总监", 1));
        d1.addPos(new Position("高级经理", 2));
        d1.addPos(new Position("经理", 3));
        d1.addPos(new Position("主管", 4));
        department.add(d1);
        EndDepartment ed1 = new EndDepartment("集成组");
        ed1.addPos(new Position("组长", 5));
        ed1.addPos(new Position("副组长", 6));
        department.add(ed1);
        d1.add(ed1);
        department.operate(1);
    }
}
