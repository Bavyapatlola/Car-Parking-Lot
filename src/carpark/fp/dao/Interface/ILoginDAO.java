package carpark.fp.dao.Interface;

import carpark.fp.model.UserProfileModel;

import java.util.List;


public interface ILoginDAO {
	
	/**
	 * Gets the user list
	 * @return list of string
	 */
	public List<String> getUserNameList();
	
	/**
	 * getUserDetails deteails
	 * @param userName userName
	 * @return UserProfileModel
	 */
	public UserProfileModel getUserDetails(String userName);
}
