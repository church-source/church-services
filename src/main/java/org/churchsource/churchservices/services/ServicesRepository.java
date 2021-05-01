package org.churchsource.churchservices.services;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.churchsource.churchservices.repository.AbstractRepository;
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
}
