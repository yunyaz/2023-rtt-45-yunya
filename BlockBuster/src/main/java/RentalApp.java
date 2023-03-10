import java.util.Date;
import java.util.List;

import controller.MovieDAO;
import controller.MovieRentalDAO;
import controller.UserDAO;
import model.Movie;
import model.MovieRental;
import model.User;

public class RentalApp {
	
	public static UserDAO userDao = new UserDAO();
	public static MovieDAO movieDao = new MovieDAO();
	public static MovieRentalDAO movieRentalDao = new MovieRentalDAO();

	public static void main(String[] args) {
		
		// Create User
//		User user1 = new User();
//		user1.setFirstName("Emma");
//		user1.setLastName("Foster");
//		user1.setEmail("emma.foster@gmail.com");
//		user1.setPassword("zxcvm,./");
//		user1.setCreateDate(new Date());
//		userDao.insert(user1);
		
		
//		User user2 = new User();
//		user2.setFirstName("Gina");
//		user2.setLastName("Harrison");
//		user2.setEmail("gina.harrison@gmail.com");
//		user2.setPassword("sdfghjkl");
//		user2.setCreateDate(new Date());
//		userDao.insert(user2);
		
		
//		Movie movie1 = new Movie();
//		movie1.setName("Tangled");
//		movie1.setYearReleased(2010);
//		movie1.setRating(4.0);
//		movie1.setRentalPrice(4.99);
//		movie1.setLateFee(1.25);
//		movieDao.insert(movie1);
		
		
//		Movie movie2 = new Movie();
//		movie2.setName("Encanto");
//		movie2.setYearReleased(2021);
//		movie2.setRating(4.1);
//		movie2.setRentalPrice(5.99);
//		movie2.setLateFee(1.50);
//		movieDao.insert(movie2);
		
		
//		changePassword(1, "aaaaaaaa");
		
		Movie movie = movieDao.findById(1);
		User user = userDao.findById(1);
		checkout(movie, user);
		
	}
	
	public static void changePassword(Integer newId, String newPassword) {
		User user = userDao.findById(newId);
		user.setPassword(newPassword);
		userDao.update(user);
	}
	
	public static void checkout(Movie movie, User user) {
		
		List<MovieRental> rentalList = movie.getMovieRentals();
//		Date lastCheckinTime = rentalList.get(rentalList.size() - 1).getCheckinDate();
		Date currentTime = new Date();
		
		if (rentalList.size() != 0 && rentalList.get(rentalList.size() - 1).getCheckoutDate() != null 
				&& rentalList.get(rentalList.size() - 1).getCheckinDate() == null) {
			System.out.println(movie.getName() + " has not been returned yet.");
		}
		else {
			MovieRental movieRental = new MovieRental();
			movieRental.setMovieId(movie.getId());
			movieRental.setUserId(user.getId());
			movieRental.setCheckoutDate(new Date());
			movieRental.setMovie(movie);
			movieRental.setUser(user);
			movieRentalDao.insert(movieRental);
		}
		
//		rentalList.size() == 0 
//		|| currentTime.getTime() - rentalList.get(rentalList.size() - 1).getCheckinDate().getTime() >= 0)
		
	}

}
