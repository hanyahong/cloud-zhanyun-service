package cc.zhanyun.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cc.zhanyun.model.Error;
import cc.zhanyun.service.impl.FileServiceImpl;

@RestController
@RequestMapping(value = "/file")
@Api(value = "/file", description = "the file API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-07-20T07:07:41.123Z")
public class FileApi {

	@Autowired
	private FileServiceImpl service;

	/**
	 * 上传单个文件
	 * 
	 * @param name
	 * @param file
	 * @return
	 */
	@ApiOperation(value = "上传文件", notes = "上传文件", response = Void.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Void.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Error.class) })
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFileUpload(  MultipartFile file) {
		String info = service.uploadFile(file);

		return info;

	}

	/**
	 * 下载
	 * 
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@ApiOperation(value = "下载文件", notes = "下载文件", response = Void.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Void.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Error.class) })
	@RequestMapping(value = "/download/{oid}", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadFile(
			@ApiParam(value = "文件ID", required = true) @PathVariable("oid") @RequestBody String oid)
			throws IOException {

		InputStreamResource resource = service.downloadFile(oid);
		// 设置http header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add(
				"Content-Disposition",
				String.format("attachment; filename=\"%s\"",
						resource.getFilename()));
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentLength(resource.contentLength())
				.contentType(
						MediaType.parseMediaType("application/octet-stream"))
				.body(resource);
	}

	@ApiOperation(value = "批量上传文件", notes = "批量上传文件", response = Void.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "获取成功", response = Void.class),
			@ApiResponse(code = 500, message = "服务器响应失败", response = Error.class) })
	@RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
	public @ResponseBody
	String handleFileUpload(HttpServletRequest request) {
		List<MultipartFile> files = ((MultipartHttpServletRequest) request)
				.getFiles("file");
		for (int i = 0; i < files.size(); ++i) {
			MultipartFile file = files.get(i);
			String name = file.getName();
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(new File(name + i)));
					stream.write(bytes);
					stream.close();
				} catch (Exception e) {
					return "You failed to upload " + name + " => "
							+ e.getMessage();
				}
			} else {
				return "You failed to upload " + name
						+ " because the file was empty.";
			}
		}
		return "upload successful";
	}
}