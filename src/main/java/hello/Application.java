package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class Application {

	protected static final String VERSION = "0.1";

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/demo")
	public Status getInfo() throws UnknownHostException {
		final Status status = new Status();
		status.setAddress(InetAddress.getLocalHost().getHostAddress());
		status.setVersion(VERSION);
		status.setUsersCount(userRepository.findAll().size());

		return status;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
