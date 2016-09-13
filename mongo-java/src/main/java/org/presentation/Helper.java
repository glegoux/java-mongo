package org.presentation;

import com.google.gson.Gson;

public class Helper {

  public static final String toJson(Object o) {
    Gson gson = new Gson();
    return gson.toJson(o);
  }

  public static final Object fromJson(String json) {
    Gson gson = new Gson();
    return gson.toJson(json);
  }

}
