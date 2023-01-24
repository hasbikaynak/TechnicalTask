package com.technicaltask.dto.response;

import com.technicaltask.domain.SocialNetworkPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialNetworkPostListResponse {
     List<SocialNetworkPost> socialNetworkPostList;
    //    private  Long id;
//
//    private Date postDate;
//
//    private String author;
//
//    private String content;
//
//    private Integer viewCount;
}
