package org.myazure.repository;

import org.myazure.domain.Cushion;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CushionRepository extends
		PagingAndSortingRepository<Cushion, Long> {

}
