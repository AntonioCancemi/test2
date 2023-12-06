package com.json.test.repository;

import com.json.test.entities.JsonbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJsonbRepo extends JpaRepository<JsonbEntity,Long> {
}
