package kr.sparta.bulk.order.sample;

import kr.sparta.bulk.order.model.Order;
import kr.sparta.bulk.order.model.OrderEditRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SampleEditOrders {
    private static final String[] BR = new String[] {"31요거트","월넛","디노 젤리","메롱 멜론","애플 민트","소금 우유 아이스크림","블랙 소르베","피치 요거트","민트 초콜릿 칩","우주 라이크 봉봉","뉴욕 치즈케이크","그린티","러브미","바닐라","초콜릿","초콜릿 칩","아몬드 봉봉","초콜릿 무스","오레오 쿠키 앤 크림","바람과 함께 사라지다","엄마는 외계인","자모카 아몬드 훠지","이상한 나라의 슈팅스타","북극곰 폴라베어","봉쥬르, 마카롱","슈팅스타","초코나무 숲","레인보우 샤베트","블루베리 요거트","베리베리 스트로베리","체리쥬빌레","피스타치오 아몬드"};
    private static final String[] STATES = new String[] {"서울","부산","대구","인천","광주","대전","경기","강원","충북","충남","전북","전남","경북","경남","제주"};
    private static final RandomGenerator gen = RandomGenerator.of("L128X256MixRandom");

    public static List<OrderEditRequest> getRandomEditList(List<Order> orderList, List<Integer> targets) {

        // 수정될 대상이 저장 될 리스트
        final List<OrderEditRequest> editOrders = new ArrayList<>(targets.size());

        for (Integer random: targets) {
            // 기존 주문
            final Order order = orderList.get(random);

            // 랜덤 수정
            final String newIceCream = BR[gen.nextInt(BR.length)];
            final int newQuantity = gen.nextInt(1,50);
            final String newAddress = STATES[gen.nextInt(STATES.length)];

            // 수정 DTO 생성
            final OrderEditRequest editedOrder = OrderEditRequest.builder()
                    .id(order.getId())
                    .product(newIceCream)
                    .quantity(newQuantity)
                    .customerName(order.getCustomerName())
                    .customerAddress(newAddress)
                    .build();

            editOrders.add(editedOrder);
        }

        return editOrders;
    }


}