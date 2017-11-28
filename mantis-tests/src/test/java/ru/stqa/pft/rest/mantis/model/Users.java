package ru.stqa.pft.rest.mantis.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/*public class Users extends ForwardingSet<GroupData> {

  private Set<GroupData> delegate;

  public Users(Groups groups) {
    this.delegate = new HashSet<GroupData>(groups.delegate);
  }

  public Users() {
    this.delegate = new HashSet<GroupData>();
  }

  public Users(Collection<GroupData> groups) {
    this.delegate = new HashSet<GroupData>(groups);
  }

  public Set<GroupData> getDelegate() {
    return delegate;
  }

  @Override
  protected Set<GroupData> delegate() {
    return delegate;
  }
  public Groups withAdded(GroupData group) {
    Groups groups = new Groups(this);
    groups.add(group);
    return groups;
  }

  public Groups without(GroupData group) {
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }


}
*/