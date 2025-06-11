package com.louis.anonet.channel.model;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelMemberId implements Serializable {
    private UUID channelId;
    private UUID userId;
}