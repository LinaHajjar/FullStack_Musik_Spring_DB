package com.example.fullstack_musik_spring_db.Service;

import com.example.fullstack_musik_spring_db.Model.Album;
import com.example.fullstack_musik_spring_db.Repository.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    AlbumRepo albumRepo;

    public List<Album> get_All_Albums() throws SQLException {
        return albumRepo.get_All_Albums();
    }

    public void addAlbum(Album a){
        albumRepo.addAlbum(a);
    }

    public Album findAlbumById(int id) throws SQLException {
        return albumRepo.findAlbumById(id);
    }
    public boolean deleteAlbum(int id) throws SQLException {
        return albumRepo.deleteAlbum(id);
    }

    public void updateAlbum(Album album) throws SQLException {
        albumRepo.updateAlbum(album);
    }

}
