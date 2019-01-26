package com.mylibrary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.mylibrary.model.Book;
import com.mylibrary.model.BookCopy;
import com.mylibrary.model.Customer;

public class MylibraryMain {

	private static List<Book> books = new ArrayList<Book>();
	private static List<Customer> customers = new ArrayList<Customer>();
	private static List<BookCopy> booksIssued = new ArrayList<BookCopy>();

	public static void main(String[] args) {
		addAllBooksAndCustomers();
		do {
			System.out.println("----------LIBRARY MANAGEMENT J8-----------");
			System.out.println("0. Stop app");
			System.out.println("1. Display all books");
			System.out.println("2. Display all customers");
			System.out.println("3. Display all issued books");
			System.out.println("4. issue books");
			System.out.println("5. return books");
			System.out.println("7. add books");
			System.out.println("8. add Customers");
			Scanner s = new Scanner(System.in);
			int choice = s.nextInt();
			switch (choice) {
			case 0:
				System.exit(0);
				break;
			case 1:
				displayAllBooks();
				break;
			case 2:
				displayAllCustomers();
				break;
			case 3:
				displayIssuesBooks();
				break;
			case 4:
				issueBooks();
				break;
			case 5:
				returnBooks();
				break;
			case 7:
				addBook();
				break;
			case 8:
				addCustomer();
				break;
			

			default:
				System.out.println("Enter correct choice");
				break;
			}
		} while (true);
	}


	private static void returnBooks() {
		System.out.print("Enter bookId -");
		Scanner s = new Scanner(System.in);
		Integer bookId = s.nextInt();
		System.out.print("Enter  cutomerId -");
		Integer customerId = s.nextInt();
		Boolean isIssued = checkIfBookAlreadyIssed(bookId,customerId);
		System.out.println("Is BookAlreadyIssed -> "+isIssued);
		if(isIssued) {
			/*booksIssued.stream()
						.filter(bi -> bi.getBookId().equals(bookId))
						.filter(bi -> bi.getCustomerId().equals(customerId))*/
			booksIssued.removeIf(bi -> bi.getBookId().equals(bookId) && bi.getCustomerId().equals(customerId));
						
		} else {
			System.out.println("No book is there in the IDs. Please check the inputs");
		}
	}


	private static void displayIssuesBooks() {
		booksIssued.forEach( bi -> {
			Book book = books.stream()
								.filter( b -> b.getId().equals(bi.getBookId()))
								.findFirst()
								.orElse(null);
			Customer customer = customers.stream()
											.filter(c -> c.getCutomerId().equals(bi.getCustomerId()))
											.findFirst()
											.orElse(null);
			System.out.println("Book "+book.getTitle()+" is issued to "+customer.getName());
		});
	}


	private static void issueBooks() {
		System.out.print("Enter bookId -");
		Scanner s = new Scanner(System.in);
		Integer bookId = s.nextInt();
		System.out.print("Enter  cutomerId -");
		Integer customerId = s.nextInt();
		Boolean isIssued = checkIfBookAlreadyIssed(bookId,customerId);
		System.out.println("Is BookAlreadyIssed -> "+isIssued);
		if(!isIssued) {
			booksIssued.add(new BookCopy(bookId, customerId, new Date()));
		} else {
			System.out.println("Book already issued");
		}
	}


	private static Boolean checkIfBookAlreadyIssed(Integer bookId, Integer customerId) {
//		return booksIssued.stream().filter(o -> o.getBookId().equals(bookId)).findFirst().isPresent();
		return booksIssued.stream().filter(o -> o.getBookId().equals(bookId))
				.filter(o -> o.getCustomerId().equals(customerId))
				.findFirst().isPresent();
	}


	private static void addBook() {
		System.out.println("Enter Book name , author");
		Scanner s = new Scanner(System.in);
		String bookName = s.next();
		String author = s.next();
		Optional<Book> opMaxBook = books.stream()
							.max(Comparator.comparing(Book::getId));
		Integer bookId = 1;
		if(opMaxBook.isPresent()){
			Book lastIdBook = opMaxBook.get();
			bookId = lastIdBook.getId();
		}
		books.add(new Book(bookId, bookName, author));
	}
	
	private static void addCustomer() {
		System.out.println("Enter Customer name , address");
		Scanner s = new Scanner(System.in);
		String name = s.next();
		String address = s.next();
		Optional<Customer> opMaxCustomer = customers.stream()
												.max(Comparator.comparing(Customer::getCutomerId));
		Integer customerId = 1;
		if(opMaxCustomer.isPresent()){
			Customer lastIdBook = opMaxCustomer.get();
			customerId = lastIdBook.getCutomerId();
		}
		books.add(new Book(customerId, name, address));
	}


	private static void displayAllCustomers() {
		if(customers.isEmpty()) {
			System.out.println("No Customers to display");
		}
		customers.stream()
					.forEach(System.out::println);
	}

	private static void displayAllBooks() {
		if(books.isEmpty()) {
			System.out.println("No Books to display");
		}
		books.stream()
					.forEach(System.out::println);
					
		
	}
	
	private static void sortBooks(){
		books.sort(Comparator.comparing(Book::getAuthor));
//		books.sort(Comparator.comparing(Book::getAuthor)
//								.thenComparing(Book::getTitle));
//		books.sort(Comparator.comparing(Book::getAuthor).reversed());	// desc
//		books.sort(Comparator.comparing( b -> b.getAuthor().toLowerCase()));
		Comparator<Book> comparator = Comparator.comparing(book -> book.getAuthor().toLowerCase());
		Book firstBook = books.stream()
								.min(comparator).get();
		Optional<Book> firstAuthor = books.stream()		// last value
				.max(Comparator.comparing(Book::getAuthor));
		if(firstAuthor.isPresent()){
			System.out.println("firstAuthor name");
			firstAuthor.ifPresent(System.out::println);
		}
	}

	private static void addAllBooksAndCustomers() {
		books.clear();
		books.add(new Book(1, "Gita", "Krishna"));
		books.add(new Book(2, "Mayavalai", "pa Ragavan"));
		books.add(new Book(3, "tell me your dreams", "sheldon"));
		books.add(new Book(10, "india 2020", "chetan"));
		books.add(new Book(5, "Five Point Someone", "chetan"));
		books.add(new Book(7, "wings of fire", "apj"));
		customers.clear();
		customers.add(new Customer(1, "Joe", "NY"));
		customers.add(new Customer(2, "kiran", "LS"));
	}

}
