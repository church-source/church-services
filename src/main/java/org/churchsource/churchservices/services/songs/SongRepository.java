package org.churchsource.churchservices.services.songs;

import org.churchsource.churchservices.repository.AbstractRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class SongRepository extends AbstractRepository<SongItem> {
    public Integer getNumberOfTimesChosen(String songCode, LocalDate startDate, LocalDate endDate) {
        try {
            return entityManager.createNamedQuery(SongNamedQueryConstants.NAME_COUNT_SERVICES_WHERE_SONG_WAS_CHOSEN, Long.class)
                    .setParameter("includeDeleted", false)
                    .setParameter("songCode", songCode)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .setMaxResults(1)
                    .getSingleResult().intValue();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
