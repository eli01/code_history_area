package com.xiaoli.service.inter;

import java.util.List;

public interface BaseInterface {
	/*��һЩͨ�õķ����������û����ӿ���*/
	
	/*ͨ��id�Ż�ȡһ��ʵ��*/
	public Object findById(Class cla,java.io.Serializable id);
	/*�ṩһ�������ı������ķ���*/
	public void save(Object obj);
	/*ͨ��hql���list*/
	public List<Object> getList(String hql,String[] params);
	/*ͨ��hql�����һ������*/
	public Object getUniqueObject(String hql,String[] params);
}
