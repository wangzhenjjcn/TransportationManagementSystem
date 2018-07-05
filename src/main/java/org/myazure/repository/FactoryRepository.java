package org.myazure.repository;


import java.util.List;

import org.myazure.domain.Factory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactoryRepository extends
		PagingAndSortingRepository<Factory, Long> {

	List<Factory> findByNameLikeOrNamepyLikeOrAddressLikeOrContactLike(String key,
			String key2, String key3, String key4);

	List<Factory> findByNameContainingOrNamepyContainingOrAddressContainingOrAddresspyContainingOrContactContaining(
			String key, String key2, String key3, String key4, String key5);

}
