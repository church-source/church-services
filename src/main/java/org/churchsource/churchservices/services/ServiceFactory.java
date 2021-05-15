package org.churchsource.churchservices.services;

import org.churchsource.churchservices.services.songs.SongItem;
import org.churchsource.churchservices.services.songs.SongItemBackingForm;
import org.churchsource.churchservices.services.songs.SongItemFactory;
import org.churchsource.churchservices.services.songs.SongItemFullViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceFactory {

    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private SongItemFactory songItemFactory;

    public ChurchService createServiceEntity(ServiceBackingForm pbForm) {
        ChurchService aChurchService = new ChurchService();
        BeanUtils.copyProperties(pbForm, aChurchService, "deleted, songItems");
        List<SongItemBackingForm> songItemBackingForms = pbForm.getSongItems();
        List<SongItem> songItems = new ArrayList<SongItem>();
        for(SongItemBackingForm song : songItemBackingForms) {
            SongItem aSongItem = songItemFactory.createSongItemEntity(song);
            aSongItem.setService(aChurchService);
            songItems.add(aSongItem);
        }
        aChurchService.setSongItems(songItems);
        return aChurchService;
    }

    public ServiceFullViewModel createServiceFullViewModelFromEntity(ChurchService churchService) {
        ServiceFullViewModel serviceFullViewModel = new ServiceFullViewModel();
        BeanUtils.copyProperties(churchService, serviceFullViewModel, "deleted, created, modified");
        List<SongItem> songItems = churchService.getSongItems();
        List<SongItemFullViewModel> songItemsFullViewModels = new ArrayList<SongItemFullViewModel>();//serviceFullViewModel.getSongItems();
        for(SongItem song : songItems) {
            songItemsFullViewModels.add(songItemFactory.createSongItemFullViewModelFromEntity(song, churchService.getServiceDate()));
        }
        serviceFullViewModel.setSongItems(songItemsFullViewModels);
        return serviceFullViewModel;
    }

    public LastChosenServiceViewModel createLastChosenServiceViewModelFromEntity(ChurchService churchService) {
        LastChosenServiceViewModel serviceFullViewModel = new LastChosenServiceViewModel();
        BeanUtils.copyProperties(churchService, serviceFullViewModel, "deleted, created, modified, songItems");
        return serviceFullViewModel;
    }
}
