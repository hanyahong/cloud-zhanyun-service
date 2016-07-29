package cc.zhanyun.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cc.zhanyun.model.file.File;

public interface FileRepository extends MongoRepository<File, String> {

}
