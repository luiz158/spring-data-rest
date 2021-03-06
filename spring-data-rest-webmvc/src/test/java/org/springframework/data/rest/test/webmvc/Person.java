package org.springframework.data.rest.test.webmvc;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Version;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * @author Jon Brisbin <jbrisbin@vmware.com>
 */
@Entity
public class Person {

  @Id @GeneratedValue private Long                 id;
  private                     String               name;
  @RestResource(path = "version")
  @Version
  private                     Long                 version;
  @JsonManagedReference
  @OneToMany(cascade = CascadeType.REMOVE)
  private                     List<Address>        addresses;
  @OneToMany(cascade = CascadeType.REMOVE)
  @MapKey(name = "type")
  private                     Map<String, Profile> profiles;
  private                     Date                 created;

  public Person() {
  }

  public Person(Long id, String name, List<Address> addresses, Map<String, Profile> profiles) {
    this.id = id;
    this.name = name;
    this.addresses = addresses;
    this.profiles = profiles;
  }

  public Person(String name, List<Address> addresses, Map<String, Profile> profiles) {
    this.name = name;
    this.addresses = addresses;
    this.profiles = profiles;
  }

  public Person(String name, Map<String, Profile> profiles) {
    this.name = name;
    this.profiles = profiles;
  }

  public Person(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public Map<String, Profile> getProfiles() {
    return profiles;
  }

  public void setProfiles(Map<String, Profile> profiles) {
    this.profiles = profiles;
  }

  public Date getCreated() {
    return created;
  }

  @PrePersist
  private void setCreated() {
    this.created = Calendar.getInstance().getTime();
  }

}
