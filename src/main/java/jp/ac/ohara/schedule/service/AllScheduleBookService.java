package jp.ac.ohara.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.schedule.model.AllScheduleBook;
import jp.ac.ohara.schedule.model.UserBook;
import jp.ac.ohara.schedule.repository.AllScheduleBookRepository;
 
@Service
@Transactional
public class AllScheduleBookService {
 
	@Autowired
	private AllScheduleBookRepository allScheduleBookRepository;
 
	/**
	 * アドレス帳一覧の取得
	 * @return List<AllScheduleBook>
	 */
	public List<AllScheduleBook> getAllScheduleList(UserBook userBook) {
	    List<AllScheduleBook> entityList = this.allScheduleBookRepository.findAllByNameEquals(userBook.getUsername());
	    return entityList;
	}
 
	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  AllScheduleBook
	 */
	public AllScheduleBook get(@NonNull Long index) {
		AllScheduleBook allScheduleBook = this.allScheduleBookRepository.findById(index).orElse(new AllScheduleBook());
		return allScheduleBook;
	}
 
	/**
	 * アドレス帳一覧の取得
	 * @param AllScheduleBook AllScheduleBook
	 */
	public void save(@NonNull AllScheduleBook allScheduleBook) {
		this.allScheduleBookRepository.save(allScheduleBook);
	}
 
	/**
	 * アドレス帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.allScheduleBookRepository.deleteById(index);
	}
}