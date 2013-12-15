package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the inbound_item database table.
 * 
 */
@Embeddable
public class InboundItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	private int receiptno;

	public InboundItemPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReceiptno() {
		return this.receiptno;
	}
	public void setReceiptno(int receiptno) {
		this.receiptno = receiptno;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InboundItemPK)) {
			return false;
		}
		InboundItemPK castOther = (InboundItemPK)other;
		return 
			(this.id == castOther.id)
			&& (this.receiptno == castOther.receiptno);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.receiptno;
		
		return hash;
	}
}