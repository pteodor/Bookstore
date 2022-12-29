package pl.first.project.book.store.database.memory;

import org.springframework.stereotype.Component;
import pl.first.project.book.store.database.IBookDAO;
import pl.first.project.book.store.model.Book;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class BookDatabase implements IBookDAO {
    private List<Book> books = new ArrayList<>();

    public BookDatabase() {
        books.add(new Book(1, "Uzbekistan. Perła Jedwabnego Szlaku", "Miron Kokosiński", "Bezdroża", "Uzbekistan to najbardziej znany i najczęściej odwiedzany przez turystów kraj Azji Środkowej, ucieleśniający romantyczne wyobrażenia o starożytnym Wschodzie i Jedwabnym Szlaku. Znajdziemy tu wspaniałe średniowieczne miasta słynące z bogato zdobionych meczetów, medres i karawanserajów, mauzolea miejscowych władców, pustynne twierdze, a także zabytki, muzea i inne pamiątki związane z okresem, gdy ziemie te pozostawały pod panowaniem carskiej Rosji i Związku Radzieckiego. Orientalna egzotyka, której odcienie zawdzięcza Uzbekistan rodzimym plemionom turkijskim - protoplastom Uzbeków, oraz kolejnym obecnym tu potęgom - Persom, Seleucydom, Arabom, Mongołom i in., przeplata się tu z siermiężną, wciąż silnie zakorzenioną rzeczywistością radziecką. Nasyceni obcowaniem z perłami architektury - skarbami Samarkandy, Buchary i Chiwy, chwilę odpoczynku znajdziemy w Górach Czatkalskich i innych przyrodniczych enklawach. Wyjątkowym przeżyciem będzie także spotkanie z pustynią Kyzył-kum, półwyschniętym Jeziorem Aralskim i bezkresnymi pustaciami płaskowyżu Ustiurt, gdzie dotrą tylko najwytrwalsi.", 26.99, "978-83-283-5143-1",  "dostępny", 5));
        books.add(new Book(2, "Mjanma (Birma). Travelbook", "Miron Kokosiński", "Bezdroża", "Mjanma (Birma) to jeden z najciekawszych, a mimo to rzadko odwiedzanych przez turystów z Zachodu krajów Dalekiego Wschodu. Ci, którzy podejmą wyzwanie zwiedzenia tego zakątka Azji, odnajdą tu starożytne miasta zagubione pośród dżungli, niezliczone buddyjskie sanktuaria i pamiątki po kolonialnej przeszłości brytyjskiej Birmy. Wyprawa do Mjanmy będzie też okazją do spotkania z egzotyczną przyrodą i intrygującą kulturą, której wyrazem są nie tylko unikatowe obyczaje i kuchnia, ale także powszechna uprzejmość oraz... wiara w magię liczb i astrologię.", 21.99, "978-83-283-6489-9",  "w przygotowaniu", 0));
        books.add(new Book(3, "Polska marzeń", "Miron Kokosiński", "SBM", "(...)", 21.99, "978-83-283-6666-1",  "w przygotowaniu", 0));
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public List<Book> getFilteredBooks(String pattern) {
        throw new NotImplementedException();
    }

    @Override
    public Optional<Book> getBookById(int id) {
        throw new NotImplementedException();
    }

    @Override
    public void updateBook(Book book) {
        throw new NotImplementedException();
    }
}
