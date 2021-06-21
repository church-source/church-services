package org.churchsource.churchservices.services;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.churchsource.churchservices.model.type.ServiceType;
import org.churchsource.churchservices.repository.AbstractRepository;
import org.churchsource.churchservices.services.songs.SongNamedQueryConstants;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class ServicesRepository extends AbstractRepository<ChurchService> {

  public List<ChurchService> getAllServices() {
    return entityManager.createNamedQuery(ServiceNamedQueryConstants.NAME_GET_ALL_SERVICES, ChurchService.class)
        .setParameter("includeDeleted", false)
        .getResultList();
  }

  public List<ChurchService> findEntityByDateAndType(LocalDate date, ServiceType type) {
    return entityManager.createNamedQuery(ServiceNamedQueryConstants.NAME_GET_SERVICES_BY_DATE_AND_TYPE, ChurchService.class)
            .setParameter("date", date)
            .setParameter("type", type)
            .setParameter("includeDeleted", false)
            .getResultList();
  }

  public List<ChurchService> findEntityBetweenDates(LocalDate startDate, LocalDate endDate) {
    return entityManager.createNamedQuery(ServiceNamedQueryConstants.NAME_GET_SERVICES_BETWEEN_DATES, ChurchService.class)
            .setParameter("startDate", startDate)
            .setParameter("endDate", endDate)
            .setParameter("includeDeleted", false)
            .getResultList();
  }

  public ChurchService findServiceById(Long id) throws NoResultException {
    return entityManager.createNamedQuery(ServiceNamedQueryConstants.NAME_FIND_SERVICE_BY_ID, ChurchService.class)
        .setParameter("id", id)
        .getSingleResult();
  }

  public ChurchService updateService(ChurchService churchService) {
    ChurchService existingChurchService = findServiceById(churchService.getId());
    ChurchService updatedChurchService = new ChurchService();
    existingChurchService.mergeEntities(churchService, updatedChurchService);
    return update(updatedChurchService);
  }

  public void deleteService(Long serviceId) {
    ChurchService churchServiceToDelete = findServiceById(serviceId);
    churchServiceToDelete.setDeleted(true);
    update(churchServiceToDelete);
  }

  public ChurchService getLastServiceChosen(String songCode, LocalDate date) {
    try {
      return entityManager.createNamedQuery(ServiceNamedQueryConstants.NAME_GET_LAST_SERVICE_CHOSEN, ChurchService.class)
              .setParameter("includeDeleted", false)
              .setParameter("songCode", songCode)
              .setParameter("date", date)
              .setMaxResults(1)
              .getSingleResult();
    } catch (NoResultException nre) {
      return null;
    }
  }

}
