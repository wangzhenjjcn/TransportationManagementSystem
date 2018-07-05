package org.myazure.repository;

import java.util.List;

import org.myazure.domain.Cushion;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CushionRepository extends
		PagingAndSortingRepository<Cushion, Long> {

	List<Cushion> findByOrderId(Long id);

	List<Cushion> findByCreatorUserId(Long id);

	List<Cushion> findByRemarksContainingOrRemarkspyContaining(String key,
			String key2);

}
