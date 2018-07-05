package org.myazure.repository;

import java.util.List;

import org.myazure.domain.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends
PagingAndSortingRepository<Vehicle, Long> {

	List<Vehicle> findByCarLicensePlateLike(String key);


}
