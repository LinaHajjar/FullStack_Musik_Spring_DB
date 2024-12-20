package com.example.fullstack_musik_spring_db.Repository;

import com.example.fullstack_musik_spring_db.Model.Album;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class AlbumRepo {
    @Autowired
    JdbcTemplate template;

    public List<Album> get_All_Albums() throws SQLException {
        String sql= "SELECT * FROM album";
        RowMapper<Album> rowMapper=new BeanPropertyRowMapper<>(Album.class);
        return template.query(sql, rowMapper);
    }

    public void addAlbum(Album a){
        String sql = "INSERT INTO album (id, title, artist, tracks, releaseDate, company) VALUES (?, ?, ?, ?, ?,?)";
        template.update(sql, a.getId(), a.getTitle(), a.getArtist(), a.getTracks(), a.getReleaseDate(), a.getCompany());
    }

    public Album findAlbumById(int id) throws SQLException {
        String sql = "SELECT * FROM album WHERE id = ?";
        RowMapper<Album> rowMapper = new BeanPropertyRowMapper<>(Album.class);
        Album album = template.queryForObject(sql, rowMapper, id);
        return album;
    }

    public Boolean deleteAlbum(int id){
        String sql = "DELETE FROM album WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    public void updateAlbum(Album album){
        String sql="UPDATE album SET title=?, artist=?, tracks=?, releaseDate=?, company=? WHERE id = ?";
        template.update(sql, album.getTitle(), album.getArtist(), album.getTracks(), album.getReleaseDate(), album.getCompany(), album.getId());
    }

}

