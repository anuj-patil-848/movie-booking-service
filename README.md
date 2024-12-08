# Movie Booking Service

This project is a **Movie Booking Service** built with **Spring Boot** and **Java**, using **Maven** for dependency management. The service provides a RESTful API for managing movie bookings, including features such as browsing available movies, selecting showtimes, reserving tickets, and user management.

## Features

- **Browse Movies:** View the list of currently available movies and their details.
- **Showtimes:** Select from available showtimes for a movie.
- **Book Tickets:** Reserve tickets for a selected showtime.
- **User Management:** Register and manage user accounts.
- **RESTful API:** Endpoints for interaction with the service.
- **Database Integration:** Persistent storage using an RDBMS (e.g., MySQL, PostgreSQL, or H2 for local testing).

## Tech Stack

- **Backend:** Java, Spring Boot
- **API Development:** REST
- **Build Tool:** Maven
- **Database:** MySQL (configurable)
- **Security:** Spring Security (optional for user authentication and authorization)

## Requirements

- Java 11 or later
- Maven 3.6 or later
- MySQL or other supported RDBMS (optional: H2 for local development)

## Installation

1. Clone the repository:
```bash
git clone https://github.com/your-username/movie-booking-service.git
cd movie-booking-service
```

2. Configure the database connection in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/movie_booking
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

3. Build the project using Maven:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The application will start at `http://localhost:8080`.

## API Endpoints

### Movies
- `GET /api/movies` - Retrieve a list of all movies.
- `GET /api/movies/{id}` - Retrieve details of a specific movie.

### Showtimes
- `GET /api/movies/{id}/showtimes` - Get showtimes for a movie.
- `POST /api/movies/{id}/showtimes` - Add a new showtime (admin only).

### Booking
- `POST /api/bookings` - Create a new booking.
- `GET /api/bookings/{id}` - Get booking details by ID.

### User Management
- `POST /api/users/register` - Register a new user.
- `POST /api/users/login` - User login to receive a token.

## Example Request and Response

### Booking Tickets
**Request:**
```json
POST /api/bookings
{
  "userId": 1,
  "showId": 5,
  "seats": ["A1", "A2", "A3"]
}
```

**Response:**
```json
{
  "userId": 123,
  "showId": 5,
  "seats": ["A1", "A2", "A3"],
  "status": "Confirmed/Unable"
}
```

## Project Structure

```
movie-booking-service/
├── src/main/java/com/example/moviebooking/
│   ├── controllers/       # API controllers
│   ├── models/            # Entity classes
│   ├── repositories/      # Database repositories
│   ├── services/          # Business logic
│   ├── MovieBookingApplication.java  # Main application
├── src/main/resources/
│   ├── application.properties   # Configuration
├── pom.xml                 # Maven configuration
├── README.md               # Project documentation
```

## Testing

Run unit tests using Maven:
```bash
mvn test
```

## Contributions

Contributions are welcome! Feel free to fork this repository, make your changes, and submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to the Spring Boot team for providing such a powerful framework.
- Inspired by common movie booking systems in theaters.
