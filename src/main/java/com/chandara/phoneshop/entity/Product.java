package com.chandara.phoneshop.entity;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name="products",
       uniqueConstraints = {@UniqueConstraint(columnNames={"model_id","color_id"})})
public class Product{
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "product_name",unique = true)
	private String name;
	
	@Column(name="image_path")
	private String imagePath;
	
	@Column(name = "avialable_unit")
	private Integer avialableUnit;
	
	@ManyToOne
	@JoinColumn(name="model_id")
	private Model model;
	
	@ManyToOne
	@JoinColumn(name="color_id")
	private Color color;
	
	@DecimalMin(value = "0.00001",message = "price must be grater than 0")
	@Column(name = "sale_price")
	private BigDecimal SalePrice;

}
