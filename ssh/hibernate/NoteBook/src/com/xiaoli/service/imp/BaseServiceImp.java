package com.xiaoli.service.imp;
/*�����������ʵ�ֻ����ӿڣ���������Ҫ���Ի����ӿڵķ���ֻ��̳и��༴��*/
import java.io.Serializable;
import java.util.List;

import com.xiaoli.service.inter.BaseInterface;
import com.xiaoli.utils.HibernateHelper;


public abstract class BaseServiceImp implements BaseInterface {
	
	@Override
	public Object findById(Class clazz , Serializable id) {
		// TODO Auto-generated method stub
		return HibernateHelper.findById(clazz, id);
	}
	@Override
	public void save(Object obj){
		try {
			HibernateHelper.save(obj);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	@Override
	public List<Object> getList(String hql, String[] params) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getUniqueObject(String hql, String[] params) {
		// TODO Auto-generated method stub
		return null;
	}

}
