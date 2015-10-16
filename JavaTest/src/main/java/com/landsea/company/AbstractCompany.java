package com.landsea.company;

/**
 * 公司机构
 *
 * Created by SDL on 2015/8/24.
 */

abstract class AbstractCompany {
    abstract int add(AbstractCompany company);

    abstract int remove(AbstractCompany company);

    abstract Object operate(int depth);

    abstract AbstractCompany getChild(int index);
}
