package org.springframework.data.rest.test.mvc;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Jon Brisbin <jon@jbrisbin.com>
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
}
