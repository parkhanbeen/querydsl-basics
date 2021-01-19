package study.querydsl.board.product.inqury.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.querydsl.board.product.inqury.ProductInquryComments;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductInquryCommentsDto {

    private long id;
    private String subject;
    private String content;
    private LocalDateTime createDateTime;

    public ProductInquryCommentsDto(ProductInquryComments productInquryComments) {
        this.id = productInquryComments.getId();
        this.subject = productInquryComments.getSubject();
        this.content = productInquryComments.getContent();
        this.createDateTime = LocalDateTime.now();
    }
}
