package anything;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="product")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=255)
	private String category;

	@Column(length=255)
	private String code;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_REGISTERED")
	private Date dateRegistered;

	@Column(length=255)
	private String description;

	@Column(length=255)
	private String name;

	private double price;

	@Column(name="REGISTERED_BY", length=255)
	private String registeredBy;

	@Column(length=255)
	private String sku;

	@Column(length=255)
	private String status;

	@Column(name="UNIT_OF_MEASURE", length=255)
	private String unitOfMeasure;

	private double weight;

	//bi-directional many-to-one association to ProductMeta
	@OneToMany(mappedBy="product")
	private List<ProductMeta> productMetas;

	public Product() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDateRegistered() {
		return this.dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRegisteredBy() {
		return this.registeredBy;
	}

	public void setRegisteredBy(String registeredBy) {
		this.registeredBy = registeredBy;
	}

	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUnitOfMeasure() {
		return this.unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public List<ProductMeta> getProductMetas() {
		return this.productMetas;
	}

	public void setProductMetas(List<ProductMeta> productMetas) {
		this.productMetas = productMetas;
	}

	public ProductMeta addProductMeta(ProductMeta productMeta) {
		getProductMetas().add(productMeta);
		productMeta.setProduct(this);

		return productMeta;
	}

	public ProductMeta removeProductMeta(ProductMeta productMeta) {
		getProductMetas().remove(productMeta);
		productMeta.setProduct(null);

		return productMeta;
	}

}