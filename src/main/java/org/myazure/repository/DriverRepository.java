package org.myazure.repository;

import org.myazure.domain.Driver;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends
PagingAndSortingRepository<Driver, Long>{

}
