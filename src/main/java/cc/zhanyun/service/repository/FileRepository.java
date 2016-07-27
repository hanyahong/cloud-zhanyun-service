package cc.zhanyun.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cc.zhanyun.service.model.file.File;

public interface FileRepository extends MongoRepository<File, String> {

}
