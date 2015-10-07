package xam.cross;

public class Book {

	public static Integer totalBooksCreated;
	
	static {
		if (totalBooksCreated == null)
			totalBooksCreated = 0;
	}
	
	private Integer id;
	
	private String title;
	private String authors;
	private Double price;
	
	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Book(){
		totalBooksCreated++;
		this.id = totalBooksCreated;
	}
	
	public Book(String authors, String title){
		this.authors = authors;
		this.title = title;
		totalBooksCreated++;
		this.id = totalBooksCreated;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
