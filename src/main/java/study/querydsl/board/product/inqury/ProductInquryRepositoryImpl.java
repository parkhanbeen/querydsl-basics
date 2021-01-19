package study.querydsl.board.product.inqury;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import study.querydsl.board.product.inqury.dto.ProductInquryDto;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.stream.Collectors;

import static study.querydsl.board.product.inqury.QProductInqury.*;
import static study.querydsl.board.product.inqury.QProductInquryComments.*;
import static study.querydsl.entity.QMember.*;

@Repository
public class ProductInquryRepositoryImpl implements ProductInquryCustom{

    private final JPAQueryFactory queryFactory;

    public ProductInquryRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ProductInquryDto> getProductInquryList() {

        List<ProductInqury> results = queryFactory
                .selectFrom(productInqury)
                .join(productInqury.member, member).fetchJoin()
                .join(productInqury.productInquryComments, productInquryComments).fetchJoin()
                .fetch();

        return results.stream()
                .map(ProductInquryDto::new)
                .collect(Collectors.toList());

    }
}
