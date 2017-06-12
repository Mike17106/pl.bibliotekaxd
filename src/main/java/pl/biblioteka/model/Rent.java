package pl.biblioteka.model;

import jdk.nashorn.internal.parser.Token;
import org.hibernate.sql.ordering.antlr.GeneratedOrderByFragmentRendererTokenTypes;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigInteger;
import java.util.Date;
import java.security.SecureRandom;
@Entity
@Table(name = "rent")
public class Rent {

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookid;
    private String token;
    private Date createdate;
    public Rent(String token, Book book) {
        this.token = token;
        this.book = book;
        this.createdDate = new Date();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public final class GenerationToken {
        private SecureRandom random = new SecureRandom();

        public String TokenGenerator() {
            return new BigInteger(130, random).toString(32);
        }
    }
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public String getToken(String BigInteger){
        return  this.token = BigInteger;
    }
    public String setToken(String BigInteger){
        return token;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((token == null) ? 0 : token.hashCode());
        result = prime * result + ((createdDate == null) ? 0 : createdate.hashCode());
        return result;
    }

}
