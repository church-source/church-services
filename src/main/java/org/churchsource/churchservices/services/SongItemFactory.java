package org.churchsource.churchservices.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongItemFactory {

    public SongItem createSongItemEntity(SongItemBackingForm pbForm) {
        SongItem songItem = new SongItem();
        BeanUtils.copyProperties(pbForm, songItem, "deleted, service");
        return songItem;
    }

    public SongItemFullViewModel createSongItemFullViewModelFromEntity(SongItem songItem) {
        SongItemFullViewModel songItemFullViewModel = new SongItemFullViewModel();
        BeanUtils.copyProperties(songItem, songItemFullViewModel, "deleted, created, modified, service");
        return songItemFullViewModel;
    }
}
