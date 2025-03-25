package oduad.fi.finder.repository;

import oduad.fi.finder.entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagerRepository extends JpaRepository<Messages, Long> {



}
