package com.simplilearn.training;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("jdbcDao")
public class JDBCDao {
	
	String qry;
	
	DataSource dataSource;
	
	JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	//For Fetching Count of Rows for Tale:student
		
		int getCountOfStudents() {
		
			qry="select count(*) from student";
			
			return jdbcTemplate.queryForObject(qry, Integer.class);
			
		}	
		
		//Get Student name based on his or her ID
		String getStudentName(int studentId) {
			qry ="select stdName from student where stdid =?";
			return jdbcTemplate.queryForObject(qry, new Object[] {studentId},String.class);
		}
		
		
		//Get Student name based on his or her ID and loction
		String getStudentNamebByIDandLoc(int studentId,String studentLocation ) {
			qry ="select stdName from student where stdid =? and stdLocation=?" ;
			return jdbcTemplate.queryForObject(qry, new Object[] {studentId,studentLocation},String.class);
		}
		
		
		//Get Student name and location based on his or her ID
		Student getStudentDetail(int stdId) {
			qry ="select * from student where stdid =?";
			return jdbcTemplate.queryForObject(qry, new Object[] {stdId}, new StudentMapper());
		}
		
		//Get all Students
		List<Student> getAllStudents() {
			qry ="select * from student";
			return jdbcTemplate.query(qry, new StudentMapper());
		}
		
		
		//Create an inner class that implements RowMapper
		
		class StudentMapper  implements RowMapper<Student>{

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student theStudent =new Student();
				
				//Map the fields of student with columns of table:student
				theStudent.setStdId(rs.getInt("stdId"));
				theStudent.setStdName(rs.getString("stdName"));
				theStudent.setStdLocation(rs.getString("stdLocation"));
				
				return theStudent;
			}
			
		}
		
}
