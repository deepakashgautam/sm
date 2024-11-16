package com.scm.helper;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String content;

    @Builder.Default
    private MessageType messageType=MessageType.blue;
}
