package com.bankdbapi.leisunbank;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.dynamic.DynamicType.Builder.InnerTypeDefinition;
@RestController
public class controller {

	@Autowired
	bankdao bankuserdao=new bankdao();
	
	@GetMapping(path="/userall")
	public List<bank> orderDetails() {
		return bankuserdao.selectAllUsers();
	}
	
	@PostMapping(path="/create")
	public void createNewUser(@RequestBody bank newUser)  {
		try {
			bankuserdao.insertUser(newUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@GetMapping(path="/update")
	public void updateNewUser(@RequestBody bank newUser) throws SQLException {
		
			bankuserdao.updateUser(newUser);
		
		
	}
	
	
	
	@DeleteMapping(path="/delete")
	public boolean deleteNewUser(@RequestParam("account") int  newuser) throws SQLException 
	{
		return bankuserdao.deleteUser(newuser);
	}


	


}
