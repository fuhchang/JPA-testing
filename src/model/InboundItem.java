package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the inbound_item database table.
 * 
 */
@Entity
@Table(name="inbound_item")
@NamedQuery(name="InboundItem.findAll", query="SELECT i FROM InboundItem i")
public class InboundItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date expirydate;

	private String itemid;

	private int quantity;

	private String receiptno;

	public InboundItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getExpirydate() {
		return this.expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getReceiptno() {
		return this.receiptno;
	}

	public void setReceiptno(String receiptno) {
		this.receiptno = receiptno;
	}

}