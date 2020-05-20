package myRobot.dao;

import java.util.ArrayList;

import myRobot.vo.Product;
import myRobot.vo.User;
import myRobot.vo.Cart;

public interface CartDAO {
	public int addGoodsInCart(String username,int number,int ProductID)throws Exception;
	public int removeGoodsFromCart(int CartID)throws Exception;
	public ArrayList<Cart> showCartList(String username) throws Exception;
	public Product findProduct(int proID)throws Exception;
}
