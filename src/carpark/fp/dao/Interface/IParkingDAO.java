package carpark.fp.dao.Interface;

import carpark.fp.model.ParkingCategoryModel;
import carpark.fp.model.ParkingLot;
import carpark.fp.model.ParkingModel;

import java.util.List;


public interface IParkingDAO {
	/**
	 * GetMaxParkingId
	 * @return int
	 */
	public int GetMaxParkingId();
	
	/**
	 * AddCategory
	 * @param Category Category
	 * @return int
	 */
	public int AddCategory(ParkingCategoryModel Category);
	
	/**
	 * GetParkingCategory
	 * @return List of ParkingCategoryModel
	 */
	public List<ParkingCategoryModel> GetParkingCategory();
	
	/**
	 * GetCategoryId
	 * @param category category
	 * @return int
	 */
	public int GetCategoryId(String category);
	
	/**
	 * AddParking
	 * @param parking parking
	 * @return int
	 */
	public int AddParking(ParkingLot parking);
	
	/**
	 * GetParkingLot
	 * @return List of ParkingLot
	 */
	public List<ParkingLot> GetParkingLot();
	
	/**
	 * UpdateParkingLot
	 * @param parkingLot parkingLot
	 * @return boolean
	 */
	public boolean UpdateParkingLot(ParkingLot parkingLot);
	
	/**
	 * DeleteParkingLot
	 * @param parkingLot parkingLot
	 * @return boolean
	 */
	public boolean DeleteParkingLot(ParkingLot parkingLot);
	
	/**
	 * GetParkingSpaceDetail
	 * @return List of ParkingModel
	 */
	public List<ParkingModel> GetParkingSpaceDetail();
	
	/**
	 * GetParkingLog
	 * @return List of ParkingModel 
	 */
	public List<ParkingModel> GetParkingLog();
	
	/**
	 * AddParkingBooking
	 * @param parking parking
	 * @return int
	 */
	public int AddParkingBooking(ParkingModel parking);
}
