package com.book.library.services.account;

import com.book.library.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Basic service for operations on {@link Account} entities.
 *
 * @author Vlad Lukjanenko.
 */
@Service
@Component
public interface AccountService extends CrudRepository<Account, Long> {
}
