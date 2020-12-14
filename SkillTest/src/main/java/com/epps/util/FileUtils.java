package com.epps.util;

import java.io.File;
import java.util.Iterator;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.epps.dto.NoticeDTO;

@Component
public class FileUtils {

	public NoticeDTO parseInsertFileInfo(NoticeDTO dto, MultipartHttpServletRequest mpRequest,
			HttpServletRequest request) throws Exception {
		String filePath = request.getSession().getServletContext().getRealPath("resources/upload/");
		Iterator<String> iterator = mpRequest.getFileNames();
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;

		File file = new File(filePath);
		// 지정된 폴더가 존재하는지 확인 후 존재하지 않을 경우 mkdirs()를 통해 생성
		if (file.exists() == false) {
			file.mkdirs();
		}

		while (iterator.hasNext()) {
			multipartFile = mpRequest.getFile(iterator.next());
			if (multipartFile.isEmpty() == false) {
				// 파일의 원본이름을 저장
				originalFileName = multipartFile.getOriginalFilename();
				/*
				 * originalFileName(ex: abc.jpg)중 lastIndexOf로 .이 있는 index인 위치(4)를 구해서
				 * substring에 index를 넣고 jpg라는 이름을 가져옴 (확장자 이름 가져오는 의미)
				 */
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				/*
				 * getRandomString에서 randomUUID로 고유 식별자 받아옴 ->String으로 변환 -> replaceAll로 '-'를
				 * 공백으로 바꿈 그로인해 getRandomString은 32개의값이 되고 originalFileExtension을 붙여주므로
				 * b78e7249b3xx4b6eac485ab2f4d9c2f0.jpg같은 형식으로 저장이름이 만들어짐
				 */
				storedFileName = getRandomString() + originalFileExtension;
				// 경로 + 저장이름을 넣고 파일객체 생성
				file = new File(filePath + storedFileName);
				// tranFerTo에 파일객체를 넣고 실제 경로에 파일 생성
				multipartFile.transferTo(file);
				dto.setOrg_file_name(originalFileName);
				dto.setStored_file_name(storedFileName);
				dto.setFile_size(multipartFile.getSize());
			}
		}
		return dto;
	}

	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}