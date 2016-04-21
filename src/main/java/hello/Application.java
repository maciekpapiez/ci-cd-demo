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

    @Autowired
	private UserRepository userRepository;

	@RequestMapping("/info")
	public Map<String, Object> getInfo() throws UnknownHostException {
		final Map<String, Object> map = new HashMap<>();
		map.put("users", userRepository.findAll().size());
		map.put("host", InetAddress.getLocalHost().getHostAddress());
		map.put("version", "0.1");

		return map;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
