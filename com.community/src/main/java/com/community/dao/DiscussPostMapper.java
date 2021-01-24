package com.community.dao;

import com.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DiscussPostMapper {
    //orderMode排序方式，是按照最热的排，还是默认的
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit, int orderMode);

    // @Param注解用于给参数取别名,
    // 如果只有一个参数,并且在<if>里使用,则必须加别名.
    int selectDiscussPostRows(@Param("userId") int userId);
    //发布帖子
    int insertDiscussPost(DiscussPost discussPost);

    //查询帖子的详情
    DiscussPost selectDiscussPostById(int id);

    //更新评论数量
    int updateCommentCount(int id, int commentCount);

    //修改帖子类型
    int updateType(int id, int type);

    //修改帖子状态
    int updateStatus(int id, int status);

    //更新分数
    int updateScore(int id, double score);
}
