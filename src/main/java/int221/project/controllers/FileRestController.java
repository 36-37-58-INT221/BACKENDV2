package int221.project.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import int221.project.models.ExtendService;

@CrossOrigin(origins = "http://52.187.120.198:8080")
@RestController
public class FileRestController {
	@Autowired
	ExtendService ES;

	@GetMapping(value = "/getImage/{name}", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
	public byte[] getImage(@PathVariable String name) throws IOException {
		return ES.getFile(name);
	}

}
