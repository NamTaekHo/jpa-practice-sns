package com.springboot.post.entity;

import com.springboot.audit.BaseEntity;
import com.springboot.comment.entity.Comment;
import com.springboot.post_hashtag.entity.PostHashtag;
import com.springboot.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;

    @Column(length = 255, nullable = false)
    private String content;

    @Column(nullable = false)
    private long likeCount;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<PostHashtag> postHashtags = new ArrayList<>();

    public void setUser(User user){
        if(!user.getPosts().contains(this)){
            user.setPost(this);
        }
        this.user = user;
    }

    public void setComment(Comment comment){
        if(comment.getPost() != this){
            comment.setPost(this);
        }
        this.comments.add(comment);
    }

    public void setPostHashtag(PostHashtag postHashtag){
        if(postHashtag.getPost() != this){
            postHashtag.setPost(this);
        }
        this.postHashtags.add(postHashtag);
    }






}
