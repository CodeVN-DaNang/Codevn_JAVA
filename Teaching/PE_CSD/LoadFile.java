import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoadFile {
    public ArrayList<Books> getAllBooks() {
        ArrayList<Books> bookList = new ArrayList<>();
        try {
            FileReader fr = new FileReader("./books.csv");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] part = line.split(";");
                String isbn = part[0].trim();
                String bookTitle = part[1].trim();
                String bookAuthor = part[2].trim();
                String yearOfPublication = part[3].trim();
                String publisher = part[4].trim();
                String imgUrlS = part[5].trim();
                String imgUrlM = part[6].trim();
                String imgUrlL = part[7].trim();
                Books book = new Books(isbn, bookTitle, bookAuthor, yearOfPublication, publisher, imgUrlS, imgUrlM, imgUrlL);
                bookList.add(book);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return bookList;
    }

    public static void main(String[] args) {
        List<Books> sortBooks = new LoadFile().getAllBooks();
        Collections.sort(sortBooks);
        for (Books books : sortBooks) {
            System.out.println(books.toString());
        }

    }

}
