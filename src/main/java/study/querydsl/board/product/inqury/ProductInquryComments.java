package study.querydsl.board.product.inqury;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductInquryComments {

    @Id @GeneratedValue
    private Long id;

    private String subject;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_inqury_id")
    private ProductInqury productInqury;

    public ProductInquryComments(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }
}
