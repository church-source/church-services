package org.churchsource.churchservices.services;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.churchsource.churchservices.model.type.ServiceType;
import org.churchsource.churchservices.services.songs.SongItemFullViewModel;
import org.churchsource.churchservices.services.songs.SongItemListViewModel;
import org.churchsource.churchservices.viewmodel.BaseViewModel;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ServiceListViewModel extends BaseViewModel<Long> implements Serializable {

  private static final long serialVersionUID = -3479479691039681608L;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
  private LocalDate serviceDate;

  @Enumerated(EnumType.STRING)
  private ServiceType serviceType;

  //@JsonManagedReference
  private List<SongItemListViewModel> songItems = new ArrayList<SongItemListViewModel>();

  @Builder(builderMethodName = "aServiceFullViewModel")
  public ServiceListViewModel(Long id, LocalDate serviceDate, ServiceType serviceType, List<SongItemListViewModel> songItems) {
    super(id);
    this.serviceDate = serviceDate;
    this.serviceType = serviceType;
    this.songItems = songItems;
  }
}

