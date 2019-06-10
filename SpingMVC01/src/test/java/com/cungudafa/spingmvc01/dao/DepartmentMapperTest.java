package com.cungudafa.spingmvc01.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cungudafa.spingmvc01.bean.Department;
import com.cungudafa.spingmvc01.bean.DepartmentExample;
import com.cungudafa.spingmvc01.bean.DepartmentExample.Criteria;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/application-*.xml")
public class DepartmentMapperTest {
	
	@Autowired
	private DepartmentMapper dao;
	
	@Test
	public void test1(){//增
		Department d = new Department();
		d.setDepartmentName("行政部");
		dao.insert(d);//插入一个行政部
	}
	
	@Test
	public void test2(){//改
		Department d = dao.selectByPrimaryKey(1);//把department_id为1的部门：行政部改为-》销售部
		d.setDepartmentName("销售部");
		dao.updateByPrimaryKey(d);
	}
	
	@Test
	public void test3(){//删
		dao.deleteByPrimaryKey(3);
	}
	
	@Test
	public void test4(){//查
		Department d = dao.selectByPrimaryKey(1);//id为1的部门
		System.out.println("查询部门号为1的d.name = " + d.getDepartmentName());
	}
	
	@Test
	public void test5(){//模糊查询所有部
		DepartmentExample example = new DepartmentExample();
		Criteria c = example.createCriteria();
//		c.andDepartmentNameLike("%部%");
		c.andDepartmentIdLessThan(5).andDepartmentNameLike("%部%");
		List<Department> ds = dao.selectByExample(example);
		for(Department d : ds){
			System.out.println("查询d.name = " + d.getDepartmentName());
		}
	}
	
	@Test
	public void test6(){
		DepartmentExample example = new DepartmentExample();
		Criteria c = example.createCriteria();
		c.andDepartmentIdGreaterThanOrEqualTo(4);//删除4？
		
		dao.deleteByExample(example);
	}
	
}
