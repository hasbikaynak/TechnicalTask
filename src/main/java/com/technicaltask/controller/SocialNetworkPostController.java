package com.technicaltask.controller;

import com.technicaltask.dto.request.SocialNetworkPostRequest;
import com.technicaltask.dto.response.ResponseMessage;
import com.technicaltask.dto.response.SocialNetworkPostListResponse;
import com.technicaltask.dto.response.SocialNetworkPostResponse;
import com.technicaltask.dto.response.TTResponse;
import com.technicaltask.rest.RestApi;
import com.technicaltask.service.SocialNetworkPostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(RestApi.SOCIAL_NETWORK_POST) //  /api/v1/socialnetworkpost
@AllArgsConstructor
public class SocialNetworkPostController {

    private SocialNetworkPostService socialNetworkPostService;

    @PostMapping(RestApi.ADD_NEW_SOCIAL_NETWORK_POST)  //  //api/v1/socialnetworkpost/add
    public ResponseEntity<TTResponse> saveNewSocialNetworkPost(@Valid @RequestBody SocialNetworkPostRequest socialNetworkPostRequest) {
        socialNetworkPostService.createNewSocialNetworkPost(socialNetworkPostRequest);
        TTResponse response = new TTResponse(ResponseMessage.SOCIAL_NETWORK_POST_SAVE_RESPONSE_MESSAGE, true);
        return ResponseEntity.ok(response);
    }

    @GetMapping(RestApi.GET_SOCIAL_NETWORK_POST_BY_ID)  //  //api/v1/socialnetworkpost/1
    public ResponseEntity<SocialNetworkPostResponse> getSocialNetworkPostById(@PathVariable String id){
       SocialNetworkPostResponse socialNetworkPostResponse = socialNetworkPostService.findSocialNetworkPostById(id);
       return ResponseEntity.ok(socialNetworkPostResponse);
    }

    @GetMapping(RestApi.GET_ALL_SOCIAL_NETWORK_POST)  //  //api/v1/socialnetworkpost/getAll
    public ResponseEntity<SocialNetworkPostListResponse> getAllSocialNetworkPost(){
        SocialNetworkPostListResponse socialNetworkPostResponseList = socialNetworkPostService.getAllSocialNetworkPosts();
        return ResponseEntity.ok(socialNetworkPostResponseList);
    }

    @PutMapping(RestApi.UPDATE_SOCIAL_NETWORK_BY_ID)   //  //api/v1/socialnetworkpost/1
    public ResponseEntity<TTResponse> updateSocialNetworkPost(@PathVariable String id, @Valid @RequestBody SocialNetworkPostRequest socialNetworkPostRequest){
        socialNetworkPostService.updateSocialNetworkPostById(id,socialNetworkPostRequest);
        TTResponse response = new TTResponse(ResponseMessage.SOCIAL_NETWORK_POST_UPDATE_RESPONSE_MESSAGE, true);
        return ResponseEntity.ok(response);
    }
}
