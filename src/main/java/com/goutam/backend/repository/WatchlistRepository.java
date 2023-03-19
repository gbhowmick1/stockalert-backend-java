package com.goutam.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.goutam.backend.model.Watchlist;

public interface WatchlistRepository extends JpaRepository<Watchlist,Integer> {

}
