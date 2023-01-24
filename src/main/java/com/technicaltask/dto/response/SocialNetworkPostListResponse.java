package com.technicaltask.dto.response;

import com.technicaltask.domain.SocialNetworkPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialNetworkPostListResponse {
     List<SocialNetworkPost> socialNetworkPostList;
}
