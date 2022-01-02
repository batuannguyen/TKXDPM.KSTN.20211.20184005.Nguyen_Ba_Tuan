package shippingfees;

import entity.order.Order;
import entity.order.OrderMedia;
import utils.Configs;
import java.util.Random;

public class CalculateNewShippingFees implements ShippingFeeCalculator {

	@Override
	public int calculateShippingFees(Order order) {
		Random rand = new Random();
		
		// Chua them vao CSDL nen mac dinh trong luong thuc te bang 1
		order.setWeightOrder(1);
		
    	int alterWeight = 0;
    	for (int i = 0; i < order.getlstOrderMedia().size(); i++) {
    		OrderMedia ordMedia = (OrderMedia) order.getlstOrderMedia().get(i);
    		
    		// Lay Chi So cua Dai - Rong - Cao cua Hang Hoa
    		int iLength = ordMedia.getMedia().getLength();
    		int iWeight = ordMedia.getMedia().getWeight();
    		int iWidth = ordMedia.getMedia().getWidth();
    		
    		// Tinh Can Nang Thay The
    		alterWeight += iLength * iWeight * iWidth / Configs.CONSTANTS; // CONSTANTS = 6000
    	}
		return (int) ((order.getWeightOrder()+alterWeight)*(rand.nextFloat()/10));
	}

}
