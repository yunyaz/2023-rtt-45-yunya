package app;

import controller.PaymentDAO;
import model.Payment;

public class PaymentExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PaymentDAO paymentDao = new PaymentDAO();

		
		Payment payment = paymentDao.findById(280);
		payment.setCheckNumber("CD234567");
		payment.setAmount(2345.68);
		
		paymentDao.update(payment);
		
	}

}
