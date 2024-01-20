package com.MEC.Data;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "playlists")
@ToString
@NoArgsConstructor
@Getter
@Setter
@Data
public class LocalData {

    @Id
    private String id;

    @Field("Values")
    private int value;

    public LocalData(int value) {
        this.value = value;
    }
}
