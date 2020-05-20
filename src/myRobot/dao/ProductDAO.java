package myRobot.dao;

import java.util.ArrayList;

import myRobot.vo.Product;

public interface ProductDAO {
	public ArrayList<Product> showProList() throws Exception;
	public int reduceNum(int num,int proID,int amount) throws Exception;
	public int findNum(int proID)throws Exception;
	public Product findProduct(int proID)throws Exception;
}
