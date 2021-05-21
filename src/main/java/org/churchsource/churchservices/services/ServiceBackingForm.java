package org.churchsource.churchservices.services;

import lombok.*;
import org.churchsource.churchservices.model.type.ServiceType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.churchsource.churchservices.services.songs.SongItemBackingForm;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class ServiceBackingForm {

  private Long id;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate serviceDate;

  @Enumerated(EnumType.STRING)
  private ServiceType serviceType;

  private List<SongItemBackingForm> songItems = new ArrayList<SongItemBackingForm>();

  @Builder(builderMethodName = "aServiceBackingForm")
  public ServiceBackingForm(Long id, LocalDate serviceDate, ServiceType serviceType, List<SongItemBackingForm> songItems) {
    this.id=id;
    this.serviceDate = serviceDate;
    this.serviceType = serviceType;
    this.songItems = songItems;
  }
}

