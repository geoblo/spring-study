package org.zerock.springex.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@ToString
@RequiredArgsConstructor
public class SampleService {

    // 필드 주입 방식
//    @Autowired
//    private SampleDAO sampleDAO;

    // (선호) 생성자 주입 방식 - 객체를 생성할 때 문제가 발생하는지를 미리 확인할 수 있기 때문에 선호됨, final 필드 사용 가능
//    private final SampleDAO sampleDAO;
    // 인터페이스를 이용한 느슨한 결합
    // SampleDAO를 다른 객체로 변경하려면 SampleService 코드 역시 수정되어야 함
    // 추상화된 타입을 이용하면 이러한 문제를 피할 수 있는데 가장 대표적인 것이 인터페이스
    // 인터페이스를 이용하면 실제 객체를 모르고 타입만을 이용해서 코드를 작성하는 일이 가능

    // (즉, 인터페이스를 구현한 클래스라면 어떤 객체든지 코드 수정 없이 대입 가능)
    // SampleService의 입장에서는 인터페이스만 바라보고 있기 때문에 실제 객체가 SampleDAOImpl의 인스턴스인지 알 수 없지만
    // 코드를 작성하는 데에는 아무런 문제가 없음
    // 이처럼 객체와 객체의 의존 관계의 실제 객체를 몰라도 가능하게 하는 방식을 '느슨한 결합'이라고 함
    // 느슨한 결합을 이용하면 나중에 SampleDAO 타입의 객체를 다른 객체로 변경하더라도 
    // SampleService 타입을 이용하는 코드를 수정할 일이 없기 때문에 보다 유연한 구조가 됨

    @Qualifier("normal") // 특정한 이름의 객체를 사용하도록 수정
    private final SampleDAO sampleDAO;

}
