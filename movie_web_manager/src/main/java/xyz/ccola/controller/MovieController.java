package xyz.ccola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ccola.domain.Movie;
import xyz.ccola.service.MovieService;

import java.util.List;

/**
 * @ Name: MovieController
 * @ Author: Cola
 * @ Time: 2022/12/16 16:48
 * @ Description: MovieController
 */
@RestController
@RequestMapping("/admin/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * 查询所有
     * @return Movie 集
     */
    @RequestMapping("/findAll")
    public List<Movie> findAll(){
        return movieService.selectList(null);
    }

    /**
     * 保存 Movie
     * @param movie movie
     * @return count
     */
    @RequestMapping("/save")
    public Integer insert(@RequestBody Movie movie){

        if(movie.getId() == null){
            return movieService.insert(movie);

        }else {
            return movieService.updateById(movie);
        }

    }

    /**
     * 根据 id 查询
     * @param id id
     * @return Movie
     */
    @RequestMapping("/findById")
    public Movie findById(Integer id){
        return movieService.selectById(id);
    }


    /**
     * 根据 id 删除
     * @param id id
     * @return count
     */
    @RequestMapping("/deleteById")
    public Integer deleteById(Integer id){
        return movieService.deleteById(id);
    }

    /**
     * 根据 id 批量删除
     * @param ids ids
     */
    @RequestMapping("/deleteByIds")
    public void deleteByIds(Integer[] ids){
        movieService.deleteByIds(ids);
    }
}
