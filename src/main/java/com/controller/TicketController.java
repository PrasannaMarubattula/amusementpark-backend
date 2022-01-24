package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Ticket;
import com.exception.TicketNotFoundException;
import com.service.TicketService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/insertTicket")
	public ResponseEntity<Ticket> insertTicket(@RequestBody Ticket ticket){
		return new ResponseEntity<Ticket>(ticketService.insertTicket(ticket), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllTickets")
	public List<Ticket> getAllTickets(){
		return ticketService.getAllTickets();
	}
	
	@GetMapping("/getTicketById/{ticketId}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable int ticketId) throws TicketNotFoundException{
		return new ResponseEntity<Ticket>(ticketService.getTicketById(ticketId), HttpStatus.OK);
	}
	
	@PutMapping("/updateTicketById/{ticketId}")
	public ResponseEntity<Ticket> updateTicketById(@PathVariable int ticketId, @RequestBody Ticket ticket) throws TicketNotFoundException{
		return new ResponseEntity<Ticket>(ticketService.updateTicketById(ticket, ticketId), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteTicketById/{ticketId}")
	public ResponseEntity<String> deleteTicketById(@PathVariable int ticketId) throws TicketNotFoundException{
		ticketService.deleteTicketById(ticketId);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

}
