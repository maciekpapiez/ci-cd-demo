package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {

    @Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}

	@RequestMapping("/users")
	public List<Account> getUsers() {
		return userRepository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
