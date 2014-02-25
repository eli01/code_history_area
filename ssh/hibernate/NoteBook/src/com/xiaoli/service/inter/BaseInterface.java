package com.xiaoli.service.inter;

import java.util.List;

public interface BaseInterface {
	/*把一些通用的方法声明到该基础接口中*/
	
	/*通过id号获取一个实例*/
	public Object findById(Class cla,java.io.Serializable id);
	/*提供一个公共的保存对象的方法*/
	public void save(Object obj);
	/*通过hql获得list*/
	public List<Object> getList(String hql,String[] params);
	/*通过hql语句获得一个对象*/
	public Object getUniqueObject(String hql,String[] params);
}
