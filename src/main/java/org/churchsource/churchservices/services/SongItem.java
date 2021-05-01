package org.churchsource.churchservices.services;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;
import org.churchsource.churchservices.model.ChurchServiceEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@ToString(callSuper = true, exclude="service")
@EqualsAndHashCode(callSuper = true, exclude="service")
@NoArgsConstructor
@Entity
@Table(name="SongItem")
public class SongItem extends ChurchServiceEntity<Long> implements Serializable {

  private static final long serialVersionUID = -3479479691039681608L;

  @ManyToOne
  @JoinColumn(name = "service")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private ChurchService service;

  private String songCode;

  private int songOrder;

  @Builder(builderMethodName = "aSongItem")
  public SongItem(Long id, Date created, Date modified, ChurchService service, String songCode, int songOrder, Boolean deleted) {
    super(id, created, modified, deleted);
    this.service = service;
    this.songCode = songCode;
    this.songOrder = songOrder;
  }

}

