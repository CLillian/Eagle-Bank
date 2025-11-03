package org.utils;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.Cookie;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.auth.User;
import io.vertx.ext.web.FileUpload;
import io.vertx.ext.web.ParsedHeaderValues;
import io.vertx.ext.web.RequestBody;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.Session;
import io.vertx.ext.web.UserContext;
import org.apache.commons.lang3.NotImplementedException;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockRoutingContext implements RoutingContext {
  
  private User user;
  private final Map<String, Object> data = new HashMap<>();
  
  @Override
  public HttpServerRequest request() {
    throw new NotImplementedException();
  }
  
  @Override
  public HttpServerResponse response() {
    throw new NotImplementedException();
  }
  
  @Override
  public void next() {
    throw new NotImplementedException();
  }
  
  @Override
  public void fail(int integer) {
    throw new NotImplementedException();
  }
  
  @Override
  public void fail(Throwable throwable) {
    throw new NotImplementedException();
  }
  
  @Override
  public void fail(int integer, Throwable throwable) {
    throw new NotImplementedException();
  }
  
  @Override
  public RoutingContext put(String string, Object object) {
    this.data.put(string, object);
    return this;
  }
  
  @Override
  public <T> T get(String string) {
    return (T) this.data.get(string);
  }
  
  @Override
  public <T> T get(String string, T templateArgument) {
    return (T) this.data.get(string);
  }
  
  @Override
  public <T> T remove(String string) {
    T object = (T) this.data.get(string);
    this.data.remove(string);
    return object;
  }
  
  @Override
  public Map<String, Object> data() {
    return this.data;
  }
  
  @Override
  public Vertx vertx() {
    throw new NotImplementedException();
  }
  
  @Override
  public String mountPoint() {
    throw new NotImplementedException();
  }
  
  @Override
  public Route currentRoute() {
    throw new NotImplementedException();
  }
  
  @Override
  public String normalizedPath() {
    throw new NotImplementedException();
  }
  
  @Override
  public RequestBody body() {
    throw new NotImplementedException();
  }
  
  @Override
  public List<FileUpload> fileUploads() {
    throw new NotImplementedException();
  }
  
  @Override
  public void cancelAndCleanupFileUploads() {
  
  }
  
  @Override
    public Session session() {
      throw new NotImplementedException();
    }
    
    @Override
    public boolean isSessionAccessed() {
      throw new NotImplementedException();
    }
  
  @Override
  public UserContext userContext() {
    return null;
  }
  
  @Override
    public User user() {
      return user;
    }
    
    @Override
    public Throwable failure() {
      throw new NotImplementedException();
    }
    
    @Override
    public int statusCode() {
      throw new NotImplementedException();
    }
    
    @Override
    public String getAcceptableContentType() {
      throw new NotImplementedException();
    }
    
    @Override
    public ParsedHeaderValues parsedHeaders() {
      throw new NotImplementedException();
    }
    
    @Override
    public int addHeadersEndHandler(Handler<Void> handler) {
      throw new NotImplementedException();
    }
    
    @Override
    public boolean removeHeadersEndHandler(int integer) {
      throw new NotImplementedException();
    }
    
    @Override
    public int addBodyEndHandler(Handler<Void> handler) {
      throw new NotImplementedException();
    }
    
    @Override
    public boolean removeBodyEndHandler(int integer) {
      throw new NotImplementedException();
    }
    
    @Override
    public int addEndHandler(Handler<AsyncResult<Void>> handler) {
      throw new NotImplementedException();
    }
    
    @Override
    public boolean removeEndHandler(int integer) {
      throw new NotImplementedException();
    }
    
    @Override
    public boolean failed() {
      throw new NotImplementedException();
    }
    
    @Override
    public void setAcceptableContentType(String string) {
      throw new NotImplementedException();
    }
    
    @Override
    public void reroute(HttpMethod httpMethod, String string) {
      throw new NotImplementedException();
    }
    
    @Override
    public Map<String, String> pathParams() {
      throw new NotImplementedException();
    }
    
    @Override
    public String pathParam(String string) {
      throw new NotImplementedException();
    }
    
    @Override
    public MultiMap queryParams() {
      throw new NotImplementedException();
    }
    
    @Override
    public MultiMap queryParams(Charset charset) {
      throw new NotImplementedException();
    }
    
    @Override
    public List<String> queryParam(String string) {
      throw new NotImplementedException();
    }
}
