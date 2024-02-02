package kr.co.yigil.comment.domain.repository;

import java.util.List;
import java.util.Optional;
import kr.co.yigil.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Long>  {

    @Query("SELECT c FROM Comment c " +
            "LEFT JOIN FETCH c.parent " +
            "WHERE c.travel.id = :travelId " +
            "ORDER BY c.parent.id ASC NULLS FIRST, c.createdAt ASC")
    List<Comment> findCommentListByTravelId(@Param("travelId") Long travelId);

    List<Comment> findByTravelIdOrderById(Long travelId);

    boolean existsByMemberIdAndId(Long memberId, Long commentId);

    @Query("SELECT c FROM Comment c WHERE c.travel.id = :travelId AND c.parent IS NULL "
        + "ORDER BY c.createdAt ASC "
    )
    List<Comment> findParentCommentsByTravelId(@Param("travelId") Long travelId);

    @Query("SELECT c FROM Comment c WHERE c.travel.id = :travelId AND c.isDeleted = false AND c.parent.id = :parentId "
        + "ORDER BY c.createdAt ASC "
    )
    List<Comment> findChildCommentsByTravelIdAndParentId(@Param("travelId") Long travelId, @Param("parentId") Long parentId);

    @Query("SELECT COUNT(c) FROM Comment c WHERE c.travel.id = :travelId AND c.isDeleted = false")
    int countNonDeletedCommentsByTravelId(@Param("travelId") Long travelId);

    Optional<Comment> findByIdAndMemberId(Long commentId, Long memberId);
}
