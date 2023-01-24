package com.technicaltask.service;

import com.technicaltask.domain.SocialNetworkPost;
import com.technicaltask.dto.request.SocialNetworkPostRequest;
import com.technicaltask.dto.response.SocialNetworkPostListResponse;
import com.technicaltask.dto.response.SocialNetworkPostResponse;
import com.technicaltask.exception.ResourceNotFoundException;
import com.technicaltask.exception.message.ErrorMessage;
import com.technicaltask.repository.SocialNetworkPostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SocialNetworkPostService {

    private SocialNetworkPostRepository socialNetworkPostRepository;


    public void createNewSocialNetworkPost(SocialNetworkPostRequest socialNetworkPostRequest) {
        SocialNetworkPost socialNetworkPost = new SocialNetworkPost();
        socialNetworkPost.setPostDate(socialNetworkPostRequest.getPostDate());
        socialNetworkPost.setAuthor(socialNetworkPostRequest.getAuthor());
        socialNetworkPost.setContent(socialNetworkPostRequest.getContent());
        socialNetworkPost.setViewCount(socialNetworkPostRequest.getViewCount());
        socialNetworkPostRepository.save(socialNetworkPost);
    }

    public SocialNetworkPostResponse findSocialNetworkPostById(String id) {
       SocialNetworkPost socialNetworkPost = socialNetworkPostRepository.findById(Long.valueOf(id)).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessage.SOCIALNETWORKPOST_NOT_FOUND_MESSAGE,id))
                );
       SocialNetworkPostResponse socialNetworkPostResponse = new SocialNetworkPostResponse();
       socialNetworkPostResponse.setPostDate(socialNetworkPost.getPostDate());
       socialNetworkPostResponse.setAuthor(socialNetworkPost.getAuthor());
       socialNetworkPostResponse.setViewCount(socialNetworkPost.getViewCount());
       socialNetworkPostResponse.setContent(socialNetworkPost.getContent());
       return socialNetworkPostResponse;
    }

    public SocialNetworkPostListResponse getAllSocialNetworkPosts() {
        List<SocialNetworkPost> socialNetworkPost = socialNetworkPostRepository.findAll();
        SocialNetworkPostListResponse socialNetworkPostListResponse = new SocialNetworkPostListResponse();
        socialNetworkPostListResponse.setSocialNetworkPostList(socialNetworkPost);
       /*ModelMapper modelMapper = new ModelMapper();
List<SocialNetworkPostListDTO> postListDTO = modelMapper.map(postList, new TypeToken<List<SocialNetworkPostListDTO>>(){}.getType());*/
        return socialNetworkPostListResponse;
    }

    public void updateSocialNetworkPostById(String id, SocialNetworkPostRequest socialNetworkPostRequest) {
        SocialNetworkPost socialNetworkPost = socialNetworkPostRepository.findById(Long.valueOf(id)).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessage.SOCIALNETWORKPOST_NOT_FOUND_MESSAGE,id))
        );
        socialNetworkPost.setContent(socialNetworkPostRequest.getContent());
        socialNetworkPost.setPostDate(socialNetworkPostRequest.getPostDate());
        socialNetworkPost.setAuthor(socialNetworkPostRequest.getAuthor());
        socialNetworkPost.setViewCount(socialNetworkPostRequest.getViewCount());
        socialNetworkPostRepository.save(socialNetworkPost);
    }
}
