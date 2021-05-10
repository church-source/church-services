package org.churchsource.churchservices.services.songs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;
import org.churchsource.churchservices.model.ChurchServiceEntity;
import org.churchsource.churchservices.services.ChurchService;
import org.churchsource.churchservices.services.ServiceNamedQueryConstants;

import javax.persistence.*;
import java.io.Serializable;

/*
@NamedQueries({

})
*/

@Getter
@Setter
@ToString(exclude="service")
@EqualsAndHashCode(exclude="service")
@NoArgsConstructor
@Entity
@Table(name="SongItem")
@IdClass(SongItemId.class)
public class SongItem implements Serializable {

  private static final long serialVersionUID = -3479479691039681608L;

  @ManyToOne
  @JoinColumn(name = "service")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Id
  private ChurchService service;

  @Id
  private String songCode;

  private int songOrder;

  @Builder(builderMethodName = "aSongItem")
  public SongItem(ChurchService service, String songCode, int songOrder) {
    this.service = service;
    this.songCode = songCode;
    this.songOrder = songOrder;
  }

}

