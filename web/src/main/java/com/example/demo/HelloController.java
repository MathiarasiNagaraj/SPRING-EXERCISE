/**
 * 
 */
package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mathiarasi
 *
 */

@RestController
@RequestMapping(path = "api")
public class HelloController {

	@Autowired
	User user;

	@GetMapping
	public void sayHello() {
		System.out.println("Hello");

	}

	@GetMapping("/hello")
	public String sayHelloAll() {
		System.out.println("Hello all");
		return "welcome";

	}

	@GetMapping("/response")
	public ResponseEntity<String> sayHelloResponse() {
		System.out.println("Hello all");
		return ResponseEntity.ok("hello this is from response method");

	}

	@GetMapping("/model")
	public ModelAndView model(ModelAndView modelAndView) {

		modelAndView.addObject("name", "Mathiarasi");
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	@GetMapping("/modelrequest")
	public ModelAndView sayhello6(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.addObject("name", "Mathi");
		request.setAttribute("degree", "BE");
		HttpSession session = request.getSession();
		session.setAttribute("sessionname", "session");
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	@GetMapping("pathVariable/{name}")
	public ModelAndView pathVariable(@PathVariable String name, ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.addObject("name", name);
		request.setAttribute("degree", "BE");

		modelAndView.setViewName("welcome");
		return modelAndView;

	}

	@GetMapping("param")
	public ModelAndView requestParam(@RequestParam("uname") String name, ModelAndView modelAndView,
			HttpServletRequest request) {
		modelAndView.addObject("name", name);
		request.setAttribute("degree", "BE");

		modelAndView.setViewName("welcome");
		return modelAndView;

	}

	@GetMapping("object")
	public ResponseEntity<User> sendObject() {

		User user = new User();
		user.setUserId(5);
		user.setUserName("Mathi");
		return ResponseEntity.ok(user);

	}

	@PostMapping("user")
	public ResponseEntity<User> sendUser(@RequestBody User user) {
		user.setUserId(5);
		user.setUserName("Anu");
		return ResponseEntity.ok(user);

	}

	@PostMapping("UserName")
	public User sendUserName(@RequestBody User user) {
		user.setUserId(5);
		user.setUserName("Mathiarasi");
		return user;

	}

	@GetMapping("getobject")
	public ModelAndView returnObjectInJSP(ModelAndView modelAndView) {
		User user = new User();
		user.setUserId(5);
		user.setUserName("Mathiarasi");
		modelAndView.addObject("user", user);
		modelAndView.setViewName("welcome");

		return modelAndView;
	}

}
