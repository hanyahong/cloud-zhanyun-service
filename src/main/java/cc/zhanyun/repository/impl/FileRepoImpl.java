package cc.zhanyun.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cc.zhanyun.model.file.FileManager;
import cc.zhanyun.repository.FileRepository;

@Repository
public class FileRepoImpl {

	@Autowired
	private FileRepository fileRepo;

	/**
	 * 文件保存
	 */
	public void fileUpload(FileManager file) {
		fileRepo.save(file);
	}

	/**
	 * 单个查询
	 */
	public FileManager fileDownload(String oid) {
		return fileRepo.findOne(oid);
	}

	/**
	 * 单个删除信息
	 */
	public void delFile(String oid) {
		fileRepo.delete(oid);
	}

	/**
	 * offeroid 查询 file
	 */
	public FileManager selFileByOfferoid(String uid,String offeroid) {
		return fileRepo.findByUidAndOfferOid(uid, offeroid);
	}

}
