package org.churchsource.churchservices.services;

import lombok.extern.slf4j.Slf4j;
import org.churchsource.churchservices.model.type.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/songs")
@Slf4j
public class SongInServiceController {

  @Autowired
  private SongInServiceRepository songInServiceRepository;


  @GetMapping("/lastplayed")
  @PreAuthorize("hasAuthority('ViewService')")
  public List<SongLastChosenDateDTO> getLastPlayedDateOfAllSongs() {

    List<SongLastChosenDateDTO> songsAndlastPlayedDates = songInServiceRepository.getLastPlayedDateOfAllSongs();
    return songsAndlastPlayedDates;
  }
}
