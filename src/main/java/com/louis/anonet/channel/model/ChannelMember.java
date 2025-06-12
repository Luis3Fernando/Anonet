package com.louis.anonet.channel.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "channel_members")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ChannelMemberId.class)
public class ChannelMember {
    @Id
    @Column(name = "channel_id", nullable = false)
    private UUID channelId;

    @Id
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "joined_at", nullable = false, updatable = false)
    private Instant joinedAt;

    @PrePersist
    public void prePersist() {
        joinedAt = Instant.now();
    }
}