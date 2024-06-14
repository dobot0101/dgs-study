package com.dobot.dgs_study;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dobot.dgs_study.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, UUID> {

}
