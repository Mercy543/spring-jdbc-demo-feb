package com.simplilearn.training;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
       //Load the context
    	ClassPathXmlApplicationContext theContext= new ClassPathXmlApplicationContext("annotationsContext.xml");
    	
      //Get the Bean
    	JDBCDao  dao = theContext.getBean("jdbcDao",JDBCDao.class);
    	
     //Execute the method
    	//System.out.println("Number of Rows in the Table are: " + dao.getCountOfStudents());
    	
    	
    	//Execute the method
    	//System.out.println("Student Name at ID 4 is: " +  dao.getStudentName(4));
    	
    	//Execute the method
    	//System.out.println("Student Name at ID 4 is: " +  dao.getStudentNamebByIDandLoc(4,"Califonia"));
    	
    	//Execute the method
    	//Student theStudent =dao.getStudentDetail(3);
    	//System.out.println(" Name : " +  theStudent.getStdName() + "," + "Location: " + theStudent.getStdLocation());
    	
    	
    	//Execute the method to get all student
    	for (Student student : dao.getAllStudents()) {
    		System.out.println(student);
    	}
    		
    }
}
