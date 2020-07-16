package com.example.springdemo.businessSchool.mapper;

import com.example.springdemo.businessSchool.data.entity.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 19:22 2020/7/1
 * @ Modified By：
 * @Version: 1.0.0
 */
//public interface ScoreJpaRepository extends BaseRepository<Score, Serializable>, JpaSpecificationExecutor<Score> {
public interface ScoreJpaRepository extends JpaRepository<Score,Integer>{

    @Query(value = "select * from  Score where Score.score > 90",nativeQuery = true)
    List<Score> getScoreByScoreCondition();

    @Query(value = "select * from  Score where Score.score > ?1",nativeQuery = true)
    public List<Score> getScoreByScore(int score );

    @Query(value = "select count(*) from  Score where Score.score > ?1",nativeQuery = true)
    int getCountByScore(int score);

//
//    List queryScoreAll();
//
////    List<Score> findOne(String identity);
//    /**
//     * 根据接口组标示查询实体；
//     */
//    List<Score> findByIdentity(String identity);
//
//    /**
//     * 根据供应商id查询分组列表
//     *
//     * @param providerId
//     * @return
//     */
//    @Query(value = "SELECT pgm.groupId FROM Port p, PortGroupMapping pgm where p.provider.id=?1 and p.id=pgm.portId")
//    List<Long> findGroupByProviderId(Long providerId);
//
//    /**
//     * 保存
//     *
//     * @return
//     */
//    @Override
////    @CacheChangeAnn(value = CacheNameEnum.PORT_GROUP, sign = CacheSignEnum.SAVE_OR_UPDATE)
//    Score save(Score score);
//
//    /**
//     * 删除
//     *
//     * @param id
//     */
//    @Override
////    @CacheChangeAnn(value = CacheNameEnum.PORT_GROUP, sign = CacheSignEnum.DELETE)
//    void deleteById(Serializable id);
//
//    /**
//     * 查询所有分组DTO
//     *
//     * @return
//     */
//    @Query("select new com.skyon.lily.common.dto.PortGroupDTO(pg.id,pg.name,pg.identity,pg.groupOrderStrategy,pg.dataAccessStrategy,pg.groupType) from PortGroup pg")
//    List<Score> findAllDTO();
//
//    List<Score> findAllByNameOrIdentity(String name,String identity);

}
