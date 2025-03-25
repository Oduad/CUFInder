package oduad.fi.finder.repository;

import oduad.fi.finder.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends JpaRepository<Message, Long> {



}
