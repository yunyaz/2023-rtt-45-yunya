package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "movie_rentals")
public class MovieRental {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "movie_id", insertable = false, updatable = false)
	private Integer movieId;
	
	@Column(name = "user_id", insertable = false, updatable = false)
	private Integer userId;
	
	@Column(name = "checkout_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date checkoutDate;
	
	@Column(name = "checkin_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date checkinDate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "movie_id")
	private Movie movie;
	
	
}
