package com.lampiris.library.repository;

import com.lampiris.library.domain.BookFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookFamilyRepository extends JpaRepository<BookFamily, Long> {
}
