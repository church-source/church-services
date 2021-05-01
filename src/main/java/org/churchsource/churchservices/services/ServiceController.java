package org.churchsource.churchservices.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value="/services")
@Slf4j
public class ServiceController {

  @Autowired
  private ServicesRepository servicesRepository;

  @Autowired
  private ServiceFactory serviceFactory;

  @PersistenceContext
  private EntityManager entityManager;
  
  @GetMapping("/{id}")
  @PreAuthorize("hasAuthority('ViewService')")
  public ServiceFullViewModel getService(@PathVariable Long id) {
    ChurchService foundChurchService = servicesRepository.findEntityById(id);
    System.out.println("FoundChurchService" + foundChurchService);
    if(foundChurchService != null) {
      return serviceFactory.createServiceFullViewModelFromEntity(foundChurchService);
    } else {
      return null;
    }
  }

  @GetMapping
  @PreAuthorize("hasAuthority('ViewService')")
  public List<ServiceFullViewModel> getAllServices() {

    List<ChurchService> churchServices = servicesRepository.getAllServices();
    return convertListOfServicesToListOfServicesViewModels(churchServices);
  }

  private List<ServiceFullViewModel> convertListOfServicesToListOfServicesViewModels(List<ChurchService> churchServices) {
    List<ServiceFullViewModel> serviceViewModels = churchServices.stream()
            .map(churchService -> serviceFactory.createServiceFullViewModelFromEntity(churchService))
            .collect(Collectors.toList());
    return serviceViewModels;
  }

  @RequestMapping(method = RequestMethod.POST)
  @PreAuthorize("hasAuthority('AddService')")
  public ServiceFullViewModel addService(@RequestBody ServiceBackingForm form) {
      System.out.println(form);
    ChurchService createdChurchService = servicesRepository.save(serviceFactory.createServiceEntity(form));
    if(createdChurchService != null) {
      return serviceFactory.createServiceFullViewModelFromEntity(createdChurchService);
    } else {
      return null;
    }
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @PreAuthorize("hasAuthority('AddService')")
  public HttpStatus deleteService(@PathVariable Long id) {
    servicesRepository.deleteService(id);
    return HttpStatus.NO_CONTENT;
  }

  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
  //TODO temp fix for cross origin. this must be fixed later
  @CrossOrigin
  @PreAuthorize("hasAuthority('EditServices')")
  public ServiceFullViewModel updatePerson(@PathVariable Long id, @RequestBody ServiceBackingForm form) throws Exception {
    //TODO add validator to check if all fields are valid
    if(id == null || form == null) {
      throw new Exception ("Invalid Request"); // TODO to be replaced with validator
    }
    if(form.getId() != null && id != form.getId()) {
      throw new Exception ("If ID is in Path and message body they must be equal. "); // TODO to be replaced with validator
    }
    form.setId(id);
    ChurchService updatedChurchService = servicesRepository.updateService(serviceFactory.createServiceEntity(form));
    if(updatedChurchService != null) {
      return serviceFactory.createServiceFullViewModelFromEntity(updatedChurchService);
    } else {
      return null;
    }
  }
}
