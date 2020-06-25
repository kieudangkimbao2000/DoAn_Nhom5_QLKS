package BLL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAL.userDAL;
import DTO.userDTO;
import GUI.thongbao;

public class userBLL {
	static userDAL udal = new userDAL();
	public ArrayList<userDTO> getAllU(){
		return udal.getAllU();
	}
	public ArrayList<userDTO> getUserById(userDTO udto){
		return udal.getUserById(udto);
	}
	public int updateUser(userDTO udto) {
		return udal.updateUser(udto);
	}
	public int deleteUser(userDTO udto) {
		return udal.deleteUser(udto);
	}
	public int insertUser(userDTO udto) {
		return udal.insertUser(udto);
	}
}
