package com.service;

import java.util.List;

import com.entity.Ticket;
import com.exception.TicketNotFoundException;

public interface TicketService {
	
	public Ticket insertTicket(Ticket ticket);
	public Ticket updateTicketById(Ticket ticket, int ticketId) throws TicketNotFoundException;
	public String deleteTicketById(int ticketId) throws TicketNotFoundException;
	public List<Ticket> getAllTickets();
	public Ticket getTicketById(int ticketId) throws TicketNotFoundException;
	
//	public List<Ticket> getAllTicketsByCustomerId(int customerId);
//	public Ticket calculateBill(int customerId);

}
