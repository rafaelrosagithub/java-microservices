package com.rafael.hrworker.resources;

import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.hrworker.input.UploadFile;

@RestController
@RequestMapping("rest/{restId}/produtos/{produtoId}/file")
public class Upload {

	@PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void uploadFile(@PathVariable Long restId, @PathVariable Long produtoId, @Valid UploadFile arquivo) {

		var nomeArquivo = UUID.randomUUID().toString() + "_" + arquivo.getArquivo().getOriginalFilename();

		var arquivoUpload = Path.of("C:\\Projects\\testeUpload", nomeArquivo);

		System.out.println(nomeArquivo);
		System.out.println(arquivo.getDescricao());
		System.out.println(arquivoUpload);
		System.out.println(arquivo.getArquivo().getContentType());

		try {
			arquivo.getArquivo().transferTo(arquivoUpload);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

}
