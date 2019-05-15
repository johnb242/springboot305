package com.example.springboot305;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    MovieRepository movieRepository;
    @RequestMapping("/")
    public String index(Model model){
        // First let's create an actor
        Actor actor = new Actor();
        actor.setName("sandra bullock");
        actor.setRealname("sandrea mae bullowski");
        //now let create a movie
        Movie movie = new Movie();
        movie.setTitle("indiana jones");
        movie.setYear(2017);
        movie.setDescription("about an adventure regarding archaeology");

        //add the movie to an empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        actor.setMovies(movies);

        actorRepository.save(actor);

        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }
}
