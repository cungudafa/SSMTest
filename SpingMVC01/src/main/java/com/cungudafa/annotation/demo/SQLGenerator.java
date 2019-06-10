package com.cungudafa.annotation.demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 生成SQL
 * @author Administrator
 *
 */
public class SQLGenerator {
	/**
	 * 插入
	 * @param o->UserInfo(id,name)
	 * @return insert into t_student vlaues (?, ?, ?) 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public static String createInsertSql(Object o) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException{
		//获取传入对象的运行时类
		Class c = o.getClass();
		//判断该类是否有@Table注解
		if(c.isAnnotationPresent(Table.class)){
			String sql = "insert into ";
			Table t = (Table) c.getAnnotation(Table.class);
			String tableName = t.value();
			sql = sql + tableName + " vlaues (";
			//获取所有的get方法
			Method[] methods = c.getDeclaredMethods();
			List<Method> getMethods = new ArrayList<>();
			for(Method method : methods){
				if(method.getName().startsWith("get")){
					getMethods.add(method);
				}
			}
			//遍历get方法
			for(Method method : getMethods){
				Object value = method.invoke(o);
				if(value != null){
					String methodName = method.getName();//getUserId/getUserName
					//System.out.println("methodName = " + methodName);
					//getUserId-->userId
					String fieldName = methodName.replaceAll("get", "");//UserId
					fieldName = fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1);//UserId->userId
					//System.out.println("fieldName = " + fieldName);
					//获得字段
					Field field = c.getDeclaredField(fieldName);
					//System.out.println("field = " + field);
					//判断字段上是否有Column注解
					if(field.isAnnotationPresent(Column.class)){
						//获得字段上的Column注解
						Column col = field.getAnnotation(Column.class);
						//获得注解的value值，作为列名
						String columnName = col.value();					
						if(value instanceof Integer){//区分id学号String转int（数据库为int）
							sql = sql + String.valueOf(value) + ",";
						}else{
							sql = sql +" '" + String.valueOf(value) + "',";
						}
					}
				}
			}
			sql = sql.substring(0,sql.length()-1) + ")";//删去sql句末多余的“,”
			return sql;
		}else{
			return null;
		}
	}
	/**
	 * 删除
	 * @param o->UserInfo(id,name)
	 * @return DELETE FROM t_student where and t_stuid = ?
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public static String createDeleteSql(Object o) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException{

		//获取传入对象的运行时类
		Class c = o.getClass();
		//判断该类是否有@Table注解
		if(c.isAnnotationPresent(Table.class)){
			String sql = "DELETE FROM ";
			Table t = (Table) c.getAnnotation(Table.class);
			String tableName = t.value();
			sql = sql + tableName + " where ";
			//获取所有的get方法
			Method[] methods = c.getDeclaredMethods();
			List<Method> getMethods = new ArrayList<>();
			for(Method method : methods){
				if(method.getName().startsWith("get")){
					getMethods.add(method);
				}
			}
			
			//遍历get方法
			for(Method method : getMethods){
				Object value = method.invoke(o);
				if(value != null){
					String methodName = method.getName();//getUserId/getUserName
					//System.out.println("methodName = " + methodName);
					//getUserId-->userId
					String fieldName = methodName.replaceAll("get", "");//UserId
					fieldName = fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1);//UserId->userId
					//System.out.println("fieldName = " + fieldName);
					//获得字段
					Field field = c.getDeclaredField(fieldName);
					//System.out.println("field = " + field);
					//判断字段上是否有Column注解
					if(field.isAnnotationPresent(Column.class)){
						//获得字段上的Column注解
						Column col = field.getAnnotation(Column.class);
						//获得注解的value值，作为列名
						String columnName = col.value();
						if(value instanceof Integer){//区分id学号String转int（数据库为int）
							sql = sql + columnName + " = " + String.valueOf(value) + " and ";
						}else{
							sql = sql + columnName + " = '" + String.valueOf(value) + "' and ";
						}
					}
				}
			}
			sql=sql.substring(0,sql.length()-4);//删去sql句末多余的“and ”
			return sql;
		}else{
			return null;
		}
	}
	

	/**
	 * 更新
	 * @param o->UserInfo(id,name)
	 * @return UPDATE table_name
				SET column1=value1,column2=value2,...
				WHERE some_column=some_value;
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public static String createUpdateSql(Object o,Object o1) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException{
		//获取传入对象的运行时类
		Class c = o.getClass();
		Class c1 = o1.getClass();
		//判断该类是否有@Table注解
		if(c.isAnnotationPresent(Table.class)){
			String sql = "update ";
			Table t = (Table) c.getAnnotation(Table.class);
			String tableName = t.value();
			sql = sql + tableName + " set ";
			//获取所有的get方法
			Method[] methods = c.getDeclaredMethods();
			List<Method> getMethods = new ArrayList<>();
			for(Method method : methods){
				if(method.getName().startsWith("get")){
					getMethods.add(method);
				}
			}
			//遍历get方法
			for(Method method : getMethods){
				Object value = method.invoke(o1);
				if(value != null){
					String methodName = method.getName();//getUserId/getUserName
					//System.out.println("methodName = " + methodName);
					//getUserId-->userId
					String fieldName = methodName.replaceAll("get", "");//UserId
					fieldName = fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1);//UserId->userId大写转小写
					//System.out.println("fieldName = " + fieldName);
					//获得字段
					Field field = c.getDeclaredField(fieldName);
					//System.out.println("field = " + field);
					//判断字段上是否有Column注解
					if(field.isAnnotationPresent(Column.class)){
						//获得字段上的Column注解
						Column col = field.getAnnotation(Column.class);
						//获得注解的value值，作为列名
						String columnName = col.value();
						if(value instanceof Integer){//区分id学号String转int（数据库为int）
							sql = sql + columnName + " = " + String.valueOf(value) + " and ";
						}else{
							sql = sql + columnName + " = '" + String.valueOf(value) + "' and ";
						}
					}
				}
			}
			sql = sql.substring(0,sql.length()-4)+"where ";//删去sql句末多余的“and ”
			//获取所有的get方法
			methods = c.getDeclaredMethods();
			getMethods = new ArrayList<>();
			for(Method method : methods){
				if(method.getName().startsWith("get")){
					getMethods.add(method);
				}
			}
			
			//遍历get方法
			for(Method method : getMethods){
				Object value = method.invoke(o);
				if(value != null){
					String methodName = method.getName();//getUserId/getUserName
					//System.out.println("methodName = " + methodName);
					//getUserId-->userId
					String fieldName = methodName.replaceAll("get", "");//UserId
					fieldName = fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1);//UserId->userId
					//System.out.println("fieldName = " + fieldName);
					//获得字段
					Field field = c.getDeclaredField(fieldName);
					//System.out.println("field = " + field);
					//判断字段上是否有Column注解
					if(field.isAnnotationPresent(Column.class)){
						//获得字段上的Column注解
						Column col = field.getAnnotation(Column.class);
						//获得注解的value值，作为列名
						String columnName = col.value();
						if(value instanceof Integer){//区分id学号String转int（数据库为int）
							sql = sql + columnName + " = " + String.valueOf(value) + " and ";
						}else{
							sql = sql + columnName + " = '" + String.valueOf(value) + "' and ";
						}
					}
				}
			}
			sql = sql.substring(0,sql.length()-4);
			return sql;
		}else{
			return null;
		}
	}
	

	
	/**
	 * 查询
	 * @param o->UserInfo(id,name)
	 * @return select * from user_info where user_id = ? and user_name = ?;
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public static String createSelectSql(Object o) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException{
		
		//获取传入对象的运行时类
		Class c = o.getClass();
		//判断该类是否有@Table注解
		if(c.isAnnotationPresent(Table.class)){
			String sql = "select * from ";
			Table t = (Table) c.getAnnotation(Table.class);
			String tableName = t.value();
			sql = sql + tableName + " where 1=1 ";
			//获取所有的get方法
			Method[] methods = c.getDeclaredMethods();
			List<Method> getMethods = new ArrayList<>();
			for(Method method : methods){
				if(method.getName().startsWith("get")){
					getMethods.add(method);
				}
			}
			
			//遍历get方法
			for(Method method : getMethods){
				Object value = method.invoke(o);
				if(value != null){
					String methodName = method.getName();//getUserId/getUserName
					System.out.println("methodName = " + methodName);
					//getUserId-->userId
					String fieldName = methodName.replaceAll("get", "");//UserId
					fieldName = fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1);//UserId->userId
					System.out.println("fieldName = " + fieldName);
					//获得字段
					Field field = c.getDeclaredField(fieldName);
					System.out.println("field = " + field);
					//判断字段上是否有Column注解
					if(field.isAnnotationPresent(Column.class)){
						//获得字段上的Column注解
						Column col = field.getAnnotation(Column.class);
						//获得注解的value值，作为列名
						String columnName = col.value();
						if(value instanceof Integer){//区分id学号String转int（数据库为int）
							sql = sql + "and " + columnName + " = " + String.valueOf(value) + " ";
						}else{
							sql = sql + "and " + columnName + " = '" + String.valueOf(value) + "' ";
						}
					}
				}
			}
			return sql;
		}else{
			return null;
		}
	}

}
