package study.querydsl.board.product.inqury;

import lombok.*;
import study.querydsl.entity.Member;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductInqury {

    @Id @GeneratedValue
    private Long id;

    private String subject;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "productInqury", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductInquryComments> productInquryComments = new ArrayList<>();

    @Builder
    public ProductInqury(String subject, String content, Member member, List<ProductInquryComments> productInquryComments) {
        this.subject = subject;
        this.content = content;
        this.member = member;
        this.productInquryComments = productInquryComments;

    }
}
