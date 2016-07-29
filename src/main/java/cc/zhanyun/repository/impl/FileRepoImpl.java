package cc.zhanyun.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cc.zhanyun.model.file.File;
import cc.zhanyun.repository.FileRepository;

@Repository
@Service
public class FileRepoImpl {

	@Autowired
	private FileRepository fileRepo;

	/**
	 * 文件上传
	 */
	public void fileUpload(File file) {
		fileRepo.save(file);
	}

	/**
	 * 单个文件下载
	 */
	public File fileDownload(String oid) {
		return fileRepo.findOne(oid);
	}

	/**
	 * 单个删除文件
	 */
	public void delFile(String oid) {
		fileRepo.delete(oid);
	}
}
