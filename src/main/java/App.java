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
            model.put("template", "templates.rangers.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());




    }
}
