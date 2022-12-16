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

    @RequestMapping("/findAll")
    public List<Movie> findAll(){
        return movieService.selectList(null);
    }

    @RequestMapping("/save")
    public Integer insert(@RequestBody Movie movie){

        if(movie.getId() == null){
            return movieService.insert(movie);

        }else {
            return movieService.updateById(movie);
        }

    }

    @RequestMapping("/findById")
    public Movie findById(Integer id){
        return movieService.selectById(id);
    }


    @RequestMapping("/deleteById")
    public int deleteById(Integer id){
        return movieService.deleteById(id);
    }

    //根据id批量删除
    @RequestMapping("/deleteByIds")
    public void deleteByIds(Integer[] ids){
        movieService.deleteByIds(ids);
    }
}
