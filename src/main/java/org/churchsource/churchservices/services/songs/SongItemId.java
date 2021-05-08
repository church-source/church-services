package org.churchsource.churchservices.services.songs;

import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class SongItemId implements Serializable {
    private Long service;

    private String songCode;

    public SongItemId(Long service, String songCode) {
        this.service = service;
        this.songCode = songCode;
    }
}

