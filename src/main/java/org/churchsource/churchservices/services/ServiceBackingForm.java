package org.churchsource.churchservices.services;

import lombok.*;
import org.churchsource.churchservices.model.type.ServiceType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.churchsource.churchservices.services.songs.SongItemBackingForm;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class ServiceBackingForm {

  private Long id;

  private Date serviceDate;

  @Enumerated(EnumType.STRING)
  private ServiceType serviceType;

  private Set<SongItemBackingForm> songItems = new HashSet<>();

  @Builder(builderMethodName = "aServiceBackingForm")
  public ServiceBackingForm(Long id, Date serviceDate, ServiceType serviceType, Set<SongItemBackingForm> songItems) {
    this.id=id;
    this.serviceDate = serviceDate;
    this.serviceType = serviceType;
    this.songItems = songItems;
  }
}

