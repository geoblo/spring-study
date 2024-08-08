package org.zerock.springex.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

// 제네릭을 이용해서 설계
// 이유? 나중에 다른 종류의 객체를 이용해서 PageResponseDTO를 구성할 수 있도록 하기 위해
// 예를 들어 게시판이나 회원 정보 등도 페이징 처리가 필요할 수 있기 때문에 공통적인 처리를 위해서 제네릭으로 구성
@Getter
@ToString
public class PageResponseDTO<E> {
    // TodoDTO의 목록
    // 전체 데이터의 수
    // 페이지 번호의 처리를 위한 데이터들(시작 페이지 번호/끝 페이지 번호)

    private int page;
    private int size;
    private int total;

    // 시작 페이지 번호
    private int start;
    // 끝 페이지 번호
    private int end;

    // 이전 페이지 존재 여부
    private boolean prev;
    // 다음 페이지 존재 여부
    private boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        // 마지막 페이지/시작 페이지 번호의 계산
        this.end = (int)(Math.ceil(this.page / 10.0)) * 10;
        this.start = this.end - 9;

        int last = (int)(Math.ceil(total / (double)size));
        this.end = end > last ? last : end;

        // 이전(prev)/다음(next)의 계산
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }
}
