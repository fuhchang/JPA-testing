package anything;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the inboundtrans database table.
 * 
 */
@Entity
@Table(name="inboundtrans")
@NamedQuery(name="Inboundtran.findAll", query="SELECT i FROM Inboundtran i")
public class Inboundtran implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(length=255)
	private String donor;

	@Column(length=255)
	private String donorType;

	private int receiptNO;

	//bi-directional many-to-one association to Inbounditem
	@OneToMany(mappedBy="inboundtran")
	private List<Inbounditem> inbounditems1;

	//bi-directional many-to-many association to Inbounditem
	@ManyToMany(mappedBy="inboundtrans")
	private List<Inbounditem> inbounditems2;

	public Inboundtran() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDonor() {
		return this.donor;
	}

	public void setDonor(String donor) {
		this.donor = donor;
	}

	public String getDonorType() {
		return this.donorType;
	}

	public void setDonorType(String donorType) {
		this.donorType = donorType;
	}

	public int getReceiptNO() {
		return this.receiptNO;
	}

	public void setReceiptNO(int receiptNO) {
		this.receiptNO = receiptNO;
	}

	public List<Inbounditem> getInbounditems1() {
		return this.inbounditems1;
	}

	public void setInbounditems1(List<Inbounditem> inbounditems1) {
		this.inbounditems1 = inbounditems1;
	}

	public Inbounditem addInbounditems1(Inbounditem inbounditems1) {
		getInbounditems1().add(inbounditems1);
		inbounditems1.setInboundtran(this);

		return inbounditems1;
	}

	public Inbounditem removeInbounditems1(Inbounditem inbounditems1) {
		getInbounditems1().remove(inbounditems1);
		inbounditems1.setInboundtran(null);

		return inbounditems1;
	}

	public List<Inbounditem> getInbounditems2() {
		return this.inbounditems2;
	}

	public void setInbounditems2(List<Inbounditem> inbounditems2) {
		this.inbounditems2 = inbounditems2;
	}

}