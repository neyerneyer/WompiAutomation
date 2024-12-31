package com.wompi.utils;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;

public abstract class ApiInteraction implements Task {

    protected static class ResponseBody<T> implements Question<T> {
       private final Class<T> tclass;

       public ResponseBody(Class<T> tclass) {
           this.tclass = tclass;
       }
       @Override
       public T answeredBy(Actor actor) {
           return  SerenityRest.lastResponse().body().jsonPath().getObject("",tclass);
       }
   }
   public static Question<Integer> getStatusCode(){
       return Question.about("status code").answeredBy(actor -> SerenityRest.lastResponse().statusCode());
   }
    public static Question<Object> getFieldFromJson(String fieldPath) {
        return Question.about("field from JSON response: " + fieldPath)
                .answeredBy(actor -> SerenityRest.lastResponse().jsonPath().get(fieldPath));
    }
    public static Question<String> getResponseBodyAsString() {
        return Question.about("response body as string")
                .answeredBy(actor -> SerenityRest.lastResponse().getBody().asString());
    }
}
