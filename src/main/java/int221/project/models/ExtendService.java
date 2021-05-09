package int221.project.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.IOUtils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExtendService {
	String folder = "./public/product-images/";

	public void saveImage(MultipartFile file, String fileName) throws Exception {
		byte[] bytes = file.getBytes();
		Path path = Paths.get(folder, fileName);
		Files.write(path, bytes);
	}

	public byte[] getFile(String file) throws IOException {
		Path path = Paths.get(folder, file);
		return IOUtils.toByteArray(path.toUri());
	}

	public void deleteImage(String fileName) throws Exception {
		Path path = Paths.get(folder, fileName);
		Files.delete(path);
	}

}
