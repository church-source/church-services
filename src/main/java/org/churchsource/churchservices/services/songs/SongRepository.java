package org.churchsource.churchservices.services.songs;

import org.churchsource.churchservices.model.type.ServiceType;
import org.churchsource.churchservices.repository.AbstractRepository;
import org.churchsource.churchservices.services.ChurchService;
import org.churchsource.churchservices.services.ServiceNamedQueryConstants;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class SongRepository extends AbstractRepository<SongItem> {


}
