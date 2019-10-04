package se.blinfo.idempotentfilter.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.blinfo.idempotentfilter.domain.Request;

/**
 * @author jel
 */
@Repository
public interface RequestDao extends CrudRepository<Request,String> {
}
