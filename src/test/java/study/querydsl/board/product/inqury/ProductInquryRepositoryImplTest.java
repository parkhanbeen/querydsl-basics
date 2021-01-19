package study.querydsl.board.product.inqury;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.board.product.inqury.dto.ProductInquryDto;
import study.querydsl.entity.Member;
import study.querydsl.entity.Team;
import study.querydsl.repository.MemberRepository;
import study.querydsl.repository.MemberTestRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductInquryRepositoryImplTest {

    @Autowired ProductInquryRepository productInquryRepository;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    public void getProductInquryList() {

        List<Member> members = memberRepository.findAll();

        for (Member member : members) {
            List<ProductInquryComments> commentsList = new ArrayList<>();
            commentsList.add(new ProductInquryComments("commentSubject" + member.getId(), "commentContent" + member.getId()));
            commentsList.add(new ProductInquryComments("commentSubject" + member.getId(), "commentContent" + member.getId()));
            commentsList.add(new ProductInquryComments("commentSubject" + member.getId(), "commentContent" + member.getId()));

            em.persist(ProductInqury.builder()
                    .subject("subject" + member.getId())
                    .content("content" + member.getId())
                    .member(member)
                    .build());

        }


        List<ProductInquryDto> productInquryList =
                productInquryRepository.getProductInquryList();

        for (ProductInquryDto productInquryDto : productInquryList) {
            System.out.println("productInquryDto = " + productInquryDto);
        }


        assertThat(productInquryList).isNotNull();
    }

}