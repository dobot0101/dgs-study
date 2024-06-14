package com.dobot.dgs_study;

import java.util.UUID;

import com.dobot.dgs_study.dtos.CreateAlbumRequestDto;
import com.dobot.dgs_study.entities.Album;
import com.dobot.dgs_study.types.DeleteAlbumPayload;
import com.dobot.dgs_study.types.UpdateAlbumInput;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class AlbumMutationResolver {
  private final AlbumRepository albumRepository;

  public AlbumMutationResolver(AlbumRepository albumRepository) {
    this.albumRepository = albumRepository;
  }

  @DgsMutation()
  // 아래와 같이 dgs generator가 생성한 CreateAlbumInput을 사용해도 되고, 직접 DTO를 만들어서 사용해도 된다.
  // (직접 만든 DTO의 이름이 graphql 스키마의 input 이름과 달라도 됨. 다만 필드 이름은 같아야 함)
  // 하지만 직접 만든 DTO가 record이면 안된다.
  // public Album createAlbum(@InputArgument
  // com.dobot.dgs_study.types.CreateAlbumInput input) {
  public Album createAlbum(@InputArgument CreateAlbumRequestDto input) {
    var album = Album.builder().artist(input.getArtist()).title(input.getTitle()).id(UUID.randomUUID()).build();
    return albumRepository.save(album);
  }

  @DgsMutation
  public Album updateAlbum(@InputArgument UpdateAlbumInput input) {
    var album = albumRepository.findById(UUID.fromString(input.getId()))
        .orElseThrow(() -> new RuntimeException("Album not found"));
    album.setArtist(input.getArtist());
    album.setTitle(input.getTitle());
    return albumRepository.save(album);
  }

  @DgsMutation
  public DeleteAlbumPayload deleteAlbum(@InputArgument UUID id) {
    albumRepository.findById(id).orElseThrow(() -> new RuntimeException("Album not found"));
    albumRepository.deleteById(id);
    return new DeleteAlbumPayload(id.toString(), true);
  }
}
