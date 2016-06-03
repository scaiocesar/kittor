package com.dc3.repository.sys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dc3.model.sys.SystemConfig;

public interface SystemConfigRepository extends CrudRepository<SystemConfig, Integer> {
	@Query(nativeQuery = true, value = "select * from systemConfig limit 1")
	SystemConfig findSystemConfig();

}
