package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidateNameTest {
	
	private PlaceOrderController placeOrderController;

	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	
	@ParameterizedTest
	@CsvSource({
		"Nguyen Ba Tuan, true",
		"Nguyen @ ##, false",
		"Nguyen Tuan 2000, false",
		"Nguyen @2000#, false",
		"'', false",
		", false"
	})

	@Test
	void test(String name, boolean expected) {
//		fail("Not yet implemented");
		boolean isValid = placeOrderController.validateName(name);
		assertEquals(expected, isValid);
	}

}
