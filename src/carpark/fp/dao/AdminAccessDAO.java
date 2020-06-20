package carpark.fp.dao;

import carpark.fp.dao.Interface.IAdminAccessDAO;
import carpark.fp.common.Constants;
import carpark.fp.dao.Interface.IAdminAccessDAO;
import carpark.fp.model.UserProfileModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminAccessDAO extends BaseDAO implements IAdminAccessDAO {

	/**
	 * Loads the user details
	 * @return list of user profile model
	 */
	public List<UserProfileModel> getUserDetails(){
		List<UserProfileModel> userList = new ArrayList<UserProfileModel>();
		try {
			CreateConnection();
			PreparedStatement getAllUser = PrepareStatement(Constants.GET_ALL_USER);
			ResultSet rs = getAllUser.executeQuery();
			while (rs.next())
				userList.add(Map_ResultSet_To_UserProfileModel(rs));
		} catch (SQLException e) {
			if (e.getMessage().equalsIgnoreCase("Too many connections"))
				System.out.println("Please ask the administrator to close the connection!!");
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
		return userList;
	}
	
	/**
	 * Updates the user details
	 * @param userId userId
	 * @param role role
	 * @return true/false
	 */
	public boolean UpdateUserDetail(int userId, String role){
		try {
			CreateConnection();
			PreparedStatement updateUser = PrepareStatement(Constants.UPDATE_USER_ROLE);
			updateUser.setString(1, role);
			updateUser.setInt(2, userId);
			int result = updateUser.executeUpdate();
			if(result>0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			if (e.getMessage().equalsIgnoreCase("Too many connections"))
				System.out.println("Please ask the administrator to close the connection!!");
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
		return false;
		
	}
}
