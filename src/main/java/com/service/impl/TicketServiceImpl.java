package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Ticket;
import com.exception.TicketNotFoundException;
import com.repository.TicketRepository;
import com.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	TicketRepository ticketRepo;

	@Override
	public Ticket insertTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	@Override
	public Ticket updateTicketById(Ticket ticket, int ticketId) throws TicketNotFoundException {
		Ticket existingTicket = ticketRepo.findById(ticketId).orElseThrow(() -> new TicketNotFoundException("Ticket not found!"));
		
		existingTicket.setCustomer(ticket.getCustomer());
		existingTicket.setActivity(ticket.getActivity());
		existingTicket.setDateTime(ticket.getDateTime());
		existingTicket.setBill(ticket.getBill());
		
		ticketRepo.save(existingTicket);
		return existingTicket;
	}

	@Override
	public String deleteTicketById(int ticketId) throws TicketNotFoundException {
		ticketRepo.findById(ticketId).orElseThrow(() -> new TicketNotFoundException("Ticket not found!"));
		
		ticketRepo.deleteById(ticketId);
		return "Deleted";
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepo.findAll();
	}

	@Override
	public Ticket getTicketById(int ticketId) throws TicketNotFoundException {
		return ticketRepo.findById(ticketId).orElseThrow(() -> new TicketNotFoundException("Ticket not found!"));
	}

}
