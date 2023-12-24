/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Library;
import java.util.Scanner;
import model.Book;

public class LibraryManagement extends Menu<Book> {

    Library library = new Library();
    Scanner sc = new Scanner(System.in);

    public LibraryManagement(String td, String[] mc) {
        super(td, mc);
    }

    public void searching() {
        String mChonSearch[] = {"search by id", "search by title", "search by author", "search by year published"};
        Menu searchMenu = new Menu("Search Menu", mChonSearch) {
            @Override
            public void execute(int n) {
                System.out.println("Input criteria to finds");
                String finds = sc.nextLine();
                switch (n) {
                    case 1:
                        library.searchBook(p -> p.getBookId().equalsIgnoreCase(finds));
                        break;
                    case 2:
                        library.searchBook(p -> p.getBookTitle().contains(finds));
                        break;
                    case 3:
                        library.searchBook(p -> p.getAuthor().contains(finds));
                        break;
                    case 4:
                        library.searchBook(p -> p.getYearPublished() == Integer.parseInt(finds));
                        break;
                    default:
                        break;
                }
            }
        };
        searchMenu.run();
    }
    
    public static void main(String[] args) {
        String mChon[] = {"list all books", "add new book", "search book", "exit"};
        LibraryManagement libraryManagement = new LibraryManagement("MAIN MENU", mChon);
        libraryManagement.run();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                library.getAllBooks();
                break;
            case 2:
                library.addNewBook();
                break;
            case 3:
                searching();
                break;
            case 4:
                System.exit(0);
            default:
                break;
        }
    }
}
