package com.board.project.domain;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Getter
@ToString
@Table(indexes={@Index(columnList="content"),
        @Index(columnList="createdAt"),@Index(columnList="createdBy")})

public class ArticleComment{@Id
@GeneratedValue(strategy= GenerationType.IDENTITY) private Long id;
    @Setter
    @ManyToOne(optional=false) private Article article;
    @Setter
    @Column(nullable=false, length=500)
    @CreatedDate
    @Column(nullable=false) private LocalDateTime createdAt;
    @CreatedBy
    @Column(nullable=false, length=100) private String createdBy;
    @LastModifiedDate
    @Column(nullable=false) private LocalDateTime modifiedAt;
    @LastModifiedBy
    @Column(nullable=false, length=100) private String modifiedBy;
    protected ArticleComment(){}
    private ArticleComment(Article article, String content)
    {this.article=article;this.content=content;}
    public static ArticleComment of(Article article, String content)
    {return new ArticleComment(article, content);}
    @Override public boolean equals(Object o)
    {if(this==o)return ture;if(!(o instanceof ArticleComment that))return false;
        return id != null&&id.equals(this.id);}
    @Override public int hashCode(){return Objects.hash(id);}}
