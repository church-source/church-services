package org.churchsource.churchservices.services;

public class ServiceNamedQueryConstants {
  public static final String NAME_GET_ALL_SERVICES = "ChurchService.getAllServices";
  public static final String QUERY_GET_ALL_SERVICES = "SELECT s FROM ChurchService s "
      + "WHERE :includeDeleted = TRUE OR s.deleted = false "
      + "ORDER BY firstName ASC";

  public static final String NAME_FIND_SERVICE_BY_ID = "ChurchService.findServiceById";
  public static final String QUERY_FIND_SERVICE_BY_ID = "SELECT s FROM ChurchService s WHERE s.id = :id";

}
