package com.chandara.phoneshop.entity;
import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="sale_detail")
public class SaleDetail{
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "sale_detail_id")
	private Long id;
	@ManyToOne
	@JoinColumn(name="sold_id")
	private Sale sale;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	@Column(name="amount")
	private BigDecimal amount;
	private Integer unit;

}
