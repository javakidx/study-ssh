package idv.jk.readinglist.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import idv.jk.readinglist.entity.Book;

public interface ReadingListRepository extends JpaRepository<Book, Long>
{
	public List<Book> findByReader(String reader);
}
