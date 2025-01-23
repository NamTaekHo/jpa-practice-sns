package com.springboot.hashtag.entity;

import com.springboot.audit.BaseEntity;
import com.springboot.post_hashtag.entity.PostHashtag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hashtag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hashtagId;

    @Column(length = 255, nullable = false, unique = true)
    private String tagName;

    @OneToMany(mappedBy = "hashtag")
    private List<PostHashtag> postHashtags = new ArrayList<>();

    public void setPostHashtag(PostHashtag postHashtag){
        this.getPostHashtags().add(postHashtag);
        if(postHashtag.getHashtag() != this){
            postHashtag.setHashtag(this);
        }
    }

}
