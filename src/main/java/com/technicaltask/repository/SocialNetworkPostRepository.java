package com.technicaltask.repository;

import com.technicaltask.domain.SocialNetworkPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialNetworkPostRepository extends JpaRepository<SocialNetworkPost, Long> {
    List<SocialNetworkPost> findTop10ByOrderByViewCountDesc();
}
