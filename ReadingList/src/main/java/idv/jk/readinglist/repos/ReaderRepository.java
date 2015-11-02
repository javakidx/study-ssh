package idv.jk.readinglist.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import idv.jk.readinglist.entity.Reader;

public interface ReaderRepository extends JpaRepository<Reader, String>
{

}
