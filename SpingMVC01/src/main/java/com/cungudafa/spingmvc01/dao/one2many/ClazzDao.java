package com.cungudafa.spingmvc01.dao.one2many;

import java.util.List;

import com.cungudafa.spingmvc01.bean.one2many.Clazz;

public interface ClazzDao {
	public Clazz getClazzById(Clazz clazz);
	
	public List<Clazz> getClazzes();
}
