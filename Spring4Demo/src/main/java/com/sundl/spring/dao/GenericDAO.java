package com.sundl.spring.dao;

import java.util.List;

/**
 * Created by SDL on 2015/5/19.
 */
public interface GenericDAO <T> {
    /**
     * ͨ��ID���ʵ�����
     *
     * @param id ʵ�����ı�ʶ��
     * @return ������ֵ��Ӧ��ʵ�����
     */
    T findById(String id);

    /**
     * ��ʵ�����־û�
     *
     * @param entity ��Ҫ���г־û�������ʵ�����
     * @return �־û���ʵ�����
     */
    T makePersistent(T entity);

    /**
     * ��ʵ���Ϊ˲̬
     *
     * @param entity ��Ҫת��Ϊ˲̬��ʵ�����
     */
    void makeTransient(T entity);

    /**
     * ��һϵ�е�ʵ���Ϊ˲̬��ʹ�ñ���sql
     *
     * @param sql
     */
    void makeTransientByIds(String sql);

    /**
     *
     * ʹ��hql�����з�ҳ����
     *
     * @param hql
     * @param offset    ��һ����¼����
     * @param pageSize    ÿҳ��Ҫ��ʾ�ļ�¼��
     * @return    ��ѯ�ļ�¼
     */
    List<T> findByPage(final String hql, final int offset, final int pageSize);

    /**
     * ʹ��hql �����з�ҳ��ѯ����
     *
     * @param hql ��Ҫ��ѯ��hql���
     * @param value ���hql��һ��������Ҫ���룬value���Ǵ���Ĳ���
     * @param offset ��һ����¼����
     * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
     * @return ��ǰҳ�����м�¼
     */
    List<T> findByPage(final String hql , final Object value ,
                       final int offset, final int pageSize);

    /**
     * ʹ��hql �����з�ҳ��ѯ����
     *
     * @param hql ��Ҫ��ѯ��hql���
     * @param values ���hql�ж��������Ҫ���룬values���Ǵ���Ĳ���
     * @param offset ��һ����¼����
     * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
     * @return ��ǰҳ�����м�¼s
     */
    List<T> findByPage(final String hql, final Object[] values,
                       final int offset, final int pageSize);
    /**
     * ʹ��sql �����з�ҳ��ѯ����
     *
     * @param sql
     * @param offset
     * @param pageSize
     * @return
     */
    List findByPageSQL(final String sql,
                       final int offset, final int pageSize);

    /**
     * ��������������
     * @param hql hql���
     * @return ��Ӧ����Ŀ
     */
    Integer getCount(String hql);

    /**
     * �������ݲ���
     * @param hql ִ�и��µ����
     * @param values ��������в���
     */
    void updateObj(final String hql,final Object[] values);

}
