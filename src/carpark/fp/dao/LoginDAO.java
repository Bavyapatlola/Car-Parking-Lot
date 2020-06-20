package carpark.fp.dao;

import carpark.fp.dao.Interface.ILoginDAO;
import carpark.fp.common.Constants;
import carpark.fp.dao.Interface.ILoginDAO;
import carpark.fp.model.UserProfileModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO extends BaseDAO implements ILoginDAO {

	/**
	 * Gets the user list
	 * @return list  of string
	 */
	
	public List<String> getUserNameList() {
		List<String> userName = new ArrayList<String>();
		try {
			CreateConnection();
			CreateStatement();
			ResultSet rs = ExecuteQuery(Constants.USERNAME_LIST);
			while (rs.next())
				userName.add(rs.getString(1));
		} catch (SQLException e) {
			if (e.getMessage().equalsIgnoreCase("Too many connections"))
				System.out.println("Please ask the administrator to close the connection!!");
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
		return userName;
	}

	/**
	 * getUserDetails deteails
	 * @param userName userName
	 * @return UserProfileModel
	 */
	public UserProfileModel getUserDetails(String userName) {
		try {
			UserProfileModel userProfileModel = null;
			CreateConnection();
			PreparedStatement getPassword = PrepareStatement(Constants.GET_USER_DETAIL);
			getPassword.setString(1, userName);

			ResultSet rs = getPassword.executeQuery();
			while (rs.next())
				userProfileModel = Map_ResultSet_To_UserProfileModel(rs);

			getPassword = PrepareStatement(Constants.GET_USER_ADDRESS);
			getPassword.setInt(1, userProfileModel.getAddress().getAddressId());

			rs = getPassword.executeQuery();
			while (rs.next())
				userProfileModel.setAddress(Map_ResultSet_To_Address(rs));

			return userProfileModel;

		} catch (SQLException e) {
			if (e.getMessage().equalsIgnoreCase("Too many connections"))
				System.out.println("Please ask the administrator to close the connection!!");
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
		return null;
	}

}
