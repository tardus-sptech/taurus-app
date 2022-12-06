package com.taurus.financeapi.modules.file.controller;//package com.taurus.financeapi.modules.file.controller;
//
//import com.taurus.financeapi.modules.file.service.FileStorageService;
//import com.taurus.financeapi.modules.file.dto.UploadFileResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//import java.util.List;
//import java.util.logging.Logger;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/file")
//public class FileController {
//    private Logger logger = Logger.getLogger(FileController.class.getName());
//
//    @Autowired
//    private FileStorageService service;
//
//    @PostMapping("/uploadFile")
//    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
//        logger.info("Storing file to disk");
//
//        var filename = service.storeFile(file);
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/api/file/v1/downloadFile/")
//                .path(filename)
//                .toUriString();
//
//        return
//                new UploadFileResponse(
//                        filename, fileDownloadUri, file.getContentType(), file.getSize());
//    }
//
//    @PostMapping("/uploadMultipleFiles")
//    public List<UploadFileResponse> uploadMultipleFiles(
//            @RequestParam("files") MultipartFile[] files) {
//        logger.info("Storing files to disk");
//
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadFile(file))
//                .collect(Collectors.toList());
//    }
//
//    //MY_file.txt
//    @GetMapping("/downloadFile/{filename:.+}")
//    public ResponseEntity<Resource> downloadFile(
//            @PathVariable String filename, HttpServletRequest request) {
//
//        logger.info("Reading a file on disk");
//
//        Resource resource = service.loadFileAsResource(filename);
//        String contentType = "";
//
//        try {
//            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//        } catch (Exception e) {
//            logger.info("Could not determine file type!");
//        }
//
//        if (contentType.isBlank()) contentType = "application/octet-stream";
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(
//                        HttpHeaders.CONTENT_DISPOSITION,
//                        "attachment; filename=\"" + resource.getFilename() + "\"")
//                .body(resource);
//    }
//}