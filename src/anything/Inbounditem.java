package anything;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the inbounditem database table.
 * 
 */
@Entity
@Table(name="inbounditem")
@NamedQuery(name="Inbounditem.findAll", query="SELECT i FROM Inbounditem i")
public class Inbounditem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=255)
	private String code;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;

	private int receiptNO;

	//bi-directional many-to-one association to Inboundtran
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="INBOUND_TRANS_ID")
	private Inboundtran inboundtran;

	//bi-directional many-to-many association to Inboundtran
	@ManyToMany
	@JoinTable(
		name="trans_item"
		, joinColumns={
			@JoinColumn(name="ITEM_ID", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="TRANS_ID", nullable=false)
			}
		)
	private List<Inboundtran> inboundtrans;

	public Inbounditem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getReceiptNO() {
		return this.receiptNO;
	}

	public void setReceiptNO(int receiptNO) {
		this.receiptNO = receiptNO;
	}

	public Inboundtran getInboundtran() {
		return this.inboundtran;
	}

	public void setInboundtran(Inboundtran inboundtran) {
		this.inboundtran = inboundtran;
	}

	public List<Inboundtran> getInboundtrans() {
		return this.inboundtrans;
	}

	public void setInboundtrans(List<Inboundtran> inboundtrans) {
		this.inboundtrans = inboundtrans;
	}

}