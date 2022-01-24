package com;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Ticket;
import com.repository.TicketRepository;
import com.service.TicketService;

@SpringBootTest
class TicketServiceTest {
	
	@Autowired
	TicketService ticketService;
	
	@MockBean
	TicketRepository ticketRepo;

	@Test
	void testInsertTicket() {
		
		Ticket t1 = new Ticket();
		t1.setTicketId(1);
		t1.setBill(120);
//		t1.setDateTime("2022-01-09 12:14:53.287000");
//		t1.setDescription("Land game");
		
		Ticket t2 = new Ticket();
		t2.setTicketId(1);
		t2.setBill(120);
//		t2.setDateTime("2022-01-09 12:14:53.287000");
//		t2.setDescription("Land game");
		
		List<Ticket> ticketList = new ArrayList<>();
		ticketList.add(t1);
		ticketList.add(t2);
		
		Mockito.when(ticketRepo.findAll()).thenReturn(ticketList);
		assertThat(ticketService.getAllTickets()).isEqualTo(ticketList);
		
	}

	@Test
	void testUpdateTicketById() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteTicketById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllTickets() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTicketById() {
		fail("Not yet implemented");
	}

}
