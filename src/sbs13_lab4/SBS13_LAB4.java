package sbs13_lab4;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

public class SBS13_LAB4 {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<BooksDescription> criteriaBooksDescription = cb.createQuery(BooksDescription.class);
        Root<BooksDescription> rootBooksDescription = criteriaBooksDescription.from(BooksDescription.class);
        criteriaBooksDescription.select(rootBooksDescription).where(cb.like(rootBooksDescription.get("pages"), "%12%"));

        CriteriaQuery<Books> criteriaBooks = cb.createQuery(Books.class);
        Root<Books> rootBooks = criteriaBooks.from(Books.class);
        Predicate[] predicates = new Predicate[2];
        predicates[0] = cb.like(rootBooks.get("name"), "%а и м%");
        predicates[1] = cb.like(rootBooks.get("publisher"), "%ксм%");
        criteriaBooks.select(rootBooks).where(predicates);

        BooksDescription booksDescription1 = new BooksDescription();
        booksDescription1.setPages("125 стр");
        booksDescription1.setGenres("Фэнтези");
        session.save(booksDescription1);

        BooksDescription booksDescription2 = new BooksDescription();
        booksDescription2.setPages("250 стр");
        booksDescription2.setGenres("Детектив");
        session.save(booksDescription2);

        org.hibernate.Transaction tr = session.beginTransaction();
        session.delete(booksDescription1);
//        session.delete(booksDescription2);
        tr.commit();

        Books book = new Books();
        book.setName("Война и мир");
        book.setPublisher("Эксмо");
        book.setBooksDescription(new BooksDescription("300 стр", "Классика"));
        session.save(book);

        book = (Books) session.get(Books.class, book.getId());
        session.save(book);

        List<Books> resultsBooks = session.createQuery(criteriaBooks).getResultList();
        resultsBooks.forEach((item) -> {
            System.out.println(item);
        });

        List<BooksDescription> resultsBooksDescription = session.createQuery(criteriaBooksDescription).getResultList();
        resultsBooksDescription.forEach((item) -> {
            System.out.println(item);
        });

        session.close();

        System.exit(0);
    }

}
