package com.revature.test;

import org.junit.jupiter.api.Test;

import com.home.reimbursement.DaoServices;
import com.home.reimbursement.ExpectedException;

import junit.framework.TestCase;

public class RmbTest extends TestCase {

	ExpectedException expected = new ExpectedException();

	DaoServices service = new DaoServices();

	@Test
	public void NameTest() {
		assertEquals("Adam", service.getMember("asmith1").getFname());
	}

	@Test
	public void LoginTest() {
		assertEquals("Adam", service.login("asmith1", "asmith11").getFname());
	}

	@Test
	public void UpdateUserTest() {
		assertEquals("emailChange@google.com",
				service.updateMember("asmith1", "asmith11", "emailChange@google.com", 2).getEmail());

	}

	@Test
	public void SubmitRmbTest() {
		assertEquals(service.getReimbursement(112).getReason(),
				service.submitReimbursement(112, 2, "Test", "Enthuware Payment", 10).getReason());
	}

}
