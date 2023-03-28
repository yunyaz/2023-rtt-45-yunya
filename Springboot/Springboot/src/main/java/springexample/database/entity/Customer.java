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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "contact_lastname")
	private String contactLastname;

	@Column(name = "contact_firstname")
	private String contactFirstname;

	@Column(name = "phone")
	private String phone;

	@Column(name = "address_line1")
	private String addressLine1;

	@Column(name = "address_line2")
	private String addressLine2;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "country")
	private String country;

	@Column(name = "salesRepEmployeeNumber", insertable = false, updatable = false)
	private Integer salesRepEmployeeNumber;

	@Column(name = "credit_limit", columnDefinition = "decimal", precision = 10, scale = 2)
	private Double creditLimit;

	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "salesRepEmployeeNumber", nullable = true)
	private Employee employee;

	@ToString.Exclude
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Payment> payments = new ArrayList<Payment>();
	
	@ToString.Exclude
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Order> orders = new ArrayList<Order>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactFirstname == null) ? 0 : contactFirstname.hashCode());
		result = prime * result + ((contactLastname == null) ? 0 : contactLastname.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (contactFirstname == null) {
			if (other.contactFirstname != null)
				return false;
		} else if (!contactFirstname.equals(other.contactFirstname))
			return false;
		if (contactLastname == null) {
			if (other.contactLastname != null)
				return false;
		} else if (!contactLastname.equals(other.contactLastname))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		return true;
	}
	
	


}
