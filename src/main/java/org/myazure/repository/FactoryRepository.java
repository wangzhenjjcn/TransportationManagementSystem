package org.myazure.repository;

import org.myazure.domain.Factory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactoryRepository extends
PagingAndSortingRepository<Factory, Long>{

	Factory findOneByName(String string);

}
