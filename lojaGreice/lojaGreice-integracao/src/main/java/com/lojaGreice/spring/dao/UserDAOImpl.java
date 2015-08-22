package com.lojaGreice.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.lojaGreice.spring.model.User;

public class UserDAOImpl implements UserDAO {
	private DataSource dataSource;
	
	public UserDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<User> list() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * from users";
		List<User> listUser = jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNumber) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				return user;
			}
			
		});
		return listUser;
	}

//	@Override
//	public void save(User usuario) {
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		jdbcTemplate.
//		
//	}
	
	@Override
    public void save(User employee) {
        String query = "insert into User (id, username, email,password) values (?,?,?,?)";
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getUsername());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getPassword());
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Employee saved with id="+employee.getId());
            }else System.out.println("Employee save failed with id="+employee.getId());
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	

}
