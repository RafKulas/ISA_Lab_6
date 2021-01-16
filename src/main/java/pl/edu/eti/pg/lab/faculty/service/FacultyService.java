package pl.edu.eti.pg.lab.faculty.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.edu.eti.pg.lab.faculty.entity.Faculty;
import pl.edu.eti.pg.lab.faculty.repository.FacultyRepository;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FacultyService {
	Logger logger = LoggerFactory.getLogger(FacultyService.class);
	private final FacultyRepository repository;
	@Value("${file.upload}")
	private String path;

	@Autowired
	public FacultyService(FacultyRepository repository) {
		this.repository = repository;
	}

	public Optional<Faculty> find(String primaryKey) {
		return repository.findById(primaryKey);
	}

	public List<Faculty> findAll() {
		return repository.findAll();
	}

	@Transactional
	public void delete(Faculty entity) {
		repository.delete(entity);
	}

	@Transactional
	public Faculty create(Faculty entity) {
		return repository.save(entity);
	}

	@Transactional
	public void update(Faculty entity) {
		repository.save(entity);
	}

	public void updateLogo(String name, MultipartFile file) {
		repository.findById(name).ifPresent(faculty -> {
			faculty.setFilename(file.getOriginalFilename());
			update(faculty);
			saveFile(file);
		});
	}

	public String saveFile(MultipartFile file) {
		String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
		try {
			Path targetLocation = Path.of(path).resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			return fileName;
		} catch (IOException ex) {
			throw new IllegalStateException(ex);
		}
	}

	public Resource loadFile(String fileName) {
		try {
			Path filePath = Path.of(path).resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if(resource.exists()) {
				return resource;
			} else {
				throw new IllegalStateException("File not found");
			}
		} catch (MalformedURLException ex) {
			throw new IllegalStateException(ex);
		}
	}
}
