package br.com.sambaTech.controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sambaTech.entity.Media;
import br.com.sambaTech.repository.MediaRepository;

@RestController
@ResponseBody
public class MediaController {

	@Autowired
	private MediaRepository dao;

	@GetMapping(value = "/medias", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Media> listar() {
		try {
			return (List<Media>) dao.findAll();
		} catch (Exception ex) {
			return Collections.emptyList();
		}
	}

	@PostMapping("/medias")
	public ResponseEntity<Media> createMedia(@Valid @RequestBody Media media) {
		try {
			Media m = dao.save(media);
			return new ResponseEntity<Media>(m, HttpStatus.CREATED);
		} catch (Exception ex) {
			return null;
		}
	}

	@DeleteMapping("/medias/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer id) throws Exception {
		Media media = dao.findById(id).orElseThrow(() -> new Exception("Id não existe :: " + id));

		dao.delete(media);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@GetMapping(value = "/medias/{id}")
	public ResponseEntity<?> produto(@PathVariable Integer id) {
		try {
			Optional<Media> media = dao.findById(id);
			Media resp = media.orElse(null);
			if (resp == null) {
				throw new Exception("codigo nao Enconstrado");
			}
			return ResponseEntity.ok(resp);
		} catch (Exception ex) {

			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
		}
	}

	@PutMapping("/medias/{id}")
	public ResponseEntity<Media> updateEmployee(@PathVariable Integer id, @RequestBody Media mediaBody)
			throws Exception {
		Media media = dao.findById(id).orElseThrow(() -> new Exception("Id não	 existe: " + id));
		media.setNome(mediaBody.getNome());
		media.setUrl(mediaBody.getUrl());
		media.setDataUpload(new Date());
		media.setDuracao(mediaBody.getDuracao());
		media.setDeleted(mediaBody.getDeleted());
		final Media mediaUpdate = dao.save(media);
		return ResponseEntity.ok(mediaUpdate);
	}

}