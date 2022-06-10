package com.datademo.DataDemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.el.parser.AstString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJdbcDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<AtharvaPerson>{

		@Override
		public AtharvaPerson mapRow(ResultSet rs, int rowNum) throws SQLException {
			AtharvaPerson person = new AtharvaPerson();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirth_date(rs.getTimestamp("birth_date"));
			return person;
			
		}
	}
	
	
	
	public List<AtharvaPerson>findAll(){
		return jdbcTemplate.query("select * from atharva_person",  
				new BeanPropertyRowMapper(AtharvaPerson.class));
		
	}
	public AtharvaPerson findById(int id){
		return jdbcTemplate.queryForObject
				("select * from atharva_person  where id=?", new Object[] {id},
				new  PersonRowMapper());
		
	}
	public int deleteById(int id){
		return jdbcTemplate.update
				("delete from atharva_person  where id=?", new Object[] {id});
		
	}
	public int insert(AtharvaPerson person){
		return jdbcTemplate.update(
				"insert into atharva_person(id,name,location,birth_date)" 
				+ "values(?,  ?, ?, ?)",
				new Object[] {
					   person.getId(),person.getName(),
					   person.getLocation(),
					   new Timestamp(person.getBirth_date().getTime())});
				}
//     public int update(AtharvaPerson person){
//		return jdbcTemplate.update(
//				"update atharva_person"
//				+ "set name = ?, location =?, birth_date =?"
//				+ "where id = ?",
//			new Object[] {
//					person.getName(), 
//					person.getLocation(),
//					new Timestamp(person.getBirth_date().getTime()),person.getId() });
//				
//				}
//		
//	}
//
//	
	public int update(AtharvaPerson person) {
		return jdbcTemplate.update(
				"update atharva_person "
				+ " set name = ?, location = ?, birth_date = ? "
				+ " where id = ?",
				new Object[] {
						person.getName(), person.getLocation(), new Timestamp(person.getBirth_date().getTime()),
						person.getId() });
	}
}
	


