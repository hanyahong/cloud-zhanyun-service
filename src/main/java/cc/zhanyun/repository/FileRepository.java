package cc.zhanyun.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cc.zhanyun.model.file.FileManager;

public interface FileRepository extends MongoRepository<FileManager, String> {
	/**
	 * 以报价单id 查询 url
	 */
	public FileManager findByUidAndOfferOid(String uid, String offeroid);
}
