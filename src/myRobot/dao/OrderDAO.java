package myRobot.dao;

import myRobot.vo.Product;

import java.util.ArrayList;

import myRobot.vo.Cart;


public interface OrderDAO{
	public int addGoodsInOrder(String username, int number, int ProductID,String OrderList) throws Exception;
    public void removeGoodsFromOrder(String OrderList)throws Exception;
    public ArrayList<Cart> query(String username) throws Exception;
    public Product findProduct(int proID)throws Exception;
	public String getTwo();
     }


