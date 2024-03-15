package jp.ac.ohara.schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.schedule.model.AllScheduleBook;

@Repository
public interface AllScheduleBookRepository extends JpaRepository<AllScheduleBook, Long> {
	public List<AllScheduleBook> findAllByNameEquals(String username);
	
}
