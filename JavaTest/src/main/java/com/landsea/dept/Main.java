package com.landsea.dept;

import java.util.List;

/**
 * Created by SDL on 2015/8/25.
 */
public class Main {

    public static void main(String[] args) {

        Department company = new Department("0", "Landsea");

        Department 研发部 = new Department("1", "研发部");

        Department 综合部 = new Department("2", "综合部");

        Department 技术部 = new Department("3", "技术部");

        Department 市场部 = new Department("4", "市场部");

        Department 研发部一组 = new Department("5", "研发部一组");

        研发部.addDepartment(研发部一组);

        Department 研发部一组A队 = new Department("7", "研发部一组A队");
        研发部一组.addDepartment(研发部一组A队);


        Department 研发部二组 = new Department("6", "研发部二组");
        研发部.addDepartment(研发部二组);

        company.addDepartment(综合部);
        company.addDepartment(技术部);
        company.addDepartment(市场部);
        company.addDepartment(研发部);

        System.out.println();

        printDept(研发部, 1);

    }

    public static void printDept(Department department, int depth) {
        if (department == null)
            return;

        String tmp = "";
        for (int i = 0; i < depth; i++) {
            tmp += "-";
        }
        tmp += " ";

        System.out.println(depth + "" + tmp + department);

        List<Department> children = department.getChildren();

        if (children == null)
            return;
        for (Department c : children) {
            printDept(c, depth + 1);
        }
    }
}
