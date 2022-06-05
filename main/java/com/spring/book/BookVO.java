package com.spring.book;



public class BookVO {
	private String  book_id;
	private String  title;
	private String  category;
	private String  price;
	private String  insert_date;
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	@Override
	public String toString() {
		return "BookVO [book_id=" + book_id + ", title=" + title + ", category=" + category + ", price=" + price
				+ ", insert_date=" + insert_date + "]";
	}
	
}
