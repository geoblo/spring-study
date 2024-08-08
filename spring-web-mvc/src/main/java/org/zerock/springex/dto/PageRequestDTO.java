package org.zerock.springex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    // 페이지 번호
    @Builder.Default // 기본값을 가지기 위해서 사용
    @Min(value = 1)
    @Positive
    private int page = 1;

    // 한 페이지당 개수
    @Builder.Default // 기본값을 가지기 위해서 사용
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;

    // 건너뛸 수를 계산
    public int getSkip() {
        return (page - 1) * size;
    }
}
