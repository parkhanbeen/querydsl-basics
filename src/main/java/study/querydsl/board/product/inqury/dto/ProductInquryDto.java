package study.querydsl.board.product.inqury.dto;

import lombok.*;
import study.querydsl.board.product.inqury.ProductInqury;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
@ToString
public class ProductInquryDto {

    private long id;
    private String subject;
    private String content;
    private LocalDateTime createDateTime;
    private String userName;
    private List<ProductInquryCommentsDto> productInquryComments = new ArrayList<>();

    public ProductInquryDto(ProductInqury productInqury) {
      this.id = productInqury.getId();
      this.subject = productInqury.getSubject();
      this.content = productInqury.getContent();
      this.createDateTime = LocalDateTime.now();
      this.userName = productInqury.getMember().getUsername();
      this.productInquryComments = productInqury.getProductInquryComments()
              .stream().map(ProductInquryCommentsDto::new)
              .collect(Collectors.toList());

    }
}
