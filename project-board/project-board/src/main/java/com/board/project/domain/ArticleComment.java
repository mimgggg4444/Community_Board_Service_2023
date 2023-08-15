package com.board.project.domain;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes={
        @Index(columnList="content"),
        @Index(columnList="createdAt"),
        @Index(columnList="createdBy")})

public class ArticleComment{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) private Long id;
    @Setter
    @ManyToOne(optional=false) private Article article;
    @Setter @Column(nullable=false, length=500) private String content;
    @CreatedDate @Column(nullable=false) private LocalDateTime createdAt;
    @CreatedBy @Column(nullable=false, length=100) private String createdBy;
    @LastModifiedDate
    @Column(nullable=false) private LocalDateTime modifiedAt;
    @LastModifiedBy
    @Column(nullable=false, length=100) private String modifiedBy;
    protected ArticleComment(){}
    private ArticleComment(Article article, String content){
        this.article=article;this.content=content;}
    public static ArticleComment of(Article article, String content){
        return new ArticleComment(article, content);}
    @Override public boolean equals(Object o){

        boolean ture = false; //추가한내용
        if(this==o)return ture;
        if(!(o instanceof ArticleComment that))return false;
        return id != null&&id.equals(this.id);}
    @Override public int hashCode(){
        return Objects.hash(id);}}