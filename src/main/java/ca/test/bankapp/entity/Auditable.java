package ca.test.bankapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class Auditable {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    public LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    public LocalDateTime updatedAt;

    public String createdBy;
    public String updatedBy;

}
