package com.masai.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com.masai.app"})
@PropertySource("app.properties")
public class AppConfig {
	
	@Bean(name = {"personService"})
	public PersonService getPersonService() {
		PersonService personService=new PersonService();
		personService.setTheMap(getMap());
		personService.setTheList(getList());
		return personService;
	}
	
	@Bean
	public Map<Person,Gym> getMap(){
		Map<Person,Gym> map=new HashMap<Person,Gym>();
		
		Person per2=new Person(2,"Jayat","jayat@gmail.com",22,"9354699591");
		Person per3=new Person(3,"Vedant","Vedant@gmail.com",22,"9354699591");
		map.put(getPerson(), getGym());
		map.put(per2,getGym());
		map.put(per3,getGym());
		return map;
	}
	
	@Bean
	public List<Person> getList(){
		List<Person> persons=new ArrayList<Person>();
		Person per2=new Person(2,"Jayat","jayat@gmail.com",22,"9354699591");
		Person per3=new Person(3,"Vedant","Vedant@gmail.com",22,"9354699591");
		Person per4=new Person(4,"Simran","simran@gmail.com",22,"9354699591");
		Person per5=new Person(5,"Sanyam","sanyam@gmail.com",22,"9354699591");
		persons.add(getPerson());
		persons.add(per2);
		persons.add(per3);
		persons.add(per4);
		persons.add(per5);
		return persons;
	}
	
	//@Scope("prototype")
	@Bean
	public Person getPerson() {
		return new Person(1,"Anish","anish@gmail.com",21,"9354699591");
	}
	
	@Bean
	public Gym getGym() {
		return new Gym(11,"Goldgym",2001);
	}

}
