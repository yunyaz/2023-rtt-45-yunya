package app;

import controller.OrderDAO;
import controller.OrderDetailDAO;
import controller.ProductDAO;
import model.OrderDetail;

public class OrderDetailExample {

	public static void main(String[] args) {
		
		OrderDetailDAO orderDetailDao = new OrderDetailDAO();
		OrderDAO orderDao = new OrderDAO();
		ProductDAO productDao = new ProductDAO();
		
		// insert a new OrderDetail
//		OrderDetail od1 = new OrderDetail();
//		od1.setQuantityOrdered(100);
//		od1.setPriceEach(100.00);
//		od1.setOrderLineNumber(10);
//		
//		Order order = orderDao.findById(10100);
//		od1.setOrder(order);
//		
//		Product product = productDao.findById(15);
//		od1.setProduct(product);
//		
//		orderDetailDao.insert(od1);
//		
//		System.out.println(od1);
		
		
		// Update a existing OrderDetail
		OrderDetail od2 = orderDetailDao.findById(2997);
//		od2.setPriceEach(150.00);
//		
//		orderDetailDao.update(od2);
		
		orderDetailDao.delete(od2);
		

	}

}
