package study.querydsl.board.product.inqury;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInquryRepository extends JpaRepository<ProductInqury, Long>, ProductInquryCustom {
}
