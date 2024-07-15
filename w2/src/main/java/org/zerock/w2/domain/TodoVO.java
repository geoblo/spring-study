package org.zerock.w2.domain;

import lombok.*;

import java.time.LocalDate;

@Getter // getter만 이용(읽기 전용), 주로 읽기 위주의 작업을 위해서만 사용
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
