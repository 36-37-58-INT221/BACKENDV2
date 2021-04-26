//package int221.project.controllers;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import int221.practice.exceptions.ExceptionResponse;
//import int221.practice.exceptions.SurveyException;
//import int221.practice.models.Color;
//
//@RestController
//@RequestMapping("/survey")
//public class SurveyRestController {
//	private static final Map<Integer, Color> surveys = new HashMap<>();
//	{
//		surveys.put(1001, new Color(1001, "Pichet", 1));
//		surveys.put(1002, new Color(1002, "Somchai", 2));
//		surveys.put(1003, new Color(1003, "Somsak", 2));
//		surveys.put(1004, new Color(1004, "Somsri", 3));
//		surveys.put(1005, new Color(1005, "Somkiat", 2));
//
//	}
//
//	@GetMapping("")
//	public List<Color> surveyList() {
//		return new ArrayList<>(surveys.values());
//	}
//
//	@GetMapping("/{id}")
//	public Color survey(@PathVariable Integer id) {
//		if (surveys.get(id) == null) {
//			throw new SurveyException(ExceptionResponse.ERROR_CODE.ITEM_DOES_NOT_EXIST,
//					"id: {" + id + "} does not exist");
//		}
//		return surveys.get(id);
//	}
//
//	@PostMapping("")
//	public Color create(@RequestBody Color newSurvey) {
//		if (surveys.get(newSurvey.getId()) != null) {
//			throw new SurveyException(ExceptionResponse.ERROR_CODE.ITEM_ALREADY_EXIST,
//					"id: {" + newSurvey.getId() + "} already exist !!");
//		}
//		surveys.put(newSurvey.getId(), newSurvey);
//		return newSurvey;
//	}
//
//	@PutMapping("")
//	public Color update(@RequestBody Color newSurvey) {
//		surveys.put(newSurvey.getId(), newSurvey);
//		return newSurvey;
//	}
//
//	@DeleteMapping("/{id}")
//	public Color delete(@PathVariable int id) {
//		return surveys.remove(id);
//	}
//
//}
