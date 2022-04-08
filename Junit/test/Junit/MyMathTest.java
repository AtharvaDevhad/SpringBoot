package Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyMathTest {
	MyMath myMath = new MyMath();
	
	@BeforeEach
	void before() {
		System.out.println("Before");
	}
	@AfterEach
	void after() {
		System.out.println("After");
	}
	@BeforeAll
	static void beforeAll() {
		System.out.println("BeforeClass");
	}
	@AfterAll
	 static void afterAll() {
		System.out.println("AfterClass");
	}
	@Test
	void sum_with3numbers() {
		System.out.println("Test1");
	assertEquals(6,myMath.sum(new int[] {1,2,3}));
	}
	@Test
	void sum_with1numbers() {
		System.out.println("Test2");
		assertEquals(2,myMath.sum(new int[] {2}));
	}


}
