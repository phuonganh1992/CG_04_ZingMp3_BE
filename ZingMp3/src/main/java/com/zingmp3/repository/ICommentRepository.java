package com.zingmp3.repository;

import com.zingmp3.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends PagingAndSortingRepository<Comment,Long> {
}
