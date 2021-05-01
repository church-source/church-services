package org.churchsource.churchservices.services;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.churchsource.churchservices.model.ChurchServiceEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SongItemFullViewModel extends ChurchServiceEntity<Long> implements Serializable {

  private static final long serialVersionUID = -3479479691039681608L;

/*  @JsonBackReference
  private ServiceFullViewModel service;
*/
  private String songCode;

  private int songOrder;

  @Builder(builderMethodName = "aSongItem")
  public SongItemFullViewModel(Long id, Date created, Date modified/*, ServiceFullViewModel service*/, String songCode, int songOrder, Boolean deleted) {
    super(id, created, modified, deleted);
    //this.service = service;
    this.songCode = songCode;
    this.songOrder = songOrder;
  }
}

