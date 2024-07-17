package org.zerock.springex.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
//@Primary
@Qualifier("event")
public class EventSampleDAOImpl implements SampleDAO { // 특정한 기간에만 사용할 객체
}

// 이렇게 되면 SampleService에 필요한 SampleDAO 타입의 빈(Bean)이 두 개(SampleDAOImpl, EventSampleDAOImpl)가 되기 때문에
// 스프링의 입장에서는 어떤 것을 주입해야 하는지 알 수 없게 됨

// 해결 방법
// 1) 두 클래스 중에 하나를 @Primary라는 어노테이션으로 지정
// 2) @Qualifier 이용하기(이름을 지정해서 특정한 이름의 객체를 주입하는 방식)
