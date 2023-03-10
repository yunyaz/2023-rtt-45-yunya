package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "productlines")
public class ProductLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "product_line")
	private String productLine;
	
	@Column(name = "description")
	private String description;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "productLine", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();

}
