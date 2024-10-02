package com.ex.quizCRUD.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {
    // 생성날짜가 자동으로 입력, updatable 누가 강제로 업데이트를 하더라도 수정 안되게!
    @CreatedDate
    @Column(name="inserted_at", updatable = false)
    private LocalDateTime insertedAt;

    // 수정날짜가 자동으로 입력,
    @LastModifiedDate
    @Column(name="updated_at",insertable = false)
    private LocalDateTime updatedAt;
}
