package com.chandara.phoneshop.entity;

import java.time.LocalDateTime;

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
public class Sale{
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "sale_detai_id")
	private Long id;
	@ManyToOne
	@JoinColumn(name="sale_id")
	private Sale sale;
	@Column(name="sold_date")
	private LocalDateTime soldDate;
}
