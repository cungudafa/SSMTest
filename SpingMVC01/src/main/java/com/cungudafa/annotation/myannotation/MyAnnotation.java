package  com.cungudafa.annotation.myannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//元注解 --生命周期在运行时
//@Retention(RetentionPolicy.SOURCE)//该注解只会在源代码中存在
//@Retention(RetentionPolicy.CLASS)//该注解只会在源代码中存在
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})//该注解可以用在类/接口，方法、字段上
@Inherited//拥有MyAnnotation注解的类的子类也有MyAnnotation注解
@Documented
public @interface MyAnnotation {
	public String value();
	public String a() default "avalue";
	public String b();
}

