package idv.jk.readinglist;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import idv.jk.readinglist.entity.Book;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *  A unit test for Spring Boot application.
 * @author javakid
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ReadingListApplication.class)
@WebAppConfiguration
public class MockMvcWebTest
{
	@Autowired
	private WebApplicationContext webContext;
	
	private MockMvc mockMvc;

	@Before
	public void setupMockMvc()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(webContext)
					.apply(SpringSecurity()).build();
	}
	
	@Test
	public void homePage() throws Exception
	{
		mockMvc.perform(get("/Uncle"))
			.andExpect(status().isOk())
			.andExpect(view().name("readingList"))
			.andExpect(model().attributeExists("books"))
			.andExpect(model().attribute("books", is(Matchers.empty())));
	}
	
	@Test
	public void postBook() throws Exception
	{
		mockMvc.perform(post("/")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.param("title", "Book Title")
						.param("author", "Book Author")
						.param("isbn", "1234567890")
						.param("description", "I love this book"))
				.andExpect(status().is3xxRedirection())
				.andExpect(header().string("Location", "/"));
		
		Book expectedBook = new Book();
		expectedBook.setId(1L);
		expectedBook.setReader("craig");
		expectedBook.setTitle("Book Title");
		expectedBook.setAuthor("Book Author");
		expectedBook.setIsbn("1234567890");
		expectedBook.setDescription("I love this book");
		
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("readingList"))
			.andExpect(model().attributeExists("books"))
			.andExpect(model().attribute("books", hasSize(1)))
			.andExpect(model().attribute("books", contains(samePropertyValuesAs(expectedBook))));
	}
}
