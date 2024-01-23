package com.MEC.Data;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocalDataRepository extends ReactiveMongoRepository<LocalData,String> {
}
