package org.churchsource.churchservices.services.songs;

public class SongNamedQueryConstants {
    public static final String NAME_COUNT_SERVICES_WHERE_SONG_WAS_CHOSEN = "SongItem.getNumberOfTimesChosen";
    public static final String QUERY_COUNT_SERVICES_WHERE_SONG_WAS_CHOSEN = "SELECT count(serv) FROM SongItem s " +
            "LEFT JOIN ChurchService serv ON (serv.id = s.service) " +
            "WHERE " +
            " (:includeDeleted = TRUE OR serv.deleted = false) " +
            "  AND serv.serviceDate < :endDate" +
            "  AND serv.serviceDate >= :startDate" +
            "  AND s.songCode = :songCode ";
}
