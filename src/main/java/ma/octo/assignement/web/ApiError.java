package ma.octo.assignement.web;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")

public class ApiError {
	@GetMapping("/")
	void error() throws Exception {
		throw new Exception("General Error");
	}
}
