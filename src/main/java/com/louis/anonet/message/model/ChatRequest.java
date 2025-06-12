package com.louis.anonet.message.model;

import com.louis.anonet.user.model.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "chat_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatRequest {

    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "from_user_id", nullable = false)
    private User from;

    @ManyToOne(optional = false)
    @JoinColumn(name = "to_user_id", nullable = false)
    private User to;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = Instant.now();
        if (status == null) status = RequestStatus.PENDING;
    }
}
