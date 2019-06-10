# SSM框架（九）Mybatis【多表查询-前后端】交互（教师信息管理demo）

# 序
本次基于**Sping+SpingBoot+Mybatis**写的`教师信息管理demo`，如图所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190607111414629.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2N1bmd1ZGFmYQ==,size_16,color_FFFFFF,t_70)

----

<font color=red size=5>↓↓↓↓</font>全部源码地址：<font color=red size=5>↓↓↓↓</font>
**https://github.com/cungudafa/SSMTest**

---

## 查询模块
查询| sql语句
|:--|:--
模糊查询|search * form teacher where t_name like %Keyword%
关键字查询|search * form teacher where t_id = 1
Mybatis多表查询|search *  form teacher left join school on tid=sid
## 界面模块
BootStrap| 动作|控件|处理
--|--|--|--
1|模糊查询|静态下拉框|value获取
2|个人信息修改|静态下拉框|跳转锁定学院名（value传值）
3|个人信息显示|弹窗|model蒙版
4|添加老师|弹窗、下拉框|value获取、model蒙版

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190607112547953.png) 

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019060711270027.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2N1bmd1ZGFmYQ==,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190607112448414.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2N1bmd1ZGFmYQ==,size_16,color_FFFFFF,t_70)
# 正文

更多内容查看CSDN：
>SSMTest
>SpingMVC01项目（包含学习、实例、Junit测试类），具体博客地址在：https://blog.csdn.net/cungudafa/column/info/35301
