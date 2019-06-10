package com.cungudafa.spingmvc01.dao.one2one;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cungudafa.spingmvc01.bean.one2one.IdCard;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/application-*.xml")
public class IdCardDaoTest {
	@Autowired
	private IdCardDao dao;
	
	@Test
	public void test1(){
		IdCard idCard = new IdCard();
		idCard.setIdCardId(1);//查询idcard为1的人的姓名
		idCard = dao.getIdCardById(idCard);
		System.out.println("身份证号 = "+idCard.getIdCardNumber());
		
		System.out.println("idCard.getPerson().getPersonId() = " + idCard.getPerson().getPersonId());;
		System.out.println("该身份证属于 = " + idCard.getPerson().getPersonName());
	}
}
