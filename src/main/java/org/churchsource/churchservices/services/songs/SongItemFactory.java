package org.churchsource.churchservices.services.songs;

import org.churchsource.churchservices.services.ServiceFactory;
import org.churchsource.churchservices.services.ServicesRepository;
import org.churchsource.churchservices.services.ChurchService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SongItemFactory {

    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private ServiceFactory serviceFactory;

    public SongItem createSongItemEntity(SongItemBackingForm pbForm) {
        SongItem songItem = new SongItem();
        BeanUtils.copyProperties(pbForm, songItem);
        return songItem;
    }

    public SongItemFullViewModel createSongItemFullViewModelFromEntity(SongItem songItem, LocalDate serviceDate) {
        SongItemFullViewModel songItemFullViewModel = new SongItemFullViewModel();
        BeanUtils.copyProperties(songItem, songItemFullViewModel);
        ChurchService lastChosenService = servicesRepository.getLastServiceChosen(songItem.getSongCode(), serviceDate);
        if(lastChosenService != null) {
            songItemFullViewModel.setLastChosenService(serviceFactory.createLastChosenServiceViewModelFromEntity(lastChosenService));
        }
        return songItemFullViewModel;
    }
}
