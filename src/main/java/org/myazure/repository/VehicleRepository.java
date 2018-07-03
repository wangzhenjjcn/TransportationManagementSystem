package org.myazure.repository;

import org.myazure.domain.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends
PagingAndSortingRepository<Vehicle, Long> {

	Vehicle findOneByCarLicensePlate(String string);

}
