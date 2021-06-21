package org.churchsource.churchservices.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;


public interface SongInServiceRepository extends Repository<SongLastChosenDateDTO, Long> {
    @Query(value="SELECT si.songCode, s.serviceDate from SongItem si " +
            "INNER JOIN Service s on si.service = s.id " +
            "WHERE s.serviceDate = (SELECT max(s2.serviceDate) from SongItem si2  " +
            "INNER JOIN Service s2 on si2.service = s2.id  " +
            "WHERE si.songCode = si2.songCode)  " +
            "order by s.serviceDate desc", nativeQuery = true)
    public List<SongLastChosenDateDTO> getLastPlayedDateOfAllSongs();
    // new org.churchsource.churchservices.services.SongLastChosenDateDTO(
}


