package com.dobot.dgs_study;

import java.util.List;
import java.util.UUID;

import com.dobot.dgs_study.entities.Album;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class AlbumQueryResolver {
  private final AlbumRepository albumRepository;

  public AlbumQueryResolver(AlbumRepository albumRepository) {
    this.albumRepository = albumRepository;
  }

  @DgsQuery
  public List<Album> albums(@InputArgument String titleFilter) {
    var albums = albumRepository.findAll();
    if (titleFilter == null) {
      return albums;
    }
    return albums.stream().filter(album -> album.getTitle().contains(titleFilter)).toList();
  }

  @DgsQuery
  public Album album(@InputArgument UUID id) {
    return albumRepository.findById(id).orElseThrow(() -> new RuntimeException("Album not found"));
  }
}
