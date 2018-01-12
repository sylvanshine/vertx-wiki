package io.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.jdbc.JDBCClient;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Future<Void> startFuture) throws Exception {
    Future<Void> steps = prepareDatabase().compose(v -> startHttpServer());
    steps.setHandler(startFuture.completer());
  }
  // tag::sql-fields[]
  private static final String SQL_CREATE_PAGES_TABLE = "create table if not exists Pages (Id integer identity primary key, Name varchar(255) unique, Content clob)";
  private static final String SQL_GET_PAGE = "select Id, Content from Pages where Name = ?"; // <1>
  private static final String SQL_CREATE_PAGE = "insert into Pages values (NULL, ?, ?)";
  private static final String SQL_SAVE_PAGE = "update Pages set Content = ? where Id = ?";
  private static final String SQL_ALL_PAGES = "select Name from Pages";
  private static final String SQL_DELETE_PAGE = "delete from Pages where Id = ?";
  // end::sql-fields[]

  // tag::db-and-logger[]
  private JDBCClient dbClient;

  private static final Logger LOGGER = LoggerFactory.getLogger(MainVerticle.class);
  // end::db-and-logger[]

  private Future<Void> prepareDatabase() {
    Future<Void> future = Future.future();
    // (...)
    return future;
  }

  private Future<Void> startHttpServer() {
    Future<Void> future = Future.future();
    // (...)
    return future;
  }
}

