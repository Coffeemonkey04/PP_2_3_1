package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping(value = "/")
	public String getUsers(ModelMap model) {
		model.addAttribute("users", service.getAllUsers());
		return "users";
	}

	@GetMapping(value = "/form")
	public String showNewForm(ModelMap model) {
		return "add";
	}

	@PostMapping(value = "/users/add")
	public String addUser(@RequestParam String name, @RequestParam String surname, @RequestParam int age) {
		service.addUser(name, surname, age);
		return "redirect:/";
	}

	@GetMapping("/users/edit/")
	public String showEditForm(@RequestParam("id") Long id, ModelMap model) {
		User user = service.getUserById(id);
		model.addAttribute("user", user);
		return "edit";
	}

	@PostMapping("/users/update")
	public String updateUser(@RequestParam Long id, @RequestParam String name, @RequestParam String surname, @RequestParam int age) {
		service.updateUser(id, name, surname, age);
		return "redirect:/";
	}

	@PostMapping("/users/delete")
	public String deleteUser(@RequestParam("id") Long id) {
		service.removeUserById(id);
		return "redirect:/";
	}
}