package com.springboot.post_hashtag.entity;

import com.springboot.audit.BaseEntity;
import com.springboot.hashtag.entity.Hashtag;
import com.springboot.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PostHashtag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postHashtagId;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "HASHTAG_ID")
    private Hashtag hashtag;

    public void setPost(Post post){
        if(!post.getPostHashtags().contains(this)){
            post.setPostHashtag(this);
        }
        this.post = post;
    }

    public void setHashtag(Hashtag hashtag){
        if(!hashtag.getPostHashtags().contains(this)){
            hashtag.setPostHashtag(this);
        }
        this.hashtag = hashtag;
    }


}
