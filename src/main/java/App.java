import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);

        get("/", (request, response) -> {
            Map<String, Object>model = new HashMap<String, Object>();
            model.put("rangers", Rangers.all());
            model.put("template", "templates/index.vtl");
            return modelAndView(model,layout);
        }, new VelocityTemplateEngine());

        get("/rangers/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/rangersForm.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/rangers", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String firstName = request.queryParams("fname");
            String secondName = request.queryParams("sname");
            String badgeNumber= request.queryParams("badge");
            Rangers newRanger = new Rangers(firstName, secondName, badgeNumber);
            newRanger.save();
            response.redirect ("/");
            return null;
        });

        get("/rangers/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int id = Integer.parseInt(request.params("id"));
            Rangers ranger = Rangers.find(id);
            model.put("ranger", ranger);
            model.put("template", "templates/ranger.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/sightingForm/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            model.put("animals", Animals.all());
            model.put("endangeredAnimals", EndangeredAnimals.allEndangeredAnimals());
            model.put("template", "templates/sightingForm.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        post("/sightings", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            int animalId = Integer.parseInt(req.queryParams("animalId"));
            String location = req.queryParams("location");
            String name = req.queryParams("name");

            Sighting sighting = new Sighting(animalId, location, name);
            sighting.save();

            System.out.println(name + animalId + location);




            res.redirect("/sightings");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)

            );
        });

        get("/sightings", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("sightings", Sighting.allSighting());

            model.put("template", "templates/sightings.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

        get("/animalForm/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/animalForm.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        post("/animals", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String health = req.queryParams("health");
            String age = req.queryParams("age");
            if (req.queryParams("endangeredInput") != null) {
                if (!(name.trim().isEmpty() || health.trim().isEmpty() || age.trim().isEmpty())) {

                    EndangeredAnimals endangeredAnimal = new EndangeredAnimals(name, health, age);
                    endangeredAnimal.save();
                } else {
                    System.out.println("Please fill in all the fields");
                }
            } else {
                if (!(name.trim().isEmpty())) {
                    Animals animal = new Animals(name);
                    animal.save();
                } else {
                    System.out.println("Please fill in all the fields");
                }


            }
            res.redirect("/animals");

            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });

        get("/animals", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("animals", Animals.all());
            model.put("endangeredAnimals", EndangeredAnimals.allEndangeredAnimals());

            model.put("template", "templates/animals.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, layout)
            );
        });


    }
}
