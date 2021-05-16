package org.churchsource.churchservices.services;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

import lombok.*;

import org.churchsource.churchservices.services.songs.SongItem;

import org.churchsource.churchservices.model.ChurchServiceEntity;
import org.churchsource.churchservices.model.type.ServiceType;


@NamedQueries({
    @NamedQuery(name = ServiceNamedQueryConstants.NAME_GET_ALL_SERVICES,
        query = ServiceNamedQueryConstants.QUERY_GET_ALL_SERVICES),
    @NamedQuery(name = ServiceNamedQueryConstants.NAME_FIND_SERVICE_BY_ID,
        query = ServiceNamedQueryConstants.QUERY_FIND_SERVICE_BY_ID),
    @NamedQuery(name = ServiceNamedQueryConstants.NAME_GET_SERVICES_BY_DATE_AND_TYPE,
        query = ServiceNamedQueryConstants.QUERY_GET_SERVICES_BY_DATE_AND_TYPE),
    @NamedQuery(name = ServiceNamedQueryConstants.NAME_GET_SERVICES_BETWEEN_DATES,
        query = ServiceNamedQueryConstants.QUERY_GET_SERVICES_BETWEEN_DATES),
    @NamedQuery(name = ServiceNamedQueryConstants.NAME_GET_LAST_SERVICE_CHOSEN,
        query = ServiceNamedQueryConstants.QUERY_GET_LAST_SERVICE_CHOSEN)
})

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name="Service")
public class ChurchService extends ChurchServiceEntity<Long> implements Serializable {

  private static final long serialVersionUID = -3479479691039681608L;

  private LocalDate serviceDate;

  @Enumerated(EnumType.STRING)
  private ServiceType serviceType;

  @OneToMany(mappedBy = "service", fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  @org.hibernate.annotations.OrderBy(clause = "songOrder asc")
  private List<SongItem> songItems = new ArrayList<SongItem>();

  @Builder(builderMethodName = "aService")
  public ChurchService(Long id, Date created, Date modified, Boolean deleted, LocalDate serviceDate,
                       ServiceType serviceType, List<SongItem> songItems) {
    super(id, created, modified, deleted);
    this.serviceDate = serviceDate;
    this.serviceType = serviceType;
    this.songItems = songItems;
  }
}

