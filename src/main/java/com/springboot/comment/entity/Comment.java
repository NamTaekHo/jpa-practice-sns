package com.springboot.comment.entity;

import com.springboot.audit.BaseEntity;
import com.springboot.post.entity.Post;
import com.springboot.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    @Column(length = 255, nullable = false)
    private String textarea;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public void setPost(Post post){
        this.post = post;
        if(!post.getComments().contains(this)){
            post.setComment(this);
        }
    }
    // setUser 수정해야될 수도

}
