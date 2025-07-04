package ca.test.bankapp.repository;

import ca.test.bankapp.entity.AccountingJournal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountingJournalRepository extends JpaRepository<AccountingJournal, Long> {

}
