package org.churchsource.churchservices.services;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import lombok.*;

import org.churchsource.churchservices.services.songs.SongItem;
import org.hibernate.annotations.Where;

import org.churchsource.churchservices.model.ChurchServiceEntity;
import org.churchsource.churchservices.model.type.ServiceType;


@NamedQueries({
    @NamedQuery(name = ServiceNamedQueryConstants.NAME_GET_ALL_SERVICES,
        query = ServiceNamedQueryConstants.QUERY_GET_ALL_SERVICES),
    @NamedQuery(name = ServiceNamedQueryConstants.NAME_FIND_SERVICE_BY_ID,
        query = ServiceNamedQueryConstants.QUERY_FIND_SERVICE_BY_ID)
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

  private Date serviceDate;

  @Enumerated(EnumType.STRING)
  private ServiceType serviceType;

  @OneToMany(mappedBy = "service", fetch=FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
  @JsonManagedReference
  private Set<SongItem> songItems = new HashSet<SongItem>();

  @Builder(builderMethodName = "aService")
  public ChurchService(Long id, Date created, Date modified, Boolean deleted, Date serviceDate,
                       ServiceType serviceType, Set<SongItem> songItems) {
    super(id, created, modified, deleted);
    this.serviceDate = serviceDate;
    this.serviceType = serviceType;
    this.songItems = songItems;
  }
}

