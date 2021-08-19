package com.lti.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lti.daos.ReimbursementDao;
import com.lti.models.Reimbursement;
import com.lti.models.ReimbursementStatus;
import com.lti.models.ReimbursementType;
import com.lti.models.Roles;
import com.lti.models.User;

@ExtendWith(MockitoExtension.class)
public class ReimbursementServiceTest {

	ReimbursementStatus rs = new ReimbursementStatus(1, "Pending");
	ReimbursementType rt = new ReimbursementType(1, "LODGING");
	Roles empl = new Roles(2, "Employee");
	User user = new User("User", "password", "first", "last", "fl.com", empl);
	Reimbursement reimb = new Reimbursement(30, Timestamp.valueOf(LocalDateTime.now()), user, rs, rt);
	
	@Mock
	ReimbursementDao rd;
	
	@InjectMocks
	ReimbursementServiceImpl rsi;
	
	@Test
	public void addReimbursementValid() {
		Mockito.when(rd.reimbursementAdded(reimb)).thenReturn(reimb);
		assertEquals(rsi.reimbursementAdded(reimb), true);	
	}
	
	@Test
	public void addReimbursementFail() {
		Mockito.when(rd.reimbursementAdded(reimb)).thenReturn(null);
		assertEquals(rsi.reimbursementAdded(reimb), false);
	}
	
	@Test
	public void getReimbByStatusAndUser() {
		List<Reimbursement> reimbs = new ArrayList<>();
		reimbs.add(reimb);
		Mockito.when(rd.getReimbursementByUserAndStatus(user, rs)).thenReturn(reimbs);
		assertEquals(reimbs, rsi.getReimbursementByUserAndStatus(user, rs));
	}

	
	@Test
	public void updateVaild() {
		Mockito.when(rd.updateReimbursement(reimb)).thenReturn(true);
		assertEquals(true, rsi.updateReimbursement(reimb));
	}
	
	@Test
	public void updateFailed() {
		Mockito.when(rd.updateReimbursement(reimb)).thenReturn(false);
		assertEquals(false, rsi.updateReimbursement(reimb));
	}
	
	@Test
	public void getReimbByStatus() {
		List<Reimbursement> reimbs = new ArrayList<>();
		reimbs.add(reimb);
		Mockito.when(rd.getReimbursementByStatus(rs)).thenReturn(reimbs);
		assertEquals(reimbs, rsi.getReimbursementByStatus(rs));
	}

	@Test
	public void getReimbById() {
		Mockito.when(rd.getReimbursementById(reimb.getReimbId())).thenReturn(reimb);
		assertEquals(reimb, rsi.getReimbursementById(reimb.getReimbId()));
	}
	
	@Test
	public void getReimbByUser() {
		List<Reimbursement> reimbs = new ArrayList<>();
		reimbs.add(reimb);
		Mockito.when(rd.getReimbursementByUser(user)).thenReturn(reimbs);
		assertEquals(reimbs, rsi.getReimbursementByUser(user));
	}
	
	@Test
	public void getAllReimbursement() {
		List<Reimbursement> reimbs = new ArrayList<>();
		reimbs.add(reimb);
		Mockito.when(rd.getAllReimbursement()).thenReturn(reimbs);
		assertEquals(reimbs, rsi.getAllReimbursement());
	}

}
