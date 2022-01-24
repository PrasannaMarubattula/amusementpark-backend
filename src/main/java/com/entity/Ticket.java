package com.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue
	private int ticketId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_Id", referencedColumnName = "userId")
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Activity activity;
	private LocalDateTime dateTime;
	private float bill;
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", customer=" + customer + ", activity=" + activity + ", dateTime="
				+ dateTime + ", bill=" + bill + "]";
	}

}
