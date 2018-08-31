package com.accountapp.backend.repositories;

import com.accountapp.backend.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    public Account getById(Long id);
}
