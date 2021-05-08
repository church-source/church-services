package org.churchsource.churchservices.services;

import org.churchsource.churchservices.services.songs.SongItem;
import org.churchsource.churchservices.services.songs.SongItemBackingForm;
import org.churchsource.churchservices.services.songs.SongItemFactory;
import org.churchsource.churchservices.services.songs.SongItemFullViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ServiceFactory {


    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private SongItemFactory songItemFactory;

    public ChurchService createServiceEntity(ServiceBackingForm pbForm) {
        ChurchService aChurchService = new ChurchService();
        BeanUtils.copyProperties(pbForm, aChurchService, "deleted, songItems");
        Set<SongItemBackingForm> songItemBackingForms = pbForm.getSongItems();
        Set<SongItem> songItems = new HashSet<SongItem>();
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
        Set<SongItem> songItems = churchService.getSongItems();
        Set<SongItemFullViewModel> songItemsFullViewModels = new HashSet<SongItemFullViewModel>();//serviceFullViewModel.getSongItems();
        for(SongItem song : songItems) {
            //System.out.println("Got here");
            songItemsFullViewModels.add(songItemFactory.createSongItemFullViewModelFromEntity(song));
        }
        serviceFullViewModel.setSongItems(songItemsFullViewModels);
        return serviceFullViewModel;
    }
}
