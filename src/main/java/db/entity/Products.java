package db.entity;

public class Products {
	private Integer productId;
	private String name;
	private Integer categoryId;
	private String category;
	private Integer price;
	private String description;
	private String createdAt;
	private String updatedAt;
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(Integer product_id) {
		this.productId = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreated_at(String created_at) {
		this.createdAt = created_at;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updated_at) {
		this.updatedAt = updated_at;
	}
	
	public Products() {
		
	}
	public Products(Integer productId, String name, Integer categoryId, String category, Integer price, String description) {
		setProductId(productId);
		setName(name);
		setCategoryId(categoryId);
		setCategory(category);
		setPrice(price);
		setDescription(description);
	}
	
}
