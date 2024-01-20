package com.MEC.Data;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalDataRepository extends ReactiveCrudRepository<LocalData,String> {
}
