package anything;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product_meta database table.
 * 
 */
@Entity
@Table(name="product_meta")
@NamedQuery(name="ProductMeta.findAll", query="SELECT p FROM ProductMeta p")
public class ProductMeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="META_KEY", length=255)
	private String metaKey;

	@Column(name="META_VALUE", length=255)
	private String metaValue;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID", nullable=false)
	private Product product;

	public ProductMeta() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMetaKey() {
		return this.metaKey;
	}

	public void setMetaKey(String metaKey) {
		this.metaKey = metaKey;
	}

	public String getMetaValue() {
		return this.metaValue;
	}

	public void setMetaValue(String metaValue) {
		this.metaValue = metaValue;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}