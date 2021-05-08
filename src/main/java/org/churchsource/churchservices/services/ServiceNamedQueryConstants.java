package org.churchsource.churchservices.services;

public class ServiceNamedQueryConstants {
  public static final String NAME_GET_ALL_SERVICES = "ChurchService.getAllServices";
  public static final String QUERY_GET_ALL_SERVICES = "SELECT s FROM ChurchService s "
      + "WHERE :includeDeleted = TRUE OR s.deleted = false "
      + "ORDER BY s.serviceDate ASC";

  public static final String NAME_FIND_SERVICE_BY_ID = "ChurchService.findServiceById";
  public static final String QUERY_FIND_SERVICE_BY_ID = "SELECT s FROM ChurchService s WHERE s.id = :id";

  public static final String NAME_GET_SERVICES_BY_DATE_AND_TYPE = "ChurchService.findServiceByDateAndType";
  public static final String QUERY_GET_SERVICES_BY_DATE_AND_TYPE = "SELECT s FROM ChurchService s WHERE " +
          "(:includeDeleted = TRUE OR s.deleted = false) " +
          "AND (:type is null OR s.serviceType = :type) " +
          "AND s.serviceDate = :date";

  public static final String NAME_GET_SERVICES_BETWEEN_DATES = "ChurchService.findServiceBetweenDates";
  public static final String QUERY_GET_SERVICES_BETWEEN_DATES = "SELECT s FROM ChurchService s WHERE " +
          "(:includeDeleted = TRUE OR s.deleted = false) " +
          "AND s.serviceDate >= :startDate AND s.serviceDate < :endDate";
}
