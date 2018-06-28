package org.myazure.repository;

import org.myazure.domain.WebUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebUserRepository extends
		PagingAndSortingRepository<WebUser, Long> {

}